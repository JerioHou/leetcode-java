/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKSortedLists {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
//        mergeTwoNode(node1,node2);
        ListNode node = mergeKLists(new ListNode[]{null,node1,null, node2});
        System.out.println(node);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }

    private static ListNode merge(ListNode[] lists,int left,int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int middle = (right - left) / 2 + left;
        return mergeTwoNode(merge(lists,left,middle),merge(lists,middle + 1,right));
    }

    public static ListNode mergeTwoNode(ListNode a , ListNode b) {
        ListNode head = new ListNode();
        ListNode ptr1 = a;
        ListNode ptr2 = b;
        ListNode tail = head;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val < ptr2.val) {
                tail.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                tail.next = ptr2;
                ptr2 = ptr2.next;
            }
            tail = tail.next;
        }
        if (ptr1 == null) {
            tail.next = ptr2;
        } else {
            tail.next = ptr1;
        }
        return head.next;
    }









    public static class ListNode{
        int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }

}
