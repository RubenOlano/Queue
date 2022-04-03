import java.util.Iterator;

@SuppressWarnings("unchecked")
class ArrayQueue<E> implements Iterable<E> {
    private int head;
    private int tail;
    private int size;
    private E[] elems;

    public ArrayQueue(int size) {
        elems = (E[]) new Object[size];
        this.size = size;
        head = 0;
        tail = 0;
    }

    public void enqueue(E elem) {
        elems[tail] = elem;
        tail = (tail + 1) % size;
    }

    public E dequeue() {
        E elem = elems[head];
        head = (head + 1) % size;
        return elem;
    }

    public E peek() {
        return elems[head];
    }

    public int size() {
        return (tail + size - head) % size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int i = head;

            @Override
            public boolean hasNext() {
                return i != tail;
            }

            @Override
            public E next() {
                E elem = elems[i];
                i = (i + 1) % size;
                return elem;
            }

        };
    }
}