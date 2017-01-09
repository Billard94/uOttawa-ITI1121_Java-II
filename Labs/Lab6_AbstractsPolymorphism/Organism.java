public abstract class Organism {

    // Has been declared protected so that
    // the subclasses can change this value

    protected boolean alive;

    public Organism() {
        alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    // An abstract method is declared so that 1) all the
    // subclasses are forced to create an implementation
    // for this method, and 2) the class Simulation can
    // declare a 2-dimensional array of Organisms and
    // call the method update; this declaration is essential
    // so that a static validation of the operations can
    // be done at compile-time, the actual method that
    // will be called during the execution of the program
    // is the one that is defined in the class of the
    // object designed by the reference.
    
    public abstract void update(Organism[] neighbours);

}