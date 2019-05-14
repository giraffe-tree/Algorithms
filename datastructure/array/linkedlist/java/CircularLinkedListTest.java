package me.giraffetree.java.algorithms.week01.day02;

/**
 * @author GiraffeTree
 * @date 2019-05-14
 */
public class CircularLinkedListTest {

    public static void main(String[] args) {

        testAddAndRemove();
        testAddFirstAndRemoveLast();
        testAddLastAndRemoveFirst();
    }

    public static void testAddAndRemove() {
        int max = 1000;
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        for (int i = 0; i < max; i++) {
            list.add(i);
        }
        System.out.println(list.size());
        for (int i = 0; i < max; i++) {
            list.remove(i);
        }
        System.out.println(list.size());

    }

    public static void testAddFirstAndRemoveLast() {
        int max = 1000;
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        for (int i = 0; i < max; i++) {
            list.addFirst(i);
        }
        System.out.println(list.size());
        for (int i = 0; i < max; i++) {
            list.removeLast();
        }
        System.out.println(list.size());
    }


    public static void testAddLastAndRemoveFirst() {
        int max = 5;
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        for (int i = 0; i < max; i++) {
            list.addLast(i);
        }
        System.out.println(list.size());
        for (int i = 0; i < max; i++) {
            list.removeFirst();
        }
        System.out.println(list.size());
    }

}
