package CH03;

public class ArrayStack {
    private Integer[] stackData;  // 栈的数据
    private Integer size;   // 数据个数
    private int cur;

    public ArrayStack(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        size = 0;
        cur = -1;
        stackData = new Integer[initSize];
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return stackData[cur];
    }

    public Integer pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The stack is empty");
        }
        size--;
        return stackData[cur--];
    }

    public void push(Integer obj) {
        if(size == stackData.length) {
            throw new ArrayIndexOutOfBoundsException("The stack is full");
        }
        stackData[++cur] = obj;
        size++;
    }

    private void printArray() {
        for (int i=0;i<size;i++) {
            System.out.print(stackData[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int N = 5;
        ArrayStack stack = new ArrayStack(N);
//        stack.pop();
        for(int i = 0; i < N + 2; i++) {
            if(i==2) {
                System.out.println(stack.peek());
            }
            if(i==3) {
                System.out.println(stack.pop());
            }
            stack.push(i);
            stack.printArray();
        }
    }
}
