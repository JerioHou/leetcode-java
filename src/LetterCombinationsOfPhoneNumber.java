import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {


    public static void main(String[] args) {
        new LetterCombinationsOfPhoneNumber().letterCombinations("23");
    }


    public List<String> letterCombinations(String digits) {
        String[] split = digits.split("");
        String[][] source = new String[split.length][];
        for (int i = 0; i < split.length;i++) {
            source[i] = phoneNums[Integer.parseInt(split[i]) -2];
        }

        List<String> list = new ArrayList<>();

        return null;
    }

    String[][] phoneNums = {
            {"a","b","c"},
            {"d","e","f"},
            {"g","h","i"},
            {"j","k","l"},
            {"m","n","o"},
            {"p","q","r","s"},
            {"t","u","v"},
            {"w","x","y","z"}
    };
}
