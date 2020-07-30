package leetcode.y2020m07;

import java.math.BigDecimal;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        long flag = 1;
        long sum1 = 0;
        long sum2 = 0;
        while (l1 != null) {
            sum1 += l1.val * flag;
            flag *= 10;
            l1 = l1.next;
        }
        flag = 1;
        while (l2 != null) {
            sum2 += l2.val * flag;
            flag *= 10;
            l2 = l2.next;
        }
        long sum = sum1 + sum2;
        System.out.println(sum);
        ListNode result = null;
        ListNode node = null;
        if (sum == 0) {
            return new ListNode(0);
        }
        while (sum != 0) {
            int i = (int) (sum % 10);
            sum = sum / 10;
            if (result == null) {
                result = new ListNode(i);
                node = result;
            } else {
                node.next = new ListNode(i);
                node = node.next;
            }
        }
        return result;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        //进位
        int step = 0;
        //指针
        ListNode node = null;
        while (l1 != null || l2 != null || step != 0) {
            int num = 0;
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }
            num = num + step;
            step = 0;
            if (num >= 10) {
                step = 1;
                num %= 10;
            }
            if (result == null) {
                result = new ListNode(num);
                node = result;
            } else {
                node.next = new ListNode(num);
                node = node.next;
            }
        }
        return result;
    }

    ListNode toListNode(int[] num) {
        ListNode result = null;
        ListNode node = null;
        for (int i : num) {
            if (result == null) {
                result = new ListNode(i);
                node = result;
            } else {
                node.next = new ListNode(i);
                node = node.next;
            }
        }
        return result;
    }

    void printListNode(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    //    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    //    输出：7 -> 0 -> 8
    //    原因：342 + 465 = 807
    public static void main(String[] args) {
        AddTwoNumbers test = new AddTwoNumbers();
        ListNode l1 = test.toListNode(new int[]{9});
        ListNode l2 = test.toListNode(new int[]{1, 9, 9, 9});
        ListNode listNode = test.addTwoNumbers(l1, l2);
        test.printListNode(listNode);
    }
}

