package me.giraffetree.java.algorithms.week02.day07;

class Node<KEY, VALUE> {
    KEY key;
    VALUE value;
    Node<KEY, VALUE> left, right;
    int size;
    boolean color;

    public Node(KEY key, VALUE value, int size, boolean color) {
        this.key = key;
        this.value = value;
        this.size = size;
        this.color = color;
    }
}
