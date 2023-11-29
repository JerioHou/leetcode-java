import java.awt.font.NumericShaper;

public class FindFirstAndLast {


    public static void main(String[] args) {

        int[] nums = {8,8,8,8,8,9};
        new FindFirstAndLast().searchRange(nums,19);
    }

    int min = -1,max = -1;

    public int[] searchRange(int[] nums, int target) {
        binarySearch(nums,0,nums.length-1,target);
        System.out.println(min);
        System.out.println(max);
        return new int[]{min,max};

    }

    public void binarySearch(int nums[],int left, int right, int target) {
        if (left <= right) {
            if (nums[left] > target || nums[right] < target) {
                return ;
            }
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] == target) {
                if (min == -1) {
                    min = mid;
                } else {
                    min = Math.min(min,mid);
                }
                max = Math.max(max,mid);
            }
            binarySearch(nums,left,mid-1,target);
            binarySearch(nums,mid+1,right,target);
        }
    }
}
