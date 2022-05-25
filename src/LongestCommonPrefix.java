/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 提示：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower","flow",""};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }


    public String longestCommonPrefix(String[] strs) {
        int shortest = getShortest(strs);
        int index = getIndex(strs,shortest);
        return strs[0].substring(0,index);
    }

    /**
     * 计算下标
     * @param strs
     * @param shortest
     * @return
     */
    private int getIndex(String[] strs ,int shortest) {
        int i = 0;
        while (i < shortest) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length;j++) {
                if (strs[j].charAt(i) != c) {
                    return i;
                }
            }
            i++;
        }
        return i;
    }

    /**
     * 获取最短的字符串的长度
     * @param strs
     * @return
     */
    private int getShortest(String[] strs) {
        int shortest = strs[0].length();
        for (int i = 1 ; i< strs.length;i++) {
            String str = strs[i];
            if (str.length() < shortest) {
                shortest = str.length();
            }
        }
        return shortest;
    }
}
