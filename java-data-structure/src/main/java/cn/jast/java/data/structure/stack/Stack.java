package cn.jast.java.data.structure.stack;

public interface Stack<T> {

    /**
     * 清空栈
     */
    void clear();

    /**
     * t入栈，成功返回true
     * @param t
     * @return
     */
    boolean push(T t);

    /**
     * 返回站定内容并弹出，成功返回真，否则返回假
     *
     * @return
     */
    T pop();

    /**
     * 返回栈顶内容但不弹出，成功返回真，否则返回假
     *
     * @return
     */
    T top();

    /**
     * 若栈已空返回真
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 若栈已满返回真
     *
     * @return
     */
    boolean isFull();
}
