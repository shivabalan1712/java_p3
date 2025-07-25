class Addtwonum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy node to simplify appending
        ListNode curr = dummyHead;
        int carry = 0;

        // Traverse both lists
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0; // value from l1 or 0
            int y = (l2 != null) ? l2.val : 0; // value from l2 or 0

            int sum = x + y + carry;
            carry = sum / 10; // calculate carry for next iteration
            curr.next = new ListNode(sum % 10); // append digit to result list
            curr = curr.next;

            // move to next nodes
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next; // return the actual result list
    }
}

