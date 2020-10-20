package cn.jast.java.data.structure.queue;

/**
 * TODO
 * @param <T>
 */
public interface Queue<T> {

    void clear();

    /**
     * 入队
     * @param t
     * @return
     */
    boolean enQueue(T t);

    /**
     * 出队
     * @return
     */
    T deQueue();

    T getFront();

    boolean isEmpty();

    boolean isFull();
}
