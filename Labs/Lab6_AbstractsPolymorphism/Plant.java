public class Plant extends Organism {

    public static final int MAX_ORGANISMS = 5;
    public static final int MAX_HERBIVORES = 2;

    public void update(Organism[] neighbours) {

        // Counting Organisms and herbivores
        int organisms = 0;
        int herbivores = 0;

        for (int i=0; i<neighbours.length; i++)

            if (neighbours[i] != null) {
                // neighbours[i] is not null and therefore
                // designates an Organism
                organisms++;

                // is this an Herbivore?
                if (neighbours[i] instanceof Herbivore) {
                    herbivores++;
                }
            }

        // applying the two rules; alive is protected
        // and can be accessed from a subclass

        if (organisms > MAX_ORGANISMS)
            alive = false;

        if (herbivores >= MAX_HERBIVORES)
            alive = false;
    }
    
    public String toString() {
        return "P";
    }
}