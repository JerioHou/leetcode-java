
/**
    统计所有小于非负整数 n 的质数的数量。
	https://leetcode-cn.com/problems/count-primes/
 */
public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(100));
    }


    public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        for (int i = 0; i < n ; i++) {
            isPrime[i]= true;
        }

        for (int j =2; j < n; j++){
            if (isPrime[j]) {
                count++;
            }
            for (int k = 2 * j; k < n; k+=j) {
                isPrime[k] = false;
            }
        }
        return count;
    }
}


