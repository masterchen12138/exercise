package days3;

import days20.Day206;
import domain.ListNode;
import sun.util.resources.cldr.ne.CalendarData_ne_IN;

/**
 * @author Yec
 * @date 2021-08-26
 * K个一组反转链表
 */
public class Day025 {
	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(-1, head);
		ListNode pre = dummy;
		ListNode end = dummy;
		while (end.next != null) {
			for (int i = 0; i < k; i++) {
				end = end.next;
				if (end == null) {
					return dummy.next;
				}
			}
			ListNode start = pre.next;
			ListNode next = end.next;
			pre.next = reverseList(pre.next, k);
			start.next = next;
			pre = start;
			end = pre;
		}
		return dummy.next;
	}

	public static ListNode reverseList(ListNode head, int k) {
		ListNode newNode = null;
		ListNode temp = head;
		for (int i = 0; i < k; i++) {
			ListNode next = temp.next;
			temp.next = newNode;
			newNode = temp;
			temp = next;
		}
		return newNode;
	}

	public static void main(String[] args) {
		ListNode linkedList = ListNode.getLinkedList(new int[]{1, 2, 3, 4});
		ListNode.printList(reverseKGroup(linkedList, 3));
	}
}
