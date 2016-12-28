package solution;

public class OrderedList< T extends Comparable< T > > implements OrderedStructure<T> {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node<E> {

        private E value;

        private Node<E> previous;
        private Node<E> next;

        private Node( E value, Node<E> previous, Node<E> next ) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    // Instance variables

    private Node<T> head;
    private Node<T> tail;

    // Representation of the empty list.

    public OrderedList() {
        head = null;
        tail = null;
    }

    // Calculates the size of the list

    public int size() {
        Node<T> p = head;
        int count = 0;
        while ( p!=null ) {
            p = p.next;
            count++;
        }
        return count;
    }

    // Adding an element while preserving the order

    public boolean add( T o ) {

        if ( o == null ) {
            throw new IllegalArgumentException( "null" );
        }

        if ( head == null ) { // special case: empty list

            head = tail = new Node<T>( o, null, null );

        } else if ( head.value.compareTo(o) >= 0 ) { // special case: add before first node

            head = new Node<T>( o, null, head );

            head.next.previous = head;

        } else { 
            
            Node<T> p = head;

            // i)  there is at least one node
            // ii) o is greater than p

            while ( p.next != null && p.next.value.compareTo( o ) < 0 ) {
                p = p.next;
            }

            if ( p.next == null ) { // adding at the end of the list

                tail.next = new Node<T>( o, tail, null );

                tail = tail.next;

            } else { // intermediate position

                Node<T> q = p.next; // the node that follows

                p.next = new Node<T>( o, p, q );

                q.previous = p.next;

            }
        }

        return true;
    }

    // This implementation does not call size() to determine
    // if pos is valid; therefore, the list is only traversed
    // once.

    public T get( int pos ) {

        if (pos < 0) {
            throw new IndexOutOfBoundsException( Integer.toString( pos ) );
        }

        Node<T> p = head;
        
        for ( int i=0; i<pos; i++ ) {
            if ( p == null ) {
                throw new IndexOutOfBoundsException( Integer.toString( pos ) );
            } else {
                p = p.next;
            }
        }

        return p.value;
    }

    public void remove( int pos ) {

        if ( pos < 0 ) {
            throw new IndexOutOfBoundsException( Integer.toString( pos ) );
        }

        Node<T> p = head;
        
        if ( pos == 0 ) {

            if ( head == null ) {
                throw new IndexOutOfBoundsException( Integer.toString( pos ) );
            }

            head = head.next;

            if ( head == null ) {
                tail = null; // this was the last element
            } else {
                head.previous = null;
            }

            p.value = null;
            p.next = null;

        } else {

            for ( int i=0; i<pos; i++ ) // traversing pos nodes
                if ( p == null ) {
                    throw new IndexOutOfBoundsException(Integer.toString(pos));
                } else {
                    p = p.next;
                }
            
            Node<T> del = p;  // the node to delete

            p = p.previous; // p designates de previous node

            Node<T> q = del.next; // q designates the node that follows

            p.next = q;

            if ( del == tail ) {
                tail = p;
            } else {
                q.previous = p;
            }

            del.value = null;
            del.next = null;
            del.previous = null;

        }
    }
    
    public String toString() {
     String s="[";
        Node<T> p = head;
        while ( p!=null ) {
         s = s+ p.value;
         if (p.next!=null) s = s+",";
            p = p.next;
        }
        return s+"]";
        
    }

    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously.

    public void merge( OrderedList<T> other ) {

        Node<T> p = head;
        Node<T> q = other.head;

        while ( q != null ) {
            if ( p == null ) {  // special case this list was empty
                head = tail = new Node<T>( q.value, null, null );
                p = head;
                q = q.next;
            } else if ( q.value.compareTo( p.value ) < 0) {
                // insert before
                if ( p == head ) {
                    head = new Node<T>( q.value, null, head );
                    p.previous = head;
                } else {
                    p.previous.next = new Node<T>( q.value, p.previous, p );
                    p.previous = p.previous.next;
                }
                q = q.next;
            } else if ( p.next == null ) {
                // insert after
                p.next = new Node<T>( q.value, p, null );
                tail = p.next;
                p = p.next;
                q = q.next;
            } else {
                p = p.next;
            }
        }
    }
}
