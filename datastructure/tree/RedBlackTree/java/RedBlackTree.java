package me.giraffetree.java.algorithms.week02.day07;

import java.util.NoSuchElementException;

/**
 * 官方参考代码: https://algs4.cs.princeton.edu/33balanced/RedBlackBST.java.html
 *
 * @author GiraffeTree
 * @date 2019-05-26
 */
public class RedBlackTree<KEY extends Comparable<KEY>, VALUE> {

    private Node<KEY, VALUE> root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public VALUE get(KEY key) {
        return get(root, key);
    }

    public VALUE get(Node<KEY, VALUE> h, KEY key) {
        if (h == null) {
            return null;
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            return get(h.left, key);
        } else if (cmp > 0) {
            return get(h.right, key);
        } else {
            return h.value;
        }
    }

    public void put(KEY k, VALUE value) {
        root = put(root, k, value);
        root.color = BLACK;
    }

    protected Node<KEY, VALUE> put(Node<KEY, VALUE> h, KEY key, VALUE value) {
        if (h == null) {
            return new Node<>(key, value, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            // 左子树
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            // 左旋
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            // 右旋
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }

    public KEY min() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls min() with empty symbol table");
        }
        return min(root).key;
    }

    // the smallest key in subtree rooted at x; null if no such key
    private Node<KEY, VALUE> min(Node<KEY, VALUE> x) {
        // assert x != null;
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }

    public void delete(KEY key) {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = delete(root, key);
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }

    protected Node<KEY, VALUE> delete(Node<KEY, VALUE> h, KEY key) {
        if (key.compareTo(h.key) < 0) {
            if (!isRed(h.left) && !isRed(h.left.left)) {
                h = moveRedLeft(h);
            }
            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left)) {
                h = rotateRight(h);
            }
            if (key.compareTo(h.key) == 0 && (h.right == null)) {
                return null;
            }
            if (!isRed(h.right) && !isRed(h.right.left)) {
                h = moveRedRight(h);
            }
            if (key.compareTo(h.key) == 0) {
                h.value = get(h.right, min(h.right).key);
                h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            } else {
                h.right = delete(h.right, key);
            }
        }
        return balance(h);
    }


    public void deleteMax() {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = deleteMax(root);
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }

    protected Node<KEY, VALUE> deleteMax(Node<KEY, VALUE> h) {
        if (isRed(h.left)) {
            h = rotateRight(h);
        }
        if (h.right == null) {
            return null;
        }
        if (!isRed(h.right) && !isRed(h.right.left)) {
            h = moveRedRight(h);
        }
        h.right = deleteMax(h.right);
        return balance(h);

    }

    protected Node<KEY, VALUE> moveRedRight(Node<KEY, VALUE> h) {
        // 若 h.color = red 且 h.right 和 h.right.left 均为黑色 -> 则将 h.right 或 h.right 的子节点之一变红
        flipColors(h);
        if (!isRed(h.left.left)) {
            h = rotateRight(h);
        }
        return h;
    }

    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = deleteMin(root);
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }

    protected Node<KEY, VALUE> deleteMin(Node<KEY, VALUE> h) {
        if (h.left == null) {
            return null;
        }
        if (!isRed(h.left) && !isRed(h.left.left)) {
            h = moveRedLeft(h);
        }
        h.left = deleteMin(h.left);
        return balance(h);
    }

    protected Node<KEY, VALUE> moveRedLeft(Node<KEY, VALUE> h) {
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }


    protected Node<KEY, VALUE> balance(Node<KEY, VALUE> h) {
        if (isRed(h.right)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            // 右旋
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }


    protected boolean isRed(Node x) {
        return x != null && x.color == RED;
    }

    protected Node<KEY, VALUE> rotateLeft(Node<KEY, VALUE> h) {
        Node<KEY, VALUE> x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    protected Node<KEY, VALUE> rotateRight(Node<KEY, VALUE> h) {
        Node<KEY, VALUE> x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    protected void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    public int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }

    /**
     * only for test
     */
    Node<KEY, VALUE> getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null || root.size == 0;
    }

}
