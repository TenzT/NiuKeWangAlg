package CH05;

/**
 * 使用哈希bitSet来查找输入值是否在集合内
 * 思路
 */
public class BloomFilter {

    private static int maxM = 100;        // bitSet的大小
    private static boolean[] bitSet = new boolean[maxM];    // bitMap
    public static int modHash(int input) {
        return input % maxM;
    }
    public static void put(int target) {
        int high = target / 10;
        int low = target % 10;
        // 准备3个不同的hash函数
        for (int i=1; i <= 3; i++) {
            bitSet[high + i*low] = true;
        }
    }

    public static boolean contains(int target) {
        boolean res = true;
        int high = target / 10;
        int low = target % 10;
        for (int i=1; i <= 3; i++) {
            res &= bitSet[high + i*low];
        }
        return res;
    }

    public static void main(String[] args) {
        int testTime = 20;
        int[] inputs = new int[testTime];
        for (int i=1; i <= testTime; i++) {
            int input = (int)(Math.random() * 200);
            inputs[i-1] = input;
            put(input);
            System.out.print(input + " ");
            if (i % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        for (int i=0; i < 10; i++) {
            int input = inputs[(int)(Math.random() * testTime)];
            System.out.println(input + " " + contains(input));
        }
        for (int i=0; i < 10; i++) {
            int input = (int)(Math.random() * 200);
            System.out.println(input + " " + contains(input));
        }
    }
}
