package me.giraffetree.java.algorithms.week01.day02;

import java.util.Iterator;

/**
 * {@link SimpleList}
 *
 * @author GiraffeTree
 * @date 2019-05-13
 */
public class SinglyLinkedList<T> implements SimpleList<T>, SimpleQueue<T> {

    private Node<T> first = new Node<>(null, null);
    private Node<T> last = first;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * add t at last the position
     */
    @Override
    public boolean add(T t) {
        last.next = new Node<>(t, null);
        last = last.next;
        size++;
        return true;
    }

    /**
     * remove t
     *
     * @throws NullPointerException if the specific node is null
     */
    @Override
    public boolean remove(T t) {
        Node<T> current = first;
        Node<T> currentNext = first.next;
        for (int i = 0; i < size; i++) {
            if (currentNext.item.equals(t)) {
                current.next = currentNext.next;
                if (i == size - 1) {
                    last = current;
                }
                size--;
                return true;
            }
            current = current.next;
            currentNext = current.next;
        }
        return false;
    }

    /**
     * @throws NullPointerException if the specific node is null
     */
    @Override
    public T get(int index) {
        Node<T> current = first;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        return current.item;
    }

    /**
     * @throws NullPointerException if the specific node is null
     */
    @Override
    public T set(int index, T t) {
        Node<T> current = first;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        T prevItem = current.item;
        current.item = t;
        return prevItem;
    }

    /**
     * @throws NullPointerException if the next node is null
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = first;

            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public T next() {
                current = current.next;
                return current.item;
            }
        };
    }

    @Override
    public void addFirst(T t) {
        first.next = new Node<>(t, first.next);
        size++;
    }

    @Override
    public void addLast(T t) {
        add(t);
    }

    /**
     * @throws NullPointerException if the first element is null
     */
    @Override
    public T removeFirst() {
        Node<T> firstNext = first.next;
        first.next = firstNext.next;
        size--;
        if (size == 1) {
            last = first.next;
        }
        if (size == 0) {
            last = first;
        }
        return firstNext.item;
    }

    @Override
    public T removeLast() {
        Node<T> currentLast = this.last;
        Node<T> current = this.first;

        for (int i = 0; i < size; i++) {
            current = current.next;
            if (i == size - 1) {
                current.next = null;
                last = current;
                size--;
            }
        }
        return currentLast.item;
    }

    private static class Node<T> {
        T item;
        Node<T> next;

        Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

}
