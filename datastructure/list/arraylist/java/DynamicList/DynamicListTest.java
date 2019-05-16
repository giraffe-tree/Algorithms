package me.giraffetree.java.algorithms.week01.day01;

import java.util.ArrayList;

/**
 * @author GiraffeTree
 * @date 2019-05-11
 */
public class DynamicListTest {

    public static void main(String[] args) {
        testAddAndRemove();
        testGetAndSet();
        testArrayListAndDynamicList();
        testIterator();
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

    public static void testArrayListAndDynamicList() {
        ArrayList<Integer> arrayList = new ArrayList<>(16);
        DynamicList<Integer> dynamicList = new DynamicList<>(16);
        int size = 1000000;

        long l1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long l2 = System.currentTimeMillis();
        System.out.println("arrayList cost: " + (l2 - l1) + "ms");

        long l3 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            dynamicList.add(i);
        }
        long l4 = System.currentTimeMillis();
        System.out.println("dynamicList cost: " + (l4 - l3) + "ms");
    }

    public static void testIterator() {
        DynamicList<Integer> list = new DynamicList<>();
        System.out.println(list.isEmpty());
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        for (Integer element : list) {
            if (element > 9998) {
                System.out.println(element);
            }
        }
    }


}
