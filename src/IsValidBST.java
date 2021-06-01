import java.util.LinkedList;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        LinkedList<Integer> list = new LinkedList<>();
        return inOrder(root,list);
    }

    // 中序遍历法
    private boolean inOrder(TreeNode root, LinkedList<Integer> list) {
        if(root.left != null) {
            if (!inOrder(root.left,list)) {
                return false;
            }
        }
        if (list.size() != 0 && root.val <= list.getLast()) {
            return false;
        }
        list.add(root.val);
        if (root.right != null) {
            if(!inOrder(root.right,list)) {
                return false;
            }
        }
        return true;
    }


      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}
