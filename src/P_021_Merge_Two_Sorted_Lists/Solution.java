package P_021_Merge_Two_Sorted_Lists;

class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode resultListNode = new ListNode();
		ListNode currentPosition = resultListNode;
		while (l1 != null || l2!=null){
			if(l2==null){
				while (l1!=null) {
					currentPosition.next = l1;
					currentPosition = currentPosition.next;

					l1=l1.next;
				}
				continue;
			}

			if(l1==null){
				while (l2!=null) {
					currentPosition.next = l2;
					currentPosition = currentPosition.next;
					l2=l2.next;
				}
				continue;
			}

			if(l1.val > l2.val){
				currentPosition.next = l2;
				currentPosition = currentPosition.next;
				l2=l2.next;
			}else {
				currentPosition.next = l1;
				currentPosition = currentPosition.next;
				l1=l1.next;
			}
		}
		return resultListNode.next;
	}

	public static ListNode createListNode(int... table){
		if(table.length==0)
			return null;

		ListNode resultListNode = new ListNode(table[0]);
		ListNode pointerAtTheBeggining = resultListNode;
		for (int i = 1; i < table.length; i++) {
			resultListNode.next = new ListNode(table[i]);
			resultListNode = resultListNode.next;
		}
		return pointerAtTheBeggining;

	}

	public static void printListNode(ListNode listNode) {

		if(listNode==null) {
return;
		}

		while ((listNode.next != null)) {
				System.out.print(listNode.val + " ");
				listNode = listNode.next;
			} ;
			System.out.println(listNode.val + " ");


	}

	public static void main(String[] args) {


		ListNode l12 = createListNode(-10,-6,-6,-6,-3,5);


		ListNode l21 = createListNode(1,2,3,4);

		printListNode(l12);
		printListNode(l21);

		ListNode resultListNode = new Solution().mergeTwoLists(l12, l21);


		printListNode(resultListNode);
	}


}


class ListNode {
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