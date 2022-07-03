import java.util.*;

public class MyClass implements List<Integer>, Deque<Integer> {
    int size = 0;
    Node<Integer> first;
    Node<Integer> last;

    public MyClass() {
    }


    private static class Node<E> {
        Integer item;
        Node<Integer> next;
        Node<Integer> prev;

        Node(Node<Integer> prev, Integer element, Node<Integer> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    //добавляет первый элемент.
    @Override
    public void addFirst(Integer integer) {
        final Node<Integer> f = first;
        final Node<Integer> newNode = new Node<>(null, integer, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    //Добавляет последний элемент.
    @Override
    public void addLast(Integer integer) {
        final Node<Integer> l = last;
        final Node<Integer> newNode = new Node<>(l, integer, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    @Override
    public boolean offerFirst(Integer integer) {
        return false;
    }

    @Override
    public boolean offerLast(Integer integer) {
        return false;
    }

    @Override
    public Integer removeFirst() {
        return null;
    }

    @Override
    public Integer removeLast() {
        return null;
    }

    @Override
    public Integer pollFirst() {
        return null;
    }

    @Override
    public Integer pollLast() {
        return null;
    }

    @Override
    public Integer getFirst() {
        final Node<Integer> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    @Override
    public Integer getLast() {
        final Node<Integer> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }

    public void add(int index, Integer element) {

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }

    void linkLast(Integer e) {
        final Node<Integer> l = last;
        final Node<Integer> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        //modCount++;
    }

    void linkBefore(Integer e, Node<Integer> succ) {
        final Node<Integer> pred = succ.prev;
        final Node<Integer> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    @Override
    public Integer peekFirst() {
        final Node<Integer> l = first;
        return (l == null) ? null : l.item;
    }

    @Override
    public Integer peekLast() {
        final Node<Integer> l = last;
        return (l == null) ? null : l.item;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean offer(Integer integer) {
        return false;
    }

    @Override
    public Integer remove() {
        return null;
    }

    @Override
    public Integer poll() {
        return null;
    }

    @Override
    public Integer element() {
        return null;
    }

    @Override
    public Integer peek() {
        return null;
    }

    @Override
    public void push(Integer integer) {

    }

    @Override
    public Integer pop() {
        return null;
    }

    @Override
    public Iterator<Integer> descendingIterator() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        linkLast(integer);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Integer get(int index) {
        return node(index).item;
    }

    @Override
    public Integer set(int index, Integer element) {

        Node<Integer> x = node(index);
        Integer oldVal = x.item;
        x.item = element;
        return oldVal;
    }


    @Override
    public Integer remove(int index) {
        return unlink(node(index));
    }

    Integer unlink(Node<Integer> x) {
        // assert x != null;
        final Integer element = x.item;
        final Node<Integer> next = x.next;
        final Node<Integer> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    Node<Integer> node(int index) {


        Node<Integer> x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
        } else {
            x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
        }
        return x;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Integer> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        return null;
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        return null;
    }
}