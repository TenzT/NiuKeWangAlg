package CH02;

public class ArrayQueue {
    private Integer[] queueData;
    private int head;   // 队头指针
    private int end;    // 队尾指针
    private int size;   // 队列元素个数

    public ArrayQueue(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        queueData = new Integer[initSize];
        size = 0;
        head = 0;
        end = -1;
    }

    public Integer peek() {
        if (size <= 0) {
            return null;
        }
        return queueData[head];
    }

    public Integer poll() {
        if (size <= 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        size--;
        Integer tmp = queueData[head];
        head = head==queueData.length-1? 0 : head+1;
        return tmp;
    }

    public void push(Integer obj) {
        if(size == queueData.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        size++;
        end = end==queueData.length-1 ? 0 : end+1;
        queueData[end] = obj;
    }

    private void printArray() {
        if (end >= head) {
            for (int i=head;i<=end;i++) {
                System.out.print(queueData[i] + " ");
            }
        } else {
            for (int i=head; i< queueData.length;i++) {
                System.out.print(queueData[i] + " ");
            }
            for (int i=0;i<=end;i++) {
                System.out.print(queueData[i] + " ");
            }
        }

        System.out.println("    size: "  + size);
    }

    public static void main(String[] args) {
        int N = 5;
        ArrayQueue queue = new ArrayQueue(N);
//        stack.pop();
        for(int i = 0; i < N + 2; i++) {
            if(i==2) {
                System.out.println(queue.peek());
            }
            if(i==3) {
                System.out.println(queue.poll());
            }
            queue.push(i);
            queue.printArray();
        }
    }
}
