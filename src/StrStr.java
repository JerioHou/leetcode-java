public class StrStr {

    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("hello","ll"));
        System.out.println(new StrStr().strStr("aaaaa","aaaaa"));
        System.out.println(new StrStr().strStr("aaaaa","a"));
    }


    public int strStr(String haystack, String needle) {
        int n = needle.length();
        if (n == 0) {
            return 0;
        }
        for (int i = 0 ; i <= haystack.length() - n; i++) {
            if (needle.equals(haystack.substring(i,i+n))) {
                return i;
            }
        }
        return -1;
    }
//    private boolean isEqual(String hayStack, int start, int end,String needle) {
//        for (int i = 0;i < end - start;i++) {
//            if (needle.charAt(i) != hayStack.charAt(i+start)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
