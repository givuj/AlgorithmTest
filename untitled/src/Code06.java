public class Code06 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);;
        newHead.next = head;
        ListNode cur = head;
        ListNode prev = newHead;
        while(cur != null && n!=0)
        {
            cur = cur.next;
            n--;
        }
        while(cur != null)
        {
            prev = prev.next;
            cur = cur.next;
        }
        prev.next = prev.next.next;
        return  head;
    }
}

