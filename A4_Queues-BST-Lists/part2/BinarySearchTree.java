package solution;

public class BinarySearchTree< E extends Comparable<E> > {

    // A static nested class used to store the elements of this tree

    private static class Node<E> {
        private E value;
        private Node<E> left;
        private Node<E> right;
        private Node( E value ) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node<E> root = null;
    
    /**
     * Inserts an object into this BinarySearchTree.
     *
     * @param obj item to be added
     * @return true if the object has been added and false otherwise
     */

    public boolean add( E obj ) {

        // pre-condition:

        if ( obj == null ) {
            throw new IllegalArgumentException( "null" );
        }

        // special case:

        if ( root == null ) {
            root = new Node<E>( obj );
            return true;
        }

        // general case:

        return add( obj, root );
    }

    private boolean add( E obj, Node<E> current ) {

        boolean result;
        int test = obj.compareTo( current.value );

        if ( test == 0 ) {
            result = false;
        } else if ( test < 0 ) {
            if ( current.left == null ) {
                current.left = new Node<E>( obj );
                result = true;
            } else {
                result = add( obj, current.left );
            }
        } else {
            if ( current.right == null ) {
                current.right = new Node<E>( obj );
                result = true;
            } else {
                result = add( obj, current.right );
            }
        }
        return result;
    }

    /**
     * Looks up for obj in this BinarySearchTree, returns true
     * if obj is found and false otherwise.
     *
     * @param obj value to look for
     * @return true if the object has been found and false otherwise
     */

    public boolean contains( E obj ) {

        // pre-condition:

        if ( obj == null ) {
            throw new IllegalArgumentException( "null" );
        }

        return contains( obj, root );
    }

    private boolean contains( E obj, Node<E> current ) {

        boolean result;

        if ( current == null ) {

            result = false;

        } else {

            int test = obj.compareTo( current.value );

            if ( test == 0 ) {

                result = true;

            } else if ( test < 0 ) {

                result = contains( obj, current.left );

            } else {

                result = contains( obj, current.right );

            }
        }
        return result;
    }

    
    /**
     * Looks up for element that equals obj in this BinarySearchTree, returns the element
     * if found and null otherwise.
     *
     * @param obj value to look for
     * @return element equals obj if found and false otherwise
     */
    public E find(E obj ) {

        // pre-condtion:

        if ( obj == null ) {
            throw new IllegalArgumentException( "null" );
        }

        return find( obj, root );
    }

    private E find( E obj, Node<E> current ) {

        // This must be implemented; currently it always return null
     // NOTE: this is very simular to method contains( E obj, Node<E> current )
     // the main difference being the return value
     
        if ( current == null ) {

            return null;

        } else {

            int test = obj.compareTo( current.value );

            if ( test == 0 ) {

                return current.value;

            } else if ( test < 0 ) {

                return find( obj, current.left );

            } else {

                return find( obj, current.right );

            }
        }
       
    }
    


        
    
    /* overides object method toString()
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return toString( root );
    }

    private String toString( Node<E> current ) {

        if ( current == null ) {
            return "()";
        }

        return "(" + toString( current.left ) + current.value + toString( current.right ) + ")";
    }


}
