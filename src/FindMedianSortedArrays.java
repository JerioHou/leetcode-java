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
