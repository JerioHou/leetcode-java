import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
  给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 
  请你将两个数相加，并以相同形式返回一个表示和的链表。
 
  你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 
 
  输入：l1 = [2,4,3], l2 = [5,6,4]
  输出：[7,0,8]
  解释：342 + 465 = 807.
 
  
  来源：力扣（LeetCode）
  链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.insert(new ListNode(4));
        l1.insert(new ListNode(3));

        ListNode l2 = new ListNode(5);
        l2.insert(new ListNode(6));
        l2.insert(new ListNode(4));
        System.out.println(addTwoNumbers(l1,l2));

    }



    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode curr = null;
        while (l1 != null || l2 != null) {
            if (curr == null) {
                curr = result;
            } else {
                if (curr.next == null) {
                    curr.next = new ListNode(0);
                }
                curr = curr.next;
            }
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            if (val1 + val2 + curr.val> 9) {
                curr.next = new ListNode(1);
            }
            curr.val = (val1 + val2 + curr.val) % 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return result;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      public void insert(ListNode data) {
          ListNode tmp = next;
          ListNode pre = this;
          while (tmp != null) {
              pre = tmp;
              tmp  = tmp.next;
          }
          pre.next = data;
      }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(val).append(",");
            ListNode p = next;
            while (p != null) {
                builder.append(p.val).append(",");
                p = p.next;
            }
            return builder.toString();
        }
    }
}


