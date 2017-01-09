public abstract class Animal extends Organism {

    // This variable has been declared private, and therefore
    // it cannot be changed by the subclasses (this is generally
    // the preferred visibility).  Here the age is updated
    // in the method update(), which must called called by
    // all the methods updates of the subclasses; using the
    // notation super.update(...).

    private int age;

    public Animal() {
        age = 0;
    }

    public int getAge() {
        return age;
    }

    // A method update, that increments the value of age
    // at every call.  This method must be overriden and
    // called by all the sub-classes.

    public void update(Organism[] neighbors) {
        age++;
    }
}