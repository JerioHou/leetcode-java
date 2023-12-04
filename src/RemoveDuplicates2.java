/**
 * 80. 删除有序数组中的重复项 II
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
 */

public class RemoveDuplicates2 {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(new RemoveDuplicates2().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int idx = 1;
        int temp = nums[0]; int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == temp) {
                count++;
                if (count <= 2) {
                    nums[idx]= nums[i];
                    idx++;
                }
            } else {
                count = 1;
                temp = nums[i];
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }
}
