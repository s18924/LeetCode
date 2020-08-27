package P_002_Add_Two_Numbers;

public class Solution {
    public static void main(String[] args) {

        printListNode(createListNode("5"));
        printListNode(createListNode("5"));

        ListNode result = new Solution().addTwoNumbers(createListNode("81"), createListNode("0"));
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

            if (l1 == null | l2 == null) {
                if (passToNext == 1)
                    currentNode.next = new ListNode(1);
                break;
            }

            currentNode.next = new ListNode();
            currentNode = currentNode.next;

        }

        ListNode leftover = l1==null?l2:l1;
        while (leftover!=null){

            currentNode = currentNode.next;
            System.out.println(leftover);
            System.out.println(currentNode);
                currentNode.val+=leftover.val;

                leftover=leftover.next;
        }



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

      /*  for ( String s : new StringBuilder(value).reverse().toString().split("") ){
            //System.out.println("v");
            printListNode(result);

        }*/

        currentNode = null;

        return result;
    }
}
