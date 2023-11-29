public class AddBinary {

    public static void main(String[] args) {
        String a = "101111";
        String b = "10";
        System.out.println(new AddBinary().addBinary(a,b));
    }

    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        // 进位
        int carry = 0;
        for (int i = a.length()-1,j = b.length()-1;i>=0 || j>=0;i--,j--) {
            int temp;
            if (i>=0 && j>=0) {
                temp = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            } else {
                temp = i >= 0 ? a.charAt(i) - '0' + carry : b.charAt(j) - '0' + carry;
            }
            stringBuilder.append(temp%2);
            carry = temp /2 ;
        }
        if (carry == 1) {
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }

}
