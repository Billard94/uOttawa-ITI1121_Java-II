public class Simulation {

    // a 2-dimensional grid of Organisms
    private Organism[][] grid;

    // counts the number of generations
    private int generation;
    
    public Simulation(int row, int column) {
        grid = new Organism[row][column];
        initialize();
    }

    // creates an intitial population

    public void initialize() {
        generation = 0;
        for (int row=0; row<grid.length; row++) {
            for (int column=0; column<grid[row].length; column++) {
                grid[row][column] = createOrganism();
            }
        }
    }

    // Creates a specific Organism, according to the
    // following proportions:
    //   20% of the newly created Organisms are Plants
    //   10% are Herbivores
    //    5% are Carnivores
    //   65% of the time no organism is created (returns null)

    private Organism createOrganism() {

        Organism result = null;
        double num = Math.random();

        if (num < 0.2)
            result = new Plant();
        else if (num < 0.30)
            result = new Herbivore();
        else if (num < 0.35)
            result = new Carnivore();

        return result;
    }

    //  The following method returns the Organisms surrounding
    //  the element i,j, designated by X below. Diagram showing
    //  the correspondance between the postitions on the grid
    //  and the resulting array.
    //
    //  0 1 2
    //  3 X 4
    //  5 6 7

    private Organism[] returnNeighborhood(int i, int j) {

        Organism[] neighbors = new Organism[8];
        int pos = 0;
        
        for (int row=i-1; row<=i+1; row++) {
            for (int col=j-1; col<=j+1; col++) {
                if (row!= i || col!=j) {
                    if ((row>=0 && row<grid.length) && (col>=0 && col<grid[row].length))
                        neighbors[pos] = grid[row][col];
                    pos++;
                }
            }
        }
        return neighbors;
    }

    // Simulats one generation

    public void simulate() {

        // determine who dies and who survives

        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[row].length; col++) {
                if (grid[row][col] != null) {
                    Organism[] neighbors = returnNeighborhood(row,col);
                    grid[row][col].update(neighbors);
                }
            }
        }

        // determine births

        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[row].length; col++) {
                if (grid[row][col] == null) {
                    grid[row][col] = createOrganism();
                }
            }
        }

        // remove dead organisms

        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[row].length; col++) {
                if (grid[row][col] != null && (! grid[row][col].isAlive())) {
                    grid[row][col] = null;
                }
            }
        }

        generation++;
    }

    // Returns a String representation of the two dimensional
    // grid.

    public String toString() {

        // How are newlines represented on this computer?
        String newline = System.getProperty("line.separator");

        // Header
        String result = "Generation = " + generation + newline;

        // Representation of the grid itself
        for (int row=0; row<grid.length; row++) {
            for (int column=0; column<grid[row].length; column++) {

                if (grid[row][column] != null) {
                    result += "[" + grid[row][column] + "]";
                } else {
                    result += "[ ]";
                }
            }
            result += newline;
        }
        return result;
    }

    // Computes some statistics about the population

    public void tabulate() {

        int organisms = 0;
        int plants = 0;
        int animals = 0;
        int herbivores = 0;
        int carnivores = 0;

        for (int row=0; row<grid.length; row++) {
            for (int column=0; column<grid[row].length; column++) {

                if (grid[row][column] != null) {
                    Organism o = grid[row][column];

                    organisms++;
                    
                    if (o instanceof Plant) {
                        plants++;
                    }
                    if (o instanceof Animal) {
                        animals++;
                    } 
                    if (o instanceof Herbivore) {
                        herbivores++;
                    }
                    if (o instanceof Carnivore) {
                        carnivores++;
                    }
                }
            }
        }

        System.out.println("Organisms = " + organisms);
        System.out.println("Plants = " + plants);
        System.out.println("Animals = " + animals);
        System.out.println("Herbivores = " + herbivores);
        System.out.println("Carnivores = " + carnivores);
        System.out.println();
    }

    public static void main(String[] args) {

        // Creates a Simulation object with a grid of 10x10

        Simulation aSimulation = new Simulation(10,10);

        System.out.println(aSimulation);
        aSimulation.tabulate();

        // Simulates 10 generations

        for (int i=0; i<10; i++) {
            aSimulation.simulate();
            System.out.println(aSimulation);
            aSimulation.tabulate();
        }
    }
}