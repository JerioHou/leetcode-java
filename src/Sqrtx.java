public class Sqrtx {


    public static void main(String[] args) {
        System.out.println(new Sqrtx().mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 1 ; int right = x;
        while (true) {
            int mid = ((right - left) >> 1) + left;
            if (x / mid >= mid && x / (mid+1) < (mid+1) ) {
                return mid;
            }
            if (x / mid > mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
    }


}
