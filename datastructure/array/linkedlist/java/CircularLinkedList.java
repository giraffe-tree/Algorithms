package me.giraffetree.java.algorithms.week01.day02;

import java.util.Iterator;

/**
 * 单向循环链表
 * node1 -> node2 -> node3 -> node1
 *
 * @author GiraffeTree
 * @date 2019-05-14
 */
public class CircularLinkedList<T> implements SimpleList<T>, SimpleQueue<T> {

    private Node<T> head;
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
        if (head == null) {
            head = new Node<>(t, null);
            head.next = head;
            size++;
            return true;
        }
        Node<T> current = this.head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = new Node<>(t, head);
        size++;
        return true;
    }

    @Override
    public boolean remove(T t) {
        Node<T> prev = findPrev(t);
        if (prev == null) {
            return false;
        }
        if (prev.next == head) {
            if (prev == head) {
                head = null;
                size--;
                return true;
            }
            // if prev is not head
            prev.next = prev.next.next;
            head = prev.next;
            size--;
            return true;
        }

        prev.next = prev.next.next;
        size--;
        return true;
    }

    private Node<T> findPrev(T t) {
        Node<T> prev = head;
        int count = 0;
        while (!prev.next.item.equals(t) && count < size) {
            prev = prev.next;
            count++;
        }
        if (prev.next.item.equals(t)) {
            return prev;
        }
        return null;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            throw new NullPointerException();
        }
        Node<T> current = this.head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    @Override
    public T set(int index, T t) {
        if (index >= size) {
            throw new NullPointerException();
        }
        Node<T> current = this.head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        T item = current.item;
        current.item = t;
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current.next != head;
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
        Node<T> tNode = new Node<>(t, null);
        if (head == null) {
            head = tNode;
            head.next = tNode;
            size++;
            return;
        }
        // 如果head不为null
        Node<T> current = this.head;
        while (current.next != head) {
            current = current.next;
        }
        tNode.next = head;
        current.next = tNode;
        head = tNode;
        size++;
    }

    @Override
    public void addLast(T t) {
        if (head == null) {
            head = new Node<>(t, null);
            head.next = head;
            size++;
            return;
        }
        Node<T> current = this.head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = new Node<>(t, head);
        size++;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            throw new NullPointerException();
        }
        T item = head.item;
        if (size == 1) {
            head = null;
            size--;
            return item;
        }
        Node<T> current = this.head;
        while (current.next != head) {
            current = current.next;
        }
        head = current.next.next;
        current.next = head;
        size--;

        return item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            throw new NullPointerException();
        }
        T item = head.item;
        if (size == 1) {
            head = null;
            size--;
            return item;
        }
        Node<T> current = this.head;
        while (current.next.next != head) {
            current = current.next;
        }
        current.next = head;
        size--;

        return null;
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
