package me.giraffetree.java.algorithms.week02.day03;

/**
 * @author GiraffeTree
 * @date 2019-05-22
 */
public interface Tree<K, V> extends Iterable<K> {

    int size();

    V get(K k);

    void put(K k, V v);

    K max();

    K min();

    int rank(K k);

}
