public class ReverseLinkedList  {

    public ListNode reverseList(ListNode head) {

        ListNode sentinelNode = new ListNode();
        ListNode ptr = head;
        while (ptr != null) {
            ListNode tmp = ptr.next;
            ptr.next = sentinelNode.next;
            sentinelNode.next = ptr;
            ptr = tmp;
        }
        return sentinelNode.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
