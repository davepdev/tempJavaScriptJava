
/**
 * 
 * @author davepdev
 * working through testdome's javascript interview questions
 * 
 */



// test for param type
function ensure(value) {
  // 67% with this
  //if ( typeof value === "undefined" || value === undefined || value === null || !value ) {
  //  throw "Error";
  //}
  //return value; 
  //
  // working answer from:
  // https://stackoverflow.com/questions/44874410/javascript-function-should-throw-an-error-if-called-without-arguments-or-an-argu
  
  if (value !== undefined) return value;
  throw 'Error'; 
}

// remove property
function removeProperty(obj, prop) {
  // 50% with this
  // if (obj.hasOwnProperty(prop) || prop in obj) {
  //  delete obj.prop;
  //  return true;
  //}
  //return false;
  // working answer from: https://github.com/hopeogbons/TESTDOME
  return (Object.keys(obj).indexOf(prop) > -1) ? delete obj[prop] : false;
}

//--------------------------------------------

// take number, add digits, if sum is < 10: were done. 
// else, add digits, repeat.
function createCheckDigit(membershipId) {
	// 100%

  var workingId = membershipId;  

  var idSum = 0;
  var done = false;
  while (!done) {
    var walkSum = 0;
    console.log("start of while: " + workingId);
    console.log("length of workingId: " + workingId.length);
    for (var i = 0; i < workingId.length; i++) {
      console.log("num is:" + workingId[i]);
      walkSum += Number(workingId[i]);
      console.log("walksum is: " + walkSum);
    }
    console.log(walkSum);
    workingId = String(walkSum);
    if (workingId < 10) {
 	done = true;
	console.log("ending with workingid of : " + workingId);
        return workingId;
    }
  }
  console.log("ended this way. ");
}

console.log(createCheckDigit("55555"));

//-------------------------------------------

//split, string manipulation, casting types


function formatDate(userDate) {
	// 100%
   var listX = userDate.split("/");
   return (String(listX[2]) + digPad(listX[0]) + digPad(listX[1]));
}

function digPad(num) {
	// 100%
  if (num > 9) {
    return String(num);
  }
  
  return "0" + String(num);
}

console.log(formatDate("12/31/2014"));

//-----------------------------------------
//adding click handler to elements, removing elements

function setup() {
  var elements = document.querySelectorAll("button.remove");
  console.log(elements);
  for (var i = 0; i < elements.length; i++) {
    elements[i].addEventListener("click", doIt);
    console.log("added listner");
  }
}

function doIt() { this.parentElement.remove(); }

// Example case. 
document.body.innerHTML = `
<div class="image">
  <img src="https://goo.gl/kjzfbE" alt="First">
  <button class="remove">X</button>
</div>
<div class="image">
  <img src="https://goo.gl/d2JncW" alt="Second">
  <button class="remove">X</button>
</div>`;

setup();

document.getElementsByClassName("remove")[0].click();
console.log(document.body.innerHTML);

//-----------------------

// closures
// Fix the bugs in the registerHandlers function. An alert should display anchor's zero-based index within a 
// document instead of following the link.

document.body.innerHTML = `<body>
  In my life, I used the following web search engines:<br/>
  <a href="//www.yahoo.com">Yahoo!</a><br/>
  <a href="//www.altavista.com">AltaVista</a><br/>
  <a href="//www.google.com">Google</a><br/>
</body>`


function registerHandlers() {
  var as = document.getElementsByTagName('a');
  
  function generateIndexHandler(idx) {
    return function indexHandler() {
      alert(idx);
      false;
    }
  }
  
  
  for (var i = 0, l = as.length; i < l ;  i++) {
    as[i].onclick = generateIndexHandler(i);
  }
}

/* HTML code for testing purposes (do not submit uncommented):
<body>
  In my life, I used the following web search engines:<br/>
  <a href="//www.yahoo.com">Yahoo!</a><br/>
  <a href="//www.altavista.com">AltaVista</a><br/>
  <a href="//www.google.com">Google</a><br/>
</body>
*/

//-----------------
// Function appendChildren should add a new child div to each existing div. 
// New divs should be decorated by calling decorateDiv.

function appendChildren(decorateDivFunction) {
  // used querySelectorAll instead of getElementsByTagName
  // because getElementsByTagName returns a live NodeList and makes an infinite loop
  // https://stackoverflow.com/questions/29605980/appending-child-div-to-each-div-with-for-loop/49824809

  var allDivs = document.querySelectorAll("div");

  // loop based on allDivs length
  for (var i = 0; i < allDivs.length; i++) {
    // create new element div
    var newDiv = document.createElement("div");
    decorateDivFunction(newDiv);
    
    // append new div into curent div
    allDivs[i].appendChild(newDiv);
  }
}



// Example case. 
document.body.innerHTML = `
<div id="a">
  <div id="b">
  </div>
</div>`;

appendChildren(function(div) {});
console.log(document.body.innerHTML);