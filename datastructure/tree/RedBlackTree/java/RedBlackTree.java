package me.giraffetree.java.algorithms.week02.day07;

/**
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

    private Node<KEY, VALUE> put(Node<KEY, VALUE> h, KEY key, VALUE value) {
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

    public class Node<KEY, VALUE> {
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

    private boolean isRed(Node x) {
        return x != null && x.color == RED;
    }

    private Node rotateLeft(Node<KEY, VALUE> h) {
        Node<KEY,VALUE> x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node<KEY, VALUE> h) {
        Node<KEY,VALUE> x = h.right;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }


}
