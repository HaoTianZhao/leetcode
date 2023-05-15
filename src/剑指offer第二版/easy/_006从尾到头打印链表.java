package 剑指offer第二版.easy;

import java.util.ArrayList;
import java.util.LinkedList;

/*
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：
输入：head = [1,3,2]
输出：[2,3,1]

限制：
0 <= 链表长度 <= 10000

 */
public class _006从尾到头打印链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//    public int[] reversePrint(ListNode head) {
//        if (head == null) {
//            return new int[]{};
//        }
//
//        ArrayList<Integer> list = new ArrayList<>();
//
//        while (head.next != null) {
//            list.add(head.val);
//            head = head.next;
//        }
//        list.add(head.val);
//
//        int[] result = new int[list.size()];
//        for (int i = list.size() -1, j = 0; i >= 0; i--, j++) {
//            result[j] = list.get(i);
//        }
//        return result;
//    }

    int count = 0;

    public int[] reversePrint(ListNode head) {
        return next(head);
    }

    int[] next(ListNode head) {
        if (head == null) {
            return new int[count];
        }
        count++;
        int[] result = next(head.next);
        result[result.length - count] = head.val;
        count--;
        return result;
    }
}

