import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 *
 */
public class RangeSumBST {


   static int count = 0;

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode root = new TreeNode(10);
        TreeNode l1 = new TreeNode(5);
        TreeNode r1 = new TreeNode(15);
        TreeNode l2 = new TreeNode(3);
        TreeNode r2 = new TreeNode(7);
        TreeNode r3 = new TreeNode(18);
        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l1.right = r2;
        r1.right = r3;
        traversal(root,list);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(traversal2(root,7,15));
    }

    /**
     * 官方解法
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    /**
     * 我的解法
     */
    public static int rangeSumBST2(TreeNode root, int low, int high) {
        //中序遍历
        return traversal2(root,low,high);
    }


    /**
     * 中序遍历
     */
    public static void traversal(TreeNode node, ArrayList<Integer> list) {
        if (node.left != null) {
            traversal(node.left,list);
        }
        list.add(node.val);
        if (node.right != null) {
            traversal(node.right,list);
        }
    }

    public static int traversal2(TreeNode root,int low, int high) {
        if (root.left != null) {
            count = traversal2(root.left,low,high);
        }
        if (root.val >= low && root.val <= high) {
            count += root.val;
        }
        if (root.right != null) {
            count = traversal2(root.right,low,high);
        }
        return count;
    }


     public static class TreeNode {
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

         @Override
         public String toString() {
             return "TreeNode{" +
                     "val=" + val +
                     '}';
         }
     }
}
