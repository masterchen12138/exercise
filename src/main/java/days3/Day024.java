package days3;

import domain.ListNode;

/**
 * @author Yec
 * @date 2021-08-26
 * 链表节点两两交换
 */
public class Day024 {
	public static ListNode swapPairs(ListNode head) {
		ListNode newNode = new ListNode(-1, head);
		ListNode temp = newNode;
		while (temp.next != null && temp.next.next != null) {
			ListNode node1 = temp.next;
			ListNode node2 = temp.next.next;
			temp.next = node2;
			node1.next = node2.next;
			node2.next = node1;
			temp = node1;
		}
		return newNode.next;
	}

	public static void main(String[] args) {
		ListNode linkedList = ListNode.getLinkedList(new int[]{1, 2, 3, 4, 5, 6});
		ListNode.printList(swapPairs(linkedList));
	}
}
