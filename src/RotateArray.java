import java.util.ArrayList;
import java.util.Arrays;

/**
 * 189. 轮转数组
 *
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        new RotateArray().rotate(nums,1);
    }

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;
        if (k == 0) {
            return;
        }
        // 最大公约数
        int gcd = gcd(n, k);
        for (int i = 0; i < gcd; i++) {
            int cur = i;
            int next = (cur + k) % n;
            int pre = nums[cur];
            do {
                int temp = nums[next];
                nums[next] = pre;
                cur = next;
                pre = temp;
                next =  (cur + k) % n;
            } while (next !=i);
            nums[i]= pre;
        }
        System.out.println("end");
    }

    /**
     * 求 x,y的最大公约数
     */
    public static int gcd(int x , int y) {
        return y > 0 ? gcd(y, x %y) : x;
    }
}
