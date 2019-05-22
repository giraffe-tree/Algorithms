package me.giraffetree.java.algorithms.week02.day03;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author GiraffeTree
 * @date 2019-05-22
 */
public class BSTTest {

    public static void main(String[] args) {
        testPutAndGet();

    }

    public static void testPutAndGet() {
        BinarySearchTree<Integer, Integer> tree = getTree(1000);
        System.out.println(tree.get(11));
        BinarySearchTree<Integer, Integer>.Node node = tree.getNode(11);
        System.out.println(tree.get(213));
        System.out.println(tree.get(433));
        System.out.println(tree.get(123));
        System.out.println(tree.get(787));
    }

    /**
     * In-order traversal
     * Pre-order traversal
     * Post-order traversal
     */
    public static void iterator() {
        BinarySearchTree<Integer, Integer> tree = getTree(100);
        ArrayList<Integer> list = new ArrayList<>(128);
        BinarySearchTree<Integer, Integer>.Node currentNode = tree.getRoot();
        // 前序遍历
        while (true) {
            if (currentNode.getLeft() == null) {
                list.add(currentNode.getK());
                currentNode = currentNode.getParent();
                continue;
            }
            currentNode = currentNode.getLeft();
        }
    }

    /**
     * 前序遍历
     * 需要先找到第一个值, 然后遍历过去
     */
    public static BinarySearchTree.Node getNextNode(BinarySearchTree.Node node) {
        if (node == null) {
            return null;
        }
        if (node.getRight() != null) {
            return getNextNode(node.getRight());
        } else {
            return node;
        }
    }

    private static BinarySearchTree<Integer, Integer> getTree(int size) {
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
        ThreadLocalRandom current = ThreadLocalRandom.current();
        for (int i = 0; i < size; i++) {
            int num = current.nextInt(size);
            tree.put(num, num);
        }
        return tree;
    }
}
