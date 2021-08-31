package days3;

import domain.ListNode;

/**
 * @author Yec
 * @date 2021-08-25
 * 合并两个升序序链表
 */
public class Day021 {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);

		ListNode prev = head;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}
		prev.next = l1 == null ? l2 : l1;
		return head.next;
	}

	public static void main(String[] args) {
		ListNode linkedList = ListNode.getLinkedList(new int[]{1, 2, 4});
		ListNode linkedList1 = ListNode.getLinkedList(new int[]{1, 3, 4});
		ListNode listNode = mergeTwoLists(linkedList, linkedList1);
		ListNode.printList(listNode);
	}
}
