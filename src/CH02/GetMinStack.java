package CH02;

import java.util.Stack;

/**
 * 实现一个特殊的栈， 在实现栈的基本功能的基础上， 再实现返
 * 回栈中最小元素的操作
 * 实现思路：增加一个辅助的最小值栈，该栈栈顶为栈内最小的元素
 */
public class GetMinStack<E extends Comparable> {
    private Stack<E> dataStack;     // 普通的栈
    private Stack<E> minStack;      // 装最小值的栈

    public GetMinStack() {
        this.dataStack = new Stack<E>();
        this.minStack = new Stack<E>();
    }

    public void push(E e) {
        // 插入数据栈
        dataStack.push(e);

        // 插入最小值栈
        if (minStack.isEmpty()) {
            minStack.push(e);
        } else if (e.compareTo(minStack.peek()) < 0) {
            minStack.push(e);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public E pop() {
        if(dataStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        E value = dataStack.pop();
        minStack.pop();
        return value;
    }

    public E getMin() {
        if(minStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return minStack.peek();
    }

    public static void main(String[] args) {
        GetMinStack<Integer> stack = new GetMinStack<Integer>();
        stack.push(4);
        System.out.println(stack.getMin());
        stack.push(4);
        System.out.println(stack.getMin());
        stack.push(3);
        System.out.println(stack.getMin());
        stack.push(5);
        System.out.println(stack.getMin());
        stack.push(1);
        System.out.println(stack.getMin());

    }


}
