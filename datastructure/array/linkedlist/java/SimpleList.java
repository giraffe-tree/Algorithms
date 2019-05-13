package me.giraffetree.java.algorithms.week01.day02;

/**
 * @author GiraffeTree
 * @date 2019-05-11
 */
public interface SimpleList<T> extends Iterable<T>{

    int size();

    boolean isEmpty();

    boolean add(T t);

    boolean remove(T t);

    T get(int index);

    T set(int index, T t);
}
