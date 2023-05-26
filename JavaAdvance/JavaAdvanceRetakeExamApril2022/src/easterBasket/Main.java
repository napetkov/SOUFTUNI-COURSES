package easterBasket;

public class Main {
    public static void main(String[] args) {
//Initialize the repository (easterBasket.Basket)
        Basket basket = new Basket("Wood", 20);

        System.out.println(basket.removeEgg("Red"));
//Initialize entity (easterBasket.Egg)
        Egg egg = new Egg("Red", 10, "oval");
//Print easterBasket.Egg
        System.out.println(egg);  //Red egg, 10 strength, oval shape

//Add easterBasket.Egg
        basket.addEgg(egg);

//Remove easterBasket.Egg
        System.out.println(basket.removeEgg("Pink"));  //False

        Egg secondEgg = new Egg("Green", 9, "pointy");

//Add easterBasket.Egg
        basket.addEgg(new Egg("Blue",15,"asd"));
        basket.addEgg(secondEgg);

//Get strongest egg
        Egg strongestEgg = basket.getStrongestEgg();

        System.out.println(strongestEgg);

//Get egg
        Egg getEgg = basket.getEgg("Green"); //Green egg with 9 strength, pointy shape
        System.out.println(getEgg);

        System.out.println(basket.report());
//Wood basket contains:
//Red egg, with 10 strength and oval shape.
//Green egg, with 9 strength and pointy shape.

    }
}
