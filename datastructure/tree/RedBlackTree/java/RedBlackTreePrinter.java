package me.giraffetree.java.algorithms.week02.day07;

/**
 * @author GiraffeTree
 * @date 2019-05-29
 */
public class RedBlackTreePrinter<KEY extends Comparable<KEY>, VALUE> extends RedBlackTree<KEY, VALUE> {

    @Override
    protected Node<KEY, VALUE> rotateLeft(Node<KEY, VALUE> h) {
        System.out.println("    rotate left");
        Node<KEY, VALUE> node = super.rotateLeft(h);
        TreePrinter.print(getRoot());
        return node;
    }

    @Override
    protected Node<KEY, VALUE> rotateRight(Node<KEY, VALUE> h) {
        System.out.println("    rotate right");

        Node<KEY, VALUE> node = super.rotateRight(h);
        TreePrinter.print(getRoot());
        return node;
    }

    @Override
    protected Node<KEY, VALUE> balance(Node<KEY, VALUE> h) {

        System.out.println("    balance");
        Node<KEY, VALUE> balance = super.balance(h);
        TreePrinter.print(getRoot());
        return balance;
    }

    @Override
    protected void flipColors(Node h) {
        System.out.println("    flip Colors");

        super.flipColors(h);
        TreePrinter.print(h);
    }

    @Override
    protected Node<KEY, VALUE> moveRedLeft(Node<KEY, VALUE> h) {
        System.out.println("    move Red Left");

        Node<KEY, VALUE> node = super.moveRedLeft(h);
        TreePrinter.print(getRoot());
        return node;
    }
}
