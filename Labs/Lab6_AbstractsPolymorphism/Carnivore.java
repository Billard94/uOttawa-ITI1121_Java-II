public class Carnivore extends Animal {

    public static final int LIFESPAN = 15;
    public static final int MAX_FAST = 4;

    // needs an instance variable to count the number of
    // generations fasting.

    private int fast = 0;

    public void update(Organism[] neighbours) {
        // calls super.update so that the age is updated!
        super.update(neighbours);

        // counting prays
        int prays = 0;
        for (int i=0; i<neighbours.length; i++)
            if (neighbours[i] != null && neighbours[i] instanceof Animal)
                prays++;

        // if there are prays in the neighbourhood, we assume
        // this Carnivore has eaten; otherwise, this is one
        // more generation fasting.

        if (prays > 0)
            fast = 0;
        else
            fast++;
        
        // applying rules

        if (fast >= MAX_FAST)
            alive = false;

        if (getAge() >= LIFESPAN)
            alive = false;

    }
    
    public String toString() {
        return "C";
    }
}