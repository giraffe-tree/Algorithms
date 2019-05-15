package me.giraffetree.java.algorithms.week01.day02;

import lombok.Data;

import java.util.Iterator;

/**
 * @author GiraffeTree
 * @date 2019-05-15
 */
public class DoubleLinkedList<T> implements SimpleQueue<T>, SimpleList<T> {

    private Node<T> head = new Node<>(null, null, null);
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T t) {
        Node<T> current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(t, current, null);
        size++;
        return true;
    }

    @Override
    public boolean remove(T t) {
        Node<T> current = this.head;
        while (current.next != null) {
            Node<T> prev = current;
            current = current.next;
            if (current.t == t) {
                prev.next = current.next;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            throw new NullPointerException();
        }
        int i = 0;
        Node<T> current = this.head;
        while (i < index) {
            current = current.next;
            i++;
        }
        return current.next.t;
    }

    @Override
    public T set(int index, T t) {
        if (index >= size) {
            throw new NullPointerException();
        }
        Node<T> current = this.head;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        T t1 = current.next.t;
        current.next.t = t;
        return t1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current;

            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public T next() {
                current = current.next;
                return current.t;
            }
        };
    }

    @Override
    public void addFirst(T t) {
        Node<T> next = head.next;
        head.next = new Node<>(t, head, next);
        size++;
    }

    @Override
    public void addLast(T t) {
        Node<T> current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(t, current, null);
        size++;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            throw new NullPointerException();
        }
        Node<T> next = head.next;
        T t = next.t;
        head.next = next.next;
        size--;
        return t;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            throw new NullPointerException();
        }
        Node<T> current = this.head;
        while (current.next.next != null) {
            current = current.next;
        }
        T t = current.next.t;
        current.next = null;
        size--;
        return t;
    }

    private static class Node<T> {
        T t;
        Node<T> prev;
        Node<T> next;

        public Node(T t, Node<T> prev, Node<T> next) {
            this.t = t;
            this.prev = prev;
            this.next = next;
        }
    }
}
