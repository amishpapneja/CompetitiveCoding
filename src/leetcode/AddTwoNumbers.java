package leetcode;

import java.util.List;

/**
 * LeetCode Medium
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * https://leetcode.com/problems/add-two-numbers/submissions/
 */

public class AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println(18%10);
        System.out.println(18/10);
        ListNode ln =new ListNode();
        ln.val = 2;
        ln.next = new ListNode();
        ln.next.val =4;
        ln.next.next = new ListNode(9);
//        ln.next.next.next = new ListNode(9);

        System.out.println();

        ListNode ln2 =new ListNode();
        ln2.val = 5;
        ln2.next = new ListNode();
        ln2.next.val = 6;
        ln2.next.next = new ListNode(4);
        ln2.next.next.next = new ListNode(9);

        System.out.println();

        ListNode res = addTwoNumbers(ln, ln2);
        System.out.println();


    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        boolean carryBool = false;
        ListNode head = new ListNode();
        ListNode walker = head;

        while(l1!= null || l2!= null){
            ListNode node = null;
            int val1 = l1!=null ? l1.val:0;
            int val2 = l2!=null ? l2.val:0;

            int currentSum = val1 + val2;
            if(carryBool) currentSum +=carry;
            if(currentSum > 9){
                //carry yes case
                int mod = currentSum % 10;
                carry = currentSum / 10;
                carryBool = true;
                node = new ListNode(mod);
            }
            else{
                carryBool = false;
                node = new ListNode(currentSum);
            }
            walker.next = node;
            walker = walker.next;
            if(l1!=null)l1 = l1.next;
            if(l2!=null)l2 = l2.next;
        }

        if(carryBool){
            ListNode node =new ListNode(carry);
            walker.next =node;
            walker = walker.next;
        }

        return head.next;




    }
}
