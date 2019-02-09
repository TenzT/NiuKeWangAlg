package CH02;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueStack<E> {
    private Queue<E> queue;     // 主数据队列
    private Queue<E> help;      //  辅助队列

    public TwoQueueStack() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    private void swap() {
        Queue<E> tmp = help;
        help = queue;
        queue = tmp;
    }

    public void push(E e) {
        queue.add(e);   // 从数据队列的头插入
    }

    public E peek() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        while (queue.size() > 1) {
            help.add(queue.poll());
        }
        E value = queue.remove();
        help.add(value);
        swap();
        return value;
    }

    public E poll() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        while (queue.size() > 1) {
            help.add(queue.poll());
        }
        E value = queue.remove();
        swap();
        return value;
    }

    public void printQueue() {
        for(E e : queue) {
            System.out.print(e + " ");
        }
        System.out.println("    size: "  + queue.size());
    }

    public static void main(String[] args) {
        int N = 5;
        TwoQueueStack<Integer> queue = new TwoQueueStack<>();
        for(int i = 0; i < N + 2; i++) {
            if(i==2) {
                System.out.println(queue.peek());
            }
            if(i==3) {
                System.out.println(queue.poll());
            }
            queue.push(i);
            queue.printQueue();
        }
    }
}
