package me.giraffetree.java.algorithms.week01.day01;

import java.util.Iterator;

/**
 * dynamicList for java 8
 *
 * @author GiraffeTree
 * @date 2019-05-11
 */
public class DynamicList<T> implements SimpleList<T> {

    private final static int DEFAULT_MAX_SIZE = 16;
    private T[] content;
    /**
     * end flag
     */
    private int endFlag = 0;
    /**
     * max size for this list
     */
    private int maxSize;

    @SuppressWarnings("unchecked")
    public DynamicList() {
        this.maxSize = DEFAULT_MAX_SIZE;
        this.content = (T[]) new Object[this.maxSize];
    }

    /**
     * init
     *
     * @param expectedSize expected list size
     */
    @SuppressWarnings("unchecked")
    public DynamicList(int expectedSize) {
        this.maxSize = getSuitableSize(expectedSize);
        this.content = (T[]) new Object[this.maxSize];
    }

    private int getSuitableSize(int expectedSize) {
        if (expectedSize < 4) {
            return 4;
        }
        int count = 1;
        while ((expectedSize = expectedSize >> 1) != 0) {
            count++;
        }
        if (count == 32) {
            return Integer.MAX_VALUE;
        }
        return 1 << (Math.max(count, 4));
    }

    @Override
    public int size() {
        return endFlag;
    }

    @Override
    public boolean isEmpty() {
        return endFlag == 0;
    }

    private void checkAndResize(int change) {
        int exp = change + endFlag;

        if (change > 0) {
            if (exp > maxSize) {
                int suitableSize = getSuitableSize(exp);
                content = copy(suitableSize);
                this.maxSize = suitableSize;
            }
        } else if (change < 0) {
            if (maxSize > 64 && (maxSize >> 2) > endFlag) {
                int suitableSize = getSuitableSize(exp);
                content = copy(suitableSize);
                this.maxSize = suitableSize;
            }
        }
    }

    /**
     * from Arrays.copyOf()
     */
    private T[] copy(int newLength) {
        @SuppressWarnings("unchecked")
        T[] copy = (T[]) new Object[newLength];
        System.arraycopy(content, 0, copy, 0,
                Math.min(content.length, newLength));
        return copy;
    }

    @Override
    public boolean add(T t) {
        checkAndResize(1);
        content[endFlag] = t;
        endFlag += 1;
        return true;
    }

    @Override
    public boolean remove(T t) {
        checkAndResize(-1);
        for (int i = 0; i < endFlag; i++) {
            boolean checked = (t == null && null == content[i]) || (t != null && t.equals(content[i]));
            if (checked) {
                System.arraycopy(content, i + 1, content, i,
                        endFlag - i);
                endFlag -= 1;
                return true;
            }
        }
        return false;
    }

    @Override
    public T get(int index) {
        if (index > endFlag - 1) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return content[index];
    }

    @Override
    public T set(int index, T t) {
        if (index > endFlag - 1) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        T origin = content[index];
        content[index] = t;
        return origin;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index;
            @Override
            public boolean hasNext() {
                return index < endFlag;
            }
            @Override
            public T next() {
                if (index < endFlag) {
                    return content[index++];
                }
                throw new ArrayIndexOutOfBoundsException(index);
            }
        };
    }


}
