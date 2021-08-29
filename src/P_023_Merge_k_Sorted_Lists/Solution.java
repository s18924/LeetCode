package P_023_Merge_k_Sorted_Lists;


public class Solution {

	public ListNode mergeKLists(ListNode[] lists) {
		int lowestValue = Integer.MAX_VALUE;
		ListNode resultListNode = new ListNode();
		ListNode resultPointer = resultListNode;
		boolean areThereMoreListNodesToJoin = true;

		while (areThereMoreListNodesToJoin) {

			areThereMoreListNodesToJoin = false;

			for (ListNode list : lists) {
				if (list != null) {
					areThereMoreListNodesToJoin = true;
					if (list.val < lowestValue)
						lowestValue = list.val;
				}
			}

			for (int i = 0; i < lists.length; i++) {
				if (lists[i] != null) {
					if (lists[i].val == lowestValue) {
						resultListNode.next = lists[i];
						resultListNode = resultListNode.next;
						lists[i] = lists[i].next;
					}
				}
			}

			lowestValue = Integer.MAX_VALUE;

/*			for (ListNode list : lists) {
				if (list != null) {
					if (list.val == lowestValue) {
						resultListNode.next = list;
						resultListNode = resultListNode.next;
						list = list.next; //??????????????
					}
				}
			}*/


		}

		return resultPointer.next;

	}

	public static void main(String[] args) {
		ListNode resultListNode = new Solution().mergeKLists(
				new ListNode[]{
				createListNode(1,4,5),
				createListNode(1,3,4),
				createListNode(2,6)
						}
		);
		printListNode(resultListNode);
	}

	public static ListNode createListNode(int... table) {
		if (table.length == 0)
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

		if (listNode == null) {
			return;
		}

		while ((listNode.next != null)) {
			System.out.print(listNode.val + " ");
			listNode = listNode.next;
		}
		System.out.println(listNode.val + " ");
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