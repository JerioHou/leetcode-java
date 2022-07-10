import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/**
 * 8. 字符串转换整数 (atoi)
 *
 * https://leetcode.cn/problems/string-to-integer-atoi/
 */
public class StringToIntegerAtoi {


    public static void main(String[] args) {
        String s = "9223372036854775808";
        System.out.println(myAtoi(s));
        System.out.println(Integer.valueOf(s));
    }

    public static int myAtoi(String s) {


        Map<String,Integer> nums = new HashMap<String,Integer>(){
            {
                put("0",0);
                put("1",1);
                put("2",2);
                put("3",3);
                put("4",4);
                put("5",5);
                put("6",6);
                put("7",7);
                put("8",8);
                put("9",9);
            }
        };
        Stack<Integer> stack = new Stack<>();
        s = s.trim();
        if ("".equals(s)) {
            return 0;
        }
        boolean positive = true;
        for (int i = 0; i < s.length();i++) {
            String substr = s.substring(i, i+1);
            if (i == 0) {
                if ("-".equals(substr)) {
                    positive = false;
                    continue;
                } else if ("+".equals(substr)) {
                    continue;
                }
            }
            if (nums.containsKey(substr)){
                stack.push(nums.get(substr));
            }else {
                break;
            }
        }
        if (stack.isEmpty()) {
            return 0;
        }
        Iterator<Integer> iterator = stack.iterator();
        Long result = 0L;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            result = result * 10 + next;
            if (result > Integer.MAX_VALUE) {
                break;
            }
        }
        if (positive) {
            return  result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result.intValue();
        }
        result = result * -1;
        return result < Integer.MIN_VALUE ? Integer.MIN_VALUE : result.intValue();
    }

}
