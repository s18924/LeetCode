package P_002_Add_Two_Numbers;

public class Solution { //TODO Can be improved
    public static void main(String[] args) {

        printListNode(createListNode("81"));
        printListNode(createListNode("0"));

        ListNode result = new Solution().addTwoNumbers(createListNode("89"), createListNode("1"));
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int passToNext = 0;

        ListNode result = new ListNode();
        ListNode currentNode = result;

        while (true) {

            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + passToNext;

            if (sum >= 10) {
                currentNode.val = sum - 10;
                passToNext = 1;
            } else {
                currentNode.val = sum;
                passToNext = 0;
            }

            l1 = l1.next;
            l2 = l2.next;

            if (l1 == null && l2 == null) {
                if (passToNext == 1)
                    currentNode.next = new ListNode(1);
                return result;
            }

            if (l1 == null | l2 == null)
                break;


            currentNode.next = new ListNode();
            currentNode = currentNode.next;

        }

        ListNode leftover = l1 == null ? l2 : l1;
        while (leftover != null) {
            currentNode.next = new ListNode();
            currentNode = currentNode.next;

            int sum = leftover.val + passToNext;
            if (sum >= 10) {
                passToNext = 1;
                sum -= 10;
            } else passToNext = 0;

            currentNode.val += sum;
            leftover = leftover.next;
        }

        if (passToNext == 1)
            currentNode.next = new ListNode(1);

        return result;
    }

    public static void printListNode(ListNode listNode) {

        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
        System.out.println();

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static ListNode createListNode(String value) {
        ListNode result = new ListNode();
        ListNode currentNode = result;

        String[] numberToCode = new StringBuilder(value).reverse().toString().split("");

        for (int i = 0; i < numberToCode.length - 1; i++) {
            currentNode.val = Integer.parseInt(numberToCode[i]);
            currentNode.next = new ListNode();
            currentNode = currentNode.next;
        }
        currentNode.val = Integer.parseInt(numberToCode[numberToCode.length - 1]);

        return result;
    }
}

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order
and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.



Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Two Numbers.
Memory Usage: 39.9 MB, less than 46.85% of Java online submissions for Add Two Numbers.
 */