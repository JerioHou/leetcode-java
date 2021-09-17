import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。

 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/n-queens
 */
public class SolveNQueens {

    public static void main(String[] args) {
        List<List<String>> lists = new SolveNQueens().solveNQueens(4);
        System.out.println(Arrays.toString(lists.toArray()));
    }

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        // 下标对应行，值对应该行中Q所在的位置（列）
        int[] arr = new int[n];
        calQueen(arr,n,0);
        return result;
    }

    private void calQueen(int[] arr,int n,int row){
        if (row == n) {
            result.add(convert(arr));
            return;
        }

        for (int column = 0;column <n; column ++) {
            if (isOk(arr,row,column)){
                arr[row] = column;
                calQueen(arr,n,row+1);
            }
        }
    }

    /**
     * row行column列是否符合规则
     */
    private boolean isOk(int[] arr,int row,int column) {
        int leftup = column -1 ;
        int rightup = column + 1;
        for (int i = row -1; i >= 0  ; i--) {
            if (arr[i] == column)
                return false;
            if (leftup >= 0 && arr[i] == leftup)
                return false;
            if (rightup < arr.length && arr[i] == rightup)
                return false;
            leftup--;
            rightup++;
        }
        return true;
    }


    private List<String> convert(int[] arr) {
        List<String> result = new ArrayList<>();
        int n = arr.length;
        for (int i = 0 ; i < n ; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0 ; j < n ; j++) {
                if (arr[i] != j) {
                    sb.append(".");
                } else {
                    sb.append("Q");
                }
            }
            result.add(sb.toString());
        }
        return result;
    }


}
