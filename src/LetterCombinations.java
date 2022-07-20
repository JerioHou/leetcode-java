import java.util.*;


/**
 * 17. 电话号码的字母组合
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {

    public static void main(String[] args) {
        new LetterCombinations().letterCombinations("34");
    }


    public List<String> letterCombinations(String digits) {
        if ("".equals(digits.trim())) {
            return new ArrayList<>();
        }
        Map<Character, String> phoneNumMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "prqs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        char[] chars = digits.toCharArray();
        List<String> result = new ArrayList<>();
        backtrack(result,phoneNumMap,digits,0,new StringBuffer());
        System.out.println(result);
        return result;
    }

    public void backtrack(List<String> result, Map<Character, String> phoneMap, String digits, int index, StringBuffer strBuffer) {
        if (index == digits.length()) {
            result.add(strBuffer.toString());
        } else {
            String letter = phoneMap.get(digits.charAt(index));
            int length = letter.length();
            for (int i = 0;i < length;i++) {
                strBuffer.append(letter.charAt(i));
                backtrack(result,phoneMap,digits,index+1,strBuffer);
                strBuffer.deleteCharAt(index);
            }
        }
    }
}