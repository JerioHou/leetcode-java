public class ZigzagConversion {


    public static void main(String[] args) {
        ZigzagConversion zg = new ZigzagConversion();
        System.out.println(zg.convert("ABCDE",4));
        System.out.println(zg.convert("PAYPALISHIRING",4).equals("PINALSIGYAHRPI"));

    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int cycle = 2 * (numRows -1);
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        int times = s.length() / cycle + 1;
        for (int i = 0; i < numRows; i++){
            for (int j =0; j < times; j++){
                if (j * cycle+i < s.length()) {
                    builder.append(chars[j * cycle+i]);
                }
                if (i != 0 && i != numRows-1) {
                    int after = j * cycle+ (cycle -i);
                    if (after < s.length()) {
                        builder.append(chars[after]);
                    }
                }
            }
        }
        return builder.toString();
    }

}
