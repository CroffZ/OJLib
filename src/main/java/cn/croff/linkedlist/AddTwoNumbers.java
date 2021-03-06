package cn.croff.linkedlist;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // carry保存进位，result保存结果链表的头，current保存处理结果链表的当前位置
        int carry = 0;
        ListNode result = null, current = null;
        // 只要l1和l2有一个不是null，或者carry为1时就继续处理
        while (l1 != null || l2 != null || carry > 0) {
            // 计算本次迭代的相加结果和进位
            int num1 = 0, num2 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            int num = (num1 + num2 + carry) % 10;
            carry = (num1 + num2 + carry) / 10;
            // 更新current指向的位置
            if (current == null) {
                result = new ListNode(num);
                current = result;
            } else {
                current.next = new ListNode(num);
                current = current.next;
            }
        }
        return result;
    }
}
