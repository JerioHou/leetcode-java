import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Search {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums,0));
    }

    public static int search(int[] nums, int target) {
        int index = 0;
        for (int i = 0;i < nums.length-1;i++){
            if (nums[i] > nums[i+1]) {
                index = i+1;
                break;
            }
        }
        int result = binarySearch(nums, 0, index - 1, target);
        if (result != -1) {
            return result;
        }
        return binarySearch(nums, index, nums.length-1, target);
    }

    public static int binarySearch(int[] arr,int low,int high,int target) {
        if (low > high) {
            return -1;
        }
        int index = low + ((high-low)>>1);
        if (arr[index] == target) {
            return index;
        }
        if (arr[index] > target) {
            return binarySearch(arr,low,index-1,target);
        } else {
            return binarySearch(arr,index+1,high,target);
        }
    }
}
