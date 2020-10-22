package cn.jast.java.data.structure.list;

public interface List<T> {

    /**
     * 链表是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 清空链表
     */
    void clear();

    /**
     * 实际长度
     * @return
     */
    int length();

    /**
     * 表尾插入元素
     * @param t
     * @return
     */
    boolean append(T t);

    /**
     * 表头插入元素
     * @param t
     * @return
     */
    boolean appendHead(T t);

    /**
     * 在位置p插入元素t
     * @param p
     * @param t
     * @return
     */
    boolean insert(int p ,T t);

    /**
     * 删除位置p处的元素
     * @param p
     * @return
     */
    boolean delete(int p);

    /**
     * 获取位置p处的元素
     * @param p
     * @return
     */
    T getValue(int p);

    /**
     * 获取元素p所在的位置
     * @param t
     * @return
     */
    int getFirstPos(T t);

}
