public class Combination {

    // Instance variables.

    private int first;
    private int second;
    private int third;

    // Constructor
    // note: we have to use "this" in order to distinguish
    // between the parameter first and the instance
    // variable first (similarly for second and third).

    public Combination( int first, int second, int third ) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    // An instance method that compares this object
    // to other.
    // Always check that other is not null, i)
    // an error would occur if you tried to
    // access other.first if other was null, ii)
    // null is a valid argument, the method should
    // simply return false.

    public boolean equals( Combination other ) {
        return ( ( other != null ) &&
          ( first == other.first ) &&
          ( second == other.second ) &&
          ( third == other.third ) );
    }

    // Returns a String representation of this Combination.

    public String toString() {
        return first + ":" + second + ":" + third;
    }

}