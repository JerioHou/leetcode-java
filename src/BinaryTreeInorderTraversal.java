import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        handle(root,result);
        return result;

    }

    public void handle(TreeNode root, List<Integer> result) {
        if (root != null) {
            handle(root.left,result);
            result.add(root.val);
            handle(root.right,result);
        }
    }
}
