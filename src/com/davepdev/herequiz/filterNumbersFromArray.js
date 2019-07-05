
function filterNumbersFromArray(arr) {
   var newArray = [];
   for (var i = 0; i < arr.length; i++ ) {
       if (!isNaN(arr[i]) ) {
            newArray.push(arr[i]);
        }
   }
   arr = newArray;
   return arr;
}


var arr = [1, 'a', 'b', 2];

console.log(filterNumbersFromArray(arr));
//console.log(arr);

