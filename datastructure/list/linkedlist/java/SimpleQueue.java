package me.giraffetree.java.algorithms.week01.day02;

/**
 * @author GiraffeTree
 * @date 2019-05-13
 */
public interface SimpleQueue<T> {

    void addFirst(T t);

    void addLast(T t);

    T removeFirst();

    T removeLast();

}
