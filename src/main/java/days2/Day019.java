package days2;

import domain.ListNode;

/**
 * @author Yec
 * @date 2021-08-25
 * 删除链表倒数第N个节点
 */
public class Day019 {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode blank = new ListNode(0, head);
		ListNode delete = blank;
		ListNode temp = head;
		for (int i = 0; i < n; i++) {
			temp = temp.next;
		}
		while (temp != null) {
			delete = delete.next;
			temp = temp.next;
		}
		delete.next = delete.next.next;
		return blank.next;
	}

	public static void main(String[] args) {
		ListNode listNode = removeNthFromEnd(ListNode.getLinkedList(new int[]{1, 2, 3, 4, 5}), 3);
		while (listNode != null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}
}
