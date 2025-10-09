public class Code03 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            carry = sum / 10;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static ListNode CreateNode(int number) {
        ListNode head = new ListNode(9);
        ListNode temp = head;
        number--;
        while (number != 0) {
            temp.next = new ListNode(9);
            temp = temp.next;
            number--;
        }
        return head;
    }

    public static void main(String[] args)
    {
        ListNode head1 = CreateNode(7);
        ListNode head2 = CreateNode(4);
        ListNode head = addTwoNumbers(head1, head2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }

}
