package LeetCode.QuestionBase;


import DataStructure.ListNodeDemo;

import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class The2Question {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
        //输入节点
        public void print() {
            System.out.print(this.val);
            if (this.next != null){
                System.out.print("-->");
                this.next.print();
            }
        }
        public void add(int newval) {
            ListNode newnode = new ListNode(newval);
            if (this.next == null) {
                this.next = newnode;
            } else {
                this.next.add(newval);
            }
        }
    }

    public static ListNode countListNode(ListNode l1, ListNode l2) {
        //新建一个链表,存放结果
        ListNode pre = new ListNode(0);
        //存储的链表
        ListNode cur = pre;
        //进位数
        int carry = 0;
        while ((l1 != null) || (l2 != null)) {
            //获得l1节点值
            int x = l1 == null ? 0 : l1.val;
            //获得l2节点值
            int y = l2 == null ? 0 : l2.val;
            //求和
            int sum = x + y + carry;
            //获得进位数
            carry = sum / 10;
            //获得余数,为当前位数的实际值
            sum = sum % 10;
            //添加数到暂存的节点
            cur.next = new ListNode(sum);
            //到下一个节点
            cur = cur.next;
            //获取l1下一个节点
            if (l1 != null)
                l1 = l1.next;
            //获取l2下一个节点
            if (l2 != null)
                l2 = l2.next;
        }
        //如果最后一个节点的值的和需要进位则添加一个节点
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        //返回链表
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.add(4);
        listNode1.add(5);
        ListNode listNode2 = new ListNode(2);
        listNode2.add(4);
        listNode2.add(5);
        ListNode node = countListNode(listNode1, listNode2);
        node.print();
    }


}
