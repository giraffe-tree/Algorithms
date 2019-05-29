package me.giraffetree.java.algorithms.week02.day07;

/**
 * @author GiraffeTree
 * @date 2019-05-29
 */
public class RedBlackTreeTest {

    public static void main(String[] args) {
        testRBT();
    }

    public static void testRBT() {
        RedBlackTree<Integer, String> tree = new RedBlackTreePrinter<>();
        int size = 6;
        for (int i = 0; i < size; i++) {
            System.out.println("\ntry to add " + i);
            tree.put(i, "num" + i);
            System.out.println("    finally");
            TreePrinter.print(tree.getRoot());
        }
        for (int i = 0; i < size; i++) {
            System.out.println("\ntry to delete min " + i);
            tree.deleteMin();
            System.out.println("    finally");
            TreePrinter.print(tree.getRoot());
        }

    }
}
