package days20;

import domain.ListNode;

/**
 * @author Yec
 * @date 2021-08-26
 * 反转链表
 */
public class Day206 {
	public static ListNode reverseList(ListNode head) {
		ListNode newNode = null;
		ListNode temp = head;
		while (temp != null) {
			ListNode next = temp.next;
			temp.next = newNode;
			newNode = temp;
			temp = next;
		}
		return newNode;
	}

	public static void main(String[] args) {
		ListNode linkedList = ListNode.getLinkedList(new int[]{1, 2, 3, 4, 5, 6});
		ListNode.printList(reverseList(linkedList));
	}
}
