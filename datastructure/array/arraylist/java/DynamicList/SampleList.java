package me.giraffetree.java.algorithms.week01.day01;

/**
 * @author GiraffeTree
 * @date 2019-05-11
 */
public interface SampleList<T> {

    int size();

    boolean isEmpty();

    boolean add(T t);

    boolean remove(T t);

    T get(int index);

    T set(int index, T t);


}
