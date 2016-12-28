
public class LinkedStack implements Stack {

    // Instances of the nested class Elem are used to store the
    // elements of this LinkedStack.

    private static class Elem {

        private Object value;
        private Elem next;

        private Elem( Object value, Elem next ) {
            this.value = value;
            this.next = next;
        }
    }

    // Instance variable(s)

    private Elem top;

    // Constructs an empty stack.

    public LinkedStack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push( Object o ) {
        top = new Elem( o, top );
    }

    public Object peek() {
        // pre-condition(s): ! isEmpty()
        return top.value;
    }

    public Object pop() {

        // pre-condition(s): ! isEmpty()

        Object savedValue = top.value;

        Elem node2del = top;
        top = top.next;

        node2del.value = null; // scrubbing the memory
        node2del.next = null;  // scrubbing the memory

        return savedValue;
    }

    public void clear() {

        while ( top != null ) {

            Elem node2del = top;
            top = top.next;

            node2del.value = null; // scrubbing the memory
            node2del.next = null;  // scrubbing the memory
        }
    }

    public boolean equals( Object o ) {

        if ( o == null || ! ( o instanceof Stack ) ) {
            return false;
        }

        Stack tmpStack = new LinkedStack();
        Stack other = (Stack) o;
        boolean result = true;
        Elem p = top;

        while ( result && p != null && ! other.isEmpty() ) {

            Object obj = other.pop();

            tmpStack.push( obj );

            if ( p.value == null ) {
                result = ( obj == null );
            } else {
                result = p.value.equals( obj );
            }

            p = p.next;
        }

        if ( ! other.isEmpty() || p != null ) {
            result = false;

            while ( ! other.isEmpty() ) {
                tmpStack.push( other.pop() );
            }
        }

        while ( ! tmpStack.isEmpty() ) {
            other.push( tmpStack.pop() );
        }

        return result;
    }

}
