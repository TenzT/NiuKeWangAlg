package OJExercise.JianZhiOffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 找到数组中重复的数字
 * 数组长度为 n ，数字都在 0~n-1 的范围内，数组中某些数字是重复的，请找出数组中任意一个重复的数字
 *
 * 注意无效输入测试用例：空指针；拥有超出范围数字的
 */
public class FindDuplicateNumber {
    // 法1：对整个数组排序，遍历排序后的数组，但是排序一个数组需要O(nlogn + n)
    public static int findDuplicate1(int[] arr) {
        int res = Integer.MAX_VALUE;
        if (arr == null) {
            return res;
        }
        // 检查数组中是否包含超纲数字
        for (int i=0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] >= arr.length) {
                return res;
            }
        }

        Arrays.sort(arr);
        for (int i=0; i< arr.length-1; i++) {
//            数字检查放在这里是不合适的，因为很可能在扫到它之前就退出了
//            if (arr[i] < 0 || arr[i] >= arr.length) {
//                return res;
//            }
            if (arr[i] == arr[i+1]) {
                res = arr[i];
                break;
            }
        }
        return res;
    }

    // 法2：遍历整个数组，使用hash表记录所有元素看看是否有重复的元素，时间复杂度和空间复杂度都是O(n)
    public static int findDuplicate2(int[] arr) {
        int res = Integer.MAX_VALUE;
        if (arr == null) {
            return res;
        }
        // 检查数组中是否包含超纲数字
        for (int i=0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] >= arr.length) {
                return res;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
            } else {
                res = arr[i];
                break;
            }
        }
        return res;
    }

    // 法3：利用数字都在 0~n-1 的范围内这个条件，如果这个数组中没有重复的数字，那么当数组排序之后数字i将出现在下表为i的位置
    // 由于数组中有重复数字，有些位置可能存在多个数字，有些位置可能没有数字，利用这个特性，可以将空间复杂度降为O(1)，时间复杂度为O(n^2)
    public static int findDuplicate3(int[] arr) {
        int res = Integer.MAX_VALUE;
        if (arr == null) {
            return res;
        }
        // 检查数组中是否包含超纲数字
        for (int i=0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] >= arr.length) {
                return res;
            }
        }

        for (int i=0; i<arr.length; i++) {
            while (arr[i] != i) {
                // 结束条件
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                }
                // 交换两个数字
                int tmp = arr[i];
                arr[i] = arr[arr[i]];
                arr[arr[i]] = tmp;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findDuplicate1(arr));
        System.out.println(findDuplicate2(arr));
        System.out.println(findDuplicate3(arr));

        arr = new int[]{2, 11, 1, 0, 2, 5, 3};
        System.out.println(findDuplicate1(arr));
        System.out.println(findDuplicate2(arr));
        System.out.println(findDuplicate3(arr));
    }
}
