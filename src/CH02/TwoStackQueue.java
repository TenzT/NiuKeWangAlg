package CH02;
/**
 * 用两个栈实现一个队列
 */

import java.util.Stack;

public class TwoStackQueue<E> {
    Stack<E> head;  // 用于弹出头
    Stack<E> end;  // 用于尾部插入

    public TwoStackQueue() {
        head = new Stack<E>();
        end = new Stack<E>();
    }

    public E peek() {
        if (!head.isEmpty()) {  // 头队列非空
            return head.peek();
        } else {    // 头队列为空
            if (end.isEmpty()) {
                throw new RuntimeException("队列为空");
            } else {
                while (end.size() > 0) {
                    head.push(end.pop());
                }
                return head.peek();
            }
        }
    }

    public E poll() {
        if (!head.isEmpty()) {  // 头队列非空
            return head.pop();
        } else {    // 头队列为空
            if (end.isEmpty()) {
                throw new RuntimeException("队列为空");
            } else {
                while (end.size() > 0) {
                    head.push(end.pop());
                }
                return head.pop();
            }
        }
    }

    public void push(E e) {
        while(!head.isEmpty()) {
            end.push(head.pop());
        }
        end.push(e);
    }



    public void printQueue() {
        System.out.print(head);
        System.out.print(end);

        System.out.println("    size: "  + (head.size() + end.size()));
    }

    public static void main(String[] args) {
        int N = 5;
        TwoStackQueue queue = new TwoStackQueue();
//        stack.pop();
        for(int i = 0; i < N + 2; i++) {
            if(i==2) {
                System.out.println(queue.peek());
                queue.printQueue();
            }
            if(i==3) {
                System.out.println(queue.poll());
                queue.printQueue();
            }
            queue.push(i);
            if(i==4) {
                System.out.println(queue.poll());
            }
            queue.printQueue();
        }

    }
}
