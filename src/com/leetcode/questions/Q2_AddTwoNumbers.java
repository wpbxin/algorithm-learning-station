package com.leetcode.questions;

/**
 * <p>
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * <p>
 * Example Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation:
 * 342 + 465 = 807.
 * 
 * @author WPB
 *
 */
public class Q2_AddTwoNumbers {

	/**
	 * 迭代解法
	 * 
	 * @param ListNode
	 *            l1
	 * @param ListNode
	 *            l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (null == l1 && null == l2) {
			return new ListNode(0);
		}
		// 保存链表头，便于创建结点和最后返回结果
		ListNode headNode = new ListNode(0);
		ListNode sumNode = headNode;
		// 和以及进位
		int sum = 0;
		int carry = 0;
		while (null != l1 && null != l2) {
			sum = l1.val + l2.val + carry;
			sumNode.next = new ListNode(sum % 10);
			carry = sum / 10;
			sumNode = sumNode.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (null != l1) {
			sum = l1.val + carry;
			sumNode.next = new ListNode(sum % 10);
			carry = sum / 10;
			sumNode = sumNode.next;
			l1 = l1.next;
		}
		while (null != l2) {
			sum = l2.val + carry;
			sumNode.next = new ListNode(sum % 10);
			carry = sum / 10;
			sumNode = sumNode.next;
			l2 = l2.next;
		}
		if (carry > 0) {
			sumNode.next = new ListNode(carry);
			sumNode = sumNode.next;
		}
		return headNode.next;
	}
}
