/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *  
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {

        System.out.println(new DivideTwoIntegers().divide(-1010369383, -2147483648));
        System.out.println(new DivideTwoIntegers().divide(-2147483648, 2147483647));
        System.out.println(new DivideTwoIntegers().divide(-10, 3));
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return dividend;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        boolean nagitive = false;
        if (dividend > 0 ) {
            dividend = -dividend;
            nagitive = !nagitive;
        }
        if (divisor > 0) {
            divisor = -divisor;
            nagitive = !nagitive;
        }

        return nagitive ? -myDivide(dividend,divisor) : myDivide(dividend,divisor);
    }
    // 此处dividend divisor 都是负数
    private int myDivide(int dividend, int divisor) {
        if (dividend > divisor) {
            return 0;
        }
        int i = 1;
        int sum = divisor;
        while (true) {
            if (sum < dividend - sum) {
                break;
            }
            sum = sum + sum;
            i = i + i;
        }
        return i + divide(dividend - sum,divisor);
    }
}
