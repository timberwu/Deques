package deque;

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 3;
        nextLast = 4;
        size = 0;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        // System.arraycopy(items, 0, a, 0, size);
        for (int i = 0; i < size; i++) {
            a[i] = get(i);
        }
        items = a;
        nextFirst = a.length - 1;
        nextLast = size;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        size++;
        items[nextFirst] = item;
        nextFirst = (nextFirst + items.length - 1) % items.length;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        size++;
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
    }

    //    @Override
//    public boolean isEmpty() {
//        return size == 0;
//    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int p = nextFirst;
        for (int i = 1; i <= size; i++) {
            System.out.print(items[p]);
            p = (p + 1) % items.length;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            size--;
            nextFirst = (nextFirst + 1) % items.length;
            T item = items[nextFirst];
            items[nextFirst] = null;
            if ((double) size / items.length <= 0.25 && items.length >= 16) {
                resize(items.length / 2);
            }
            return item;
        }
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            size--;
            nextLast = (nextLast + items.length - 1) % items.length;
            T item = items[nextLast];
            items[nextLast] = null;
            if ((double) size / items.length <= 0.25 && items.length >= 16) {
                resize(items.length / 2);
            }
            return item;
        }
    }

    @Override
    public T get(int index) {
        if (index > size - 1) {
            return null;
        } else {
            T p = items[(nextFirst + 1 + index) % items.length];
            return p;
        }
    }

    @Override
    public boolean equals(Object o) {


        boolean isInstance = o instanceof Deque;


        if ((isInstance == false) ) {
            return false;
        }

        Deque<T> compare = (Deque<T>) o;

        if (compare.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {

            if (!(compare.get(i).equals(this.get(i)))) {
                return false;
            }
        }
        return true;
    }

}
