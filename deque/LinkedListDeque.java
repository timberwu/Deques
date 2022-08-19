package deque;

public class LinkedListDeque<T> implements Deque<T> {
    private class TemplateListNode {
        public T item;
        public TemplateListNode previous;
        public TemplateListNode next;

        public TemplateListNode(T item, TemplateListNode previous, TemplateListNode next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }
    private TemplateListNode sentinel;
    private int size;
    public LinkedListDeque() {
        size = 0;
        sentinel = new TemplateListNode(null, null, null);
        sentinel.previous = sentinel;
        sentinel.next = sentinel;
    }
    @Override
    public void addFirst(T item) {
        size++;
        TemplateListNode newitem = new TemplateListNode(item, sentinel, sentinel.next);
        sentinel.next.previous = newitem;
        sentinel.next = newitem;

    }
    @Override
    public void addLast(T item) {
        size++;
        TemplateListNode newitem = new TemplateListNode(item, sentinel.previous, sentinel);
        sentinel.previous.next = newitem;
        sentinel.previous = newitem;
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
        for (int i = 1; i <= size; i++) {
            sentinel = sentinel.next;
            System.out.print(sentinel.item + " ");
        }
        sentinel = sentinel.next;
        System.out.println();
    }
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            size--;
            T tItem = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.previous = sentinel;
            return tItem;
        }
    }
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            size--;
            T tItem = sentinel.previous.item;
            sentinel.previous = sentinel.previous.previous;
            sentinel.previous.next = sentinel;
            return tItem;
        }
    }
    @Override
    public T get(int index) {
        if (index > size - 1) {
            return null;
        } else {
            TemplateListNode p = sentinel;
            while (index>=0) {
                p = p.next;
                index--;
            }
            return p.item;
        }
    }
    @Override
    public boolean equals(Object o){
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

    private T helper(TemplateListNode p, int index) {
        if (index > size - 1) {
            return null;
        }
        if (index == 0) {
            return p.item;
        }
        return helper(p.next, index - 1);
    }
    public T getRecursive(int index) {
        return helper(sentinel.next, index);
    }
}
