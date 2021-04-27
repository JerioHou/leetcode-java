import jdk.nashorn.internal.ir.IfNode;

import java.util.Arrays;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 */
public class SmallestK {


    public static void main(String[] args) {
//        int[] arr = {62577,-220,-8737,-22,-6,59956,5363,-16699,0,-10603,64,-24528,-4818,96,5747,2638,-223,37663,-390,35778,-4977,-3834,-56074,7,-76,601,-1712,-48874,31,3,-9417,-33152,775,9396,60947,-1919,683,-37092,-524,-8,1458,80,-8,1,7,-355,9,397,-30,-21019,-565,8762,-4,531,-211,-23702,3,3399,-67,64542,39546,52500,-6263,4,-16,-1,861,5134,8,63701,40202,43349,-4283,-3,-22721,-6,42754,-726,118,51,539,790,-9972,41752,0,31,-23957,-714,-446,4,-61087,84,-140,6,53,-48496,9,-15357,402,5541,4,53936,6,3,37591,7,30,-7197,-26607,202,140,-4,-7410,2031,-715,4,-60981,365,-23620,-41,4,-2482,-59,5,-911,52,50068,38,61,664,0,-868,8681,-8,8,29,412};
        int[] arr = {1,2,3};
        System.out.println(Arrays.toString(smallestK(arr,5)));
    }

    public static int[] smallestK(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        if ( k <= 0) {
            return new int[0];
        }
        findKth(arr, 0, arr.length - 1, k);
        int[] result = new int[k];
        System.arraycopy(arr,0,result,0,k);
        return result;

    }

    private static int findKth(int[] arr, int left,int right, int k){
        int partition = pattiton(arr, left, right);
        if (partition == k-1) {
            return partition;
        }
        if (partition < k-1) {
            return findKth(arr,partition+1,right,k);
        } else {
            return findKth(arr,left,partition-1,k);
        }
    }


    /**
     *
     * @param arr 待排序数组
     * @param l 起点
     * @param r 重点
     * @return 返回一个下标p， 该下标左侧都小于arr[p]，右侧都大于等于arr[p]
     */
    private static int pattiton(int[] arr,int l,int r) {
        int povit = arr[r];
        int p = l;
        for (int i = l; i <r; i++) {
            if (arr[i] < povit) {
                swap(arr,p,i);
                p++;
            }
        }
        swap(arr,p,r);
        return p;
    }

    private static void swap(int[] arr,int left,int right){
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
