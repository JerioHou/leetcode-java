import java.util.ArrayList;
import java.util.List;

/**

 https://leetcode-cn.com/problems/pascals-triangle/

 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。

 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    list.add(1);
                } else  {
                    list.add(j,result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(3));
    }

}
