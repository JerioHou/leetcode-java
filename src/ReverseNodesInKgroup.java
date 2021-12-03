import java.util.ArrayList;
import java.util.List;

/**
 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 k 是一个正整数，它的值小于或等于链表的长度。
 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 进阶：
 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
  
 示例 1：
 输入：head = [1,2,3,4,5], k = 2
 输出：[2,1,4,3,5]

 示例 2：
 输入：head = [1,2,3,4,5], k = 3
 输出：[3,2,1,4,5]
 示例 3：

 输入：head = [1,2,3,4,5], k = 1
 输出：[1,2,3,4,5]

 示例 4：
 输入：head = [1], k = 1
 输出：[1]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseNodesInKgroup {
    // TODO: 2021/12/3 未完成
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        head.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;

        ListNode node3 = new ListNode(3);
        node2.next = node3;

        ListNode node4 = new ListNode(4);
        node3.next = node4;

        ListNode node5 = new ListNode(5);
        node4.next = node5;

        System.out.println(head);

        ListNode listNode = new ReverseNodesInKgroup().reverseKGroup(head, 2);
        System.out.println(listNode);
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode sential = new ListNode();
        sential.next = head;
        ListNode tail = sential;
        ListNode preTail = sential;
        ListNode nextHead;
        while (tail != null) {
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return sential.next;
                }
            }

            // 暂存尾节点的下一个节点
            nextHead = tail.next;
            ListNode[] reverse = reverse(head, tail);

            // 之前的尾节点 指向 新的头结点
            preTail.next = reverse[0];
            // 新的尾节点指向 后续的节点
            preTail = reverse[1];
            preTail.next = nextHead;
            tail = nextHead;
        }
        return sential.next;
    }

    private static ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode sentinelNode = new ListNode();
        ListNode ptr = head;
        while (ptr != tail) {
            ListNode tmp = ptr.next;
            ptr.next = sentinelNode.next;
            sentinelNode.next = ptr;
            ptr = tmp;
        }
        return new ListNode[]{sentinelNode.next,head};
    }


      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
