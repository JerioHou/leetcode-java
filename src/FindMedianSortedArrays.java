/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class FindMedianSortedArrays{
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int i= 0,j = 0;
		int n1 = nums1.length,n2 = nums2.length;
		int total = n1 + n2;
		int[] merge = new int[total];
		int half = total / 2 ;
		int cursor = 0;
		while (i < n1 && j < n2 && cursor != half+1) {
			if (nums1[i] < nums2[j]) {
				merge[cursor] = nums1[i];
				i++;
			} else {
				merge[cursor] = nums2[j];
				j++;
			}
			cursor ++;
		}
		while(i < n1 && cursor != half+1){
			merge[cursor] = nums1[i];
			i++;
			cursor ++;
		}
		while(j < n2 && cursor != half+1){
			merge[cursor] = nums2[j];
			j++;
			cursor ++;
		}
		if (total  % 2 == 0) {
			return (double)(merge[cursor-1] + merge[cursor-2])/2;
		}else{
			return(double)merge[cursor-1];
		}
	}
}


