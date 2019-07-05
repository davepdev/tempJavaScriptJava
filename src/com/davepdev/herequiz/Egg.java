package com.davepdev.herequiz;

public class Egg {

	public boolean hatched;
	public String birdType;
	
	public Egg(Bird createBird) {
    	System.out.println("Egg Bird looks like: " + createBird);
    	if (createBird instanceof Chicken ) {
    		System.out.println("this egg is a chicken egg!");
    		this.birdType = "chicken";
    	}
    }

    public Bird hatch() throws Exception {
    	if (hatched) {
    		throw new IllegalStateException("Sorry, this egg has already hatched.");
    	} else {
    		hatched = true;
    	}
    	
    	System.out.println("hatched bird is a: " + birdType);
    	if (birdType.equals("chicken")) {
    		return new Chicken();
    	}
    	throw new Exception("Need to add new bird type.");
    }
}

