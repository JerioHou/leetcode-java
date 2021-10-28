public class NthTribonacciNumber {


    public static int tribonacci3(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int p = 0, q = 0, r = 1, s = 1;
        for (int i = 3; i <= n; ++i) {
            p = q;
            q = r;
            r = s;
            s = p + q + r;
        }
        return s;

    }
    public static int tribonacci2(int n) {
        int[] result = new int[4];
        result[0] = 0;
        result[1] = 1;
        result[2] = 1;
        result[3] = 2;
        if (n < 4) {
            return result[n];
        }

        for ( int i = 4; i <= n; i++) {
            result[i % 4] = result[(i-1)%4] + result[(i-2)%4]+result[(i-3)%4];
        }
        return result[n%4];
    }

    public static int tribonacci(int n) {
        if (n == 0 ) {
            return 0;
        }
        if (n == 1 || n ==2) {
            return 1;
        }
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 1;
        for (int i = 3; i <= n; i++) {
            result[i] = result[i-1] + result[i-2] + result[i-3];
        }
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(9));
        System.out.println(tribonacci2(9));
        System.out.println(tribonacci3(9));
    }
}
