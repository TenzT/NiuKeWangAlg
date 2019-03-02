package CH05;

import java.util.Random;

/**
 * 使用哈希bitSet来查找输入值是否在集合内
 * 思路：与hashSet一样，只是只做查询的话，记录是否存在即可
 */
public class BitSetFilter {

    private static int maxM = 10000;        // bitSet的大小
    private static boolean[] bitSet = new boolean[maxM];    // bitSet,
    public static int modHash(int input) {
        return input % maxM;
    }
    public static void put(int target) {
        bitSet[modHash(target)] = true;
    }

    public static boolean contains(int target) {
        return bitSet[modHash(target)];
    }

    public static void main(String[] args) {
        int testTime = 20;
        int[] inputs = new int[testTime];
        for (int i=1; i <= testTime; i++) {
            int input = (int)(Math.random() * 20000);
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
            int input = (int)(Math.random() * 20000);
            System.out.println(input + " " + contains(input));
        }
    }
}
