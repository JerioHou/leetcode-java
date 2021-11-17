/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthFromEnd {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        int step = 0;
        // fast最后一定指向null 尾节点之后
        ListNode fast = head;
        // slow 指向要删除的节点的前一个
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            step++;
            if (step > n+1 ) {
                slow = slow.next;
            }

        }
        if (slow == head && step == n) {
            return head.next;
        }
        if (step > n ){
            slow.next = slow.next.next;
        }
        return head;
    }



    public  static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
