import java.util.Iterator;
import java.util.LinkedList;

class Queue<E> implements Iterable<E> {
    private LinkedList<E> list = new LinkedList<E>();

    public Queue() {
    }

    public Queue(E elem) {
        enqueue(elem);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public E peek() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return list.peekFirst();
    }

    public E dequeue() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return list.removeFirst();
    }

    public void enqueue(E elem) {
        list.addLast(elem);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return list.toString();
    }

}