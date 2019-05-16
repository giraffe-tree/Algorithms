package me.giraffetree.java.algorithms.week01.day02;

/**
 * @author GiraffeTree
 * @date 2019-05-13
 */
public class SinglyLinkedListTest {

    public static void main(String[] args) {
        testAddAndRemove();
        testStack();
        testQueue();
    }

    public static void testAddAndRemove() {
        int max = 1000;
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < max; i++) {
            list.add(i);
        }
        System.out.println(list.size());
        Integer last = list.get(list.size() - 1);
        if (last != max - 1) {
            System.out.println("last is wrong");
            return;
        }

        for (int i = max - 1; i >= 0; i--) {
            list.remove(i);
        }
        System.out.println(list.size());

        list.add(1);
        System.out.println(list.get(0).equals(1));
        System.out.println(list.removeFirst());
        list.add(1);
        System.out.println(list.get(0).equals(1));
    }

    public static void testStack() {
        SinglyLinkedList<Integer> stack = new SinglyLinkedList<>();
        int max = 1000;
        for (int i = 0; i < max; i++) {
            stack.addLast(i);
        }
        System.out.println(stack.size());
        for (int i = 0; i < max; i++) {
            stack.removeLast();
        }
        System.out.println(stack.size());
        stack.add(1);
        System.out.println(stack.get(0).equals(1));
        System.out.println(stack.removeFirst());
        stack.add(1);
        System.out.println(stack.get(0).equals(1));
    }

    public static void testQueue() {
        SinglyLinkedList<Integer> queue = new SinglyLinkedList<>();
        int max = 1000;
        for (int i = 0; i < max; i++) {
            queue.addLast(i);
        }
        System.out.println(queue.size());
        for (int i = 0; i < max; i++) {
            queue.removeFirst();
        }
        System.out.println(queue.size());
        queue.add(1);
        System.out.println(queue.get(0).equals(1));
        System.out.println(queue.removeFirst());
        queue.add(1);
        System.out.println(queue.get(0).equals(1));
    }

}
