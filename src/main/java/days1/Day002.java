package days1;

import domain.ListNode;

/**
 * @author Yec
 * @date 2021-01-19
 * 将两个链表对应节点相加，逆序进位
 */
public class Day002 {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode root = new ListNode(0);
		ListNode cursor = root;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			int l1Val = l1 != null ? l1.val : 0;
			int l2Val = l2 != null ? l2.val : 0;
			int sumVal = l1Val + l2Val + carry;
			carry = sumVal / 10;

			ListNode sumNode = new ListNode(sumVal % 10);
			cursor.next = sumNode;
			cursor = sumNode;

			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}
		return root.next;
	}

	public static void main(String[] args) {
		ListNode listNode1 = addTwoNumbers(ListNode.getLinkedList(new int[]{3, 6, 5}), ListNode.getLinkedList(new int[]{4, 5, 1}));
		ListNode.printList(listNode1);
	}
}
