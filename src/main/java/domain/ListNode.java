package domain;

/**
 * @author Yec
 * @date 2021-08-25
 */
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public static ListNode getLinkedList(int[] arr) {
		ListNode listNode = new ListNode(arr[0]);
		ListNode temp = listNode;
		for (int i = 1; i < arr.length; i++) {
			temp.next = new ListNode(arr[i]);
			temp = temp.next;
		}
		return listNode;
	}

	public static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
}
