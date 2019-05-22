package me.giraffetree.java.algorithms.week02.day03;

import java.util.Iterator;

/**
 * @author GiraffeTree
 * @date 2019-05-22
 */
public class BinarySearchTree<K extends Comparable<K>, V> implements Tree<K, V> {

    private Node root;

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        return node == null ? 0 : node.size;
    }

    @Override
    public V get(K k) {
        return get(k, root);
    }

    private V get(K k, Node node) {
        if (k == null) {
            throw new NullPointerException();
        }
        if (node == null) {
            return null;
        }
        K currentK = node.k;
        int compare = currentK.compareTo(k);
        if (compare > 0) {
            return get(k, node.left);
        } else if (compare < 0) {
            return get(k, node.right);
        }
        return node.v;
    }

    /**
     * only for test
     */
    public Node getRoot() {
        return root;
    }

    /**
     * only for test
     */
    public Node getNode(K k) {
        return getNode(k, root);
    }

    private Node getNode(K k, Node node) {
        if (k == null) {
            throw new NullPointerException();
        }
        if (node == null) {
            return null;
        }
        K currentK = node.k;
        int compare = currentK.compareTo(k);
        if (compare > 0) {
            return getNode(k, node.left);
        } else if (compare < 0) {
            return getNode(k, node.right);
        }
        return node;
    }

    @Override
    public void put(K k, V v) {
        if (k == null) {
            throw new NullPointerException();
        }
        root = put(k, v, root, null);
    }

    private Node put(K k, V v, Node node, Node parent) {
        if (node == null) {
            Node node1 = new Node(k, v, 1);
            node1.parent = parent;
            return node1;
        }
        K currentK = node.k;
        int compare = currentK.compareTo(k);
        if (compare > 0) {
            node.left = put(k, v, node.left, node);
        } else if (compare < 0) {
            node.right = put(k, v, node.right, node);
        } else {
            node.v = v;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public K max() {
        throw new UnsupportedOperationException();
    }

    @Override
    public K min() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int rank(K k) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    public class Node {
        private K k;
        private V v;
        private Node left, right, parent;
        private int size;

        public Node(K k, V v, int size) {
            this.k = k;
            this.v = v;
            this.size = size;
        }

        public K getK() {
            return k;
        }

        public V getV() {
            return v;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public Node getParent() {
            return parent;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }


}
