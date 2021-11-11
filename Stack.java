import java.util.Iterator;
// Standard Generic Stack we learned in class.
public class Stack<E> implements Iterable<E>
{
    private Node first = null;
    private int size = 0;
    
    private class Node {
        private E item;
        private Node next;
    } 
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void push(E item) {
        size++;
        Node second = first;
        first = new Node();
        first.item = item;
        first.next = second;
    }
    
    public int getSize() {
        return size;
    }
    
    public E pop() {
        size--;
        E item = first.item;
        first = first.next;
        return item;
    }
    
    // To make this data structure work with for-each loops
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<E> {

        private Node n = first;

        public boolean hasNext() {
            return n != null;
        }

        public E next() {
            E item = n.item;
            n = n.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}