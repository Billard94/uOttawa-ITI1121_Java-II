public class Herbivore extends Animal {

    public static final int MIN_NUMBER_OF_PLANTS = 1;
    public static final int LIFE_SPAN = 20;

    public void update(Organism[] neighbours) {

        // first, let's call the method update from the
        // superclass so that the age is incremented.

        super.update(neighbours);

        // counting plants
        int plants = 0;
        for (int i=0; i<neighbours.length; i++)
            if (neighbours[i] != null && neighbours[i] instanceof Plant)
                plants++;

        // applying the rules
        if (plants < MIN_NUMBER_OF_PLANTS)
            alive = false;

        if (getAge() >= LIFE_SPAN) 
            alive = false;
    }
    
    public String toString() {
        return "H";
    }
}