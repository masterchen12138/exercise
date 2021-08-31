package days3;

import domain.ListNode;

/**
 * @author Yec
 * @date 2021-08-25
 * 合并多个升序链表
 */
public class Day023 {

	public static ListNode mergeKLists(ListNode[] lists) {
		return merge(lists, 0, lists.length - 1);
	}

	public static ListNode merge(ListNode[] lists, int l, int r) {
		if (l == r) {
			return lists[l];
		}
		if (l > r) {
			return null;
		}
		int mid = (l + r) >> 1;
		return Day021.mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
	}

	public static void main(String[] args) {
		ListNode[] listNodes = new ListNode[]{
				ListNode.getLinkedList(new int[]{1, 2, 4}),
				ListNode.getLinkedList(new int[]{1, 3, 4}),
				ListNode.getLinkedList(new int[]{2, 5, 8}),
				ListNode.getLinkedList(new int[]{3, 4, 7})
		};
		ListNode.printList(mergeKLists(listNodes));
	}
}
