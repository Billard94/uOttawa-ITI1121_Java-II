
public class DynamicArrayStack implements Stack {

    // instance variables
    private Object[] elems;
    private int top = 0;   // designates the first free cell
    private final int capacity; // memorizes the initial capacity

    public DynamicArrayStack( int capacity ) {
        // pre-condictions: capacity > 0
        elems = new Object[ capacity ];
        this.capacity = capacity;
    }

    // Returns true if this stack is empty;
    public boolean isEmpty() {
        return top == 0;
    }

    // Returns the top element of this stack without removing it.
    public Object peek() {
        // pre-conditions: ! isEmpty()
        return elems[ top-1 ];
    }

    // Returns and remove the top element of this stack.
    public Object pop() {
        // pre-conditions: ! isEmpty()
        
        // decrements top, then access the value
        Object saved = elems[ --top ];
        // scrub the memory!
        elems[ top ] = null; 

        if ( elems.length > capacity && top < (int) ( elems.length / 2 ) ) {
            decreaseSize();
        }

        return saved;
    }

    // Puts the element onto the top of this stack.
    public void push( Object element ) {
        if ( top == elems.length ) {
            increaseSize();
        }
        // stores the element at position top, then increments top
        elems[ top++ ] = element;
    }

    // Increases the size of the array by 1.5

    private void increaseSize() {
        Object[] newElems;
        newElems = new Object[ (int) ( 1.5 * elems.length ) ];
        System.arraycopy( elems, 0, newElems, 0, elems.length );
        // replacing elems with the new/larger array
        elems = newElems;
    }

    // Decreases the size of the array by 1.5

    private void decreaseSize() {

        int newSize = (int) ( elems.length / 1.5 );

        if ( newSize < capacity ) {
            newSize = capacity;
        }
        
        Object[] newElems;
        newElems = new Object[ newSize ];
        System.arraycopy( elems, 0, newElems, 0, top );

        // replacing elems with the new/smaller array
        elems = newElems;
    }

    // Removes all the elements of this array

    public void clear() {

        for ( int i=0; i<top; i++ ) {
            elems[ i ] = null; // ``scrubbing'' the memory
        }

 top = 0;
        elems = new Object[ capacity ];
    }

}
