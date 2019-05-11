package me.giraffetree.java.algorithms.week01.day01;

/**
 * @author GiraffeTree
 * @date 2019-05-11
 */
public class DynamicListTest {

    public static void main(String[] args) {
        testAddAndRemove();
        testGetAndSet();
    }

    public static void testAddAndRemove() {
        DynamicList<Integer> list = new DynamicList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        System.out.println(list.size());
        for (int j = 9999; j >= 0; j--) {
            list.remove(j);
        }
        System.out.println(list.isEmpty());
        System.out.println(list.size());
    }

    public static void testGetAndSet() {
        DynamicList<Integer> list = new DynamicList<>();
        System.out.println(list.isEmpty());
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        System.out.println(list.isEmpty());
        System.out.println(list.get(9999));
        list.set(9999, 290);
        System.out.println(list.get(9999));
        try {
            list.get(10000);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("get out of bounds error: " + e.getMessage());
        }

    }

}
