import java.util.ArrayList;
import java.util.List;

/**
 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 有效括号组合需满足：左括号必须以正确的顺序闭合。

 https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        List<String> strings = new GenerateParenthesis().generateParenthesis(3);
        System.out.println(strings);
    }


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        backTrack(result,curr,0,0,n);
        return result;
    }

    private void backTrack(List<String> result, StringBuilder curr, int open, int close, int n) {
        if (curr.length() == 2 * n) {
            result.add(curr.toString());
            return;
        }
        if (open < n) {
            curr.append("(");
            backTrack(result,curr,open + 1,close,n);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (close < open) {
            curr.append(")");
            backTrack(result,curr,open,close + 1,n);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}


