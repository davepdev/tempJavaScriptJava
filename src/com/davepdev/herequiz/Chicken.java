package com.davepdev.herequiz;


class Chicken implements Bird {
	public static final String birdType = "chicken";
	public Chicken() {

    }

    public static void main(String[] args) throws Exception {
        Chicken chicken = new Chicken();
        System.out.println("this is a chicken? "  + (Boolean)(chicken instanceof Chicken));
        Egg egg = chicken.lay();
        System.out.println("is hatched? " + egg.hatched);
        System.out.println("this egg is a chicken?" + egg.birdType);
        System.out.println(chicken instanceof Bird);
    }

	@Override
	public Egg lay() {
		return new Egg(new Chicken());
	}
}