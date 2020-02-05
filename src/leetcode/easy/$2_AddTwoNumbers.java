package leetcode.easy;

import java.math.BigInteger;

public class $2_AddTwoNumbers {

  public static void main(String[] args) {
    $2_Solution sol = new $2_Solution();

    // // 2 -> 4 -> 3
    // ListNode l1 = new ListNode(2);
    // ListNode l1b = new ListNode(4);
    // ListNode l1c = new ListNode(3);
    // l1b.next = l1c;
    // l1.next = l1b;
    //
    // // 5 -> 6 -> 4
    // ListNode l2 = new ListNode(5);
    // ListNode l2b = new ListNode(6);
    // ListNode l2c = new ListNode(4);
    // l2b.next = l2c;
    // l2.next = l2b;

    ListNode l1 = new ListNode(9);

    ListNode l2 = new ListNode(1);
    ListNode l21 = new ListNode(9);
    ListNode l22 = new ListNode(9);
    ListNode l23 = new ListNode(9);
    ListNode l24 = new ListNode(9);
    ListNode l25 = new ListNode(9);
    ListNode l26 = new ListNode(9);
    ListNode l27 = new ListNode(9);
    ListNode l28 = new ListNode(9);
    ListNode l29 = new ListNode(9);
    l28.next = l29;
    l27.next = l28;
    l26.next = l27;
    l25.next = l26;
    l24.next = l25;
    l23.next = l24;
    l22.next = l23;
    l21.next = l22;
    l2.next = l21;

    System.out.println(sol.addTwoNumbers(l1, l2));
  }

}


class $2_Solution {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode temp = new ListNode(0);
    ListNode curr = temp;

    int carry = 0;
    while (!(l1 == null && l2 == null)) {
      int i1 = 0;
      if (l1 != null) {
        i1 = l1.val;
      }

      int i2 = 0;
      if (l2 != null) {
        i2 = l2.val;
      }

      int sum = i1 + i2 + carry;
      if (sum >= 10) {
        sum = sum % 10;
        carry = 1;
      } else {
        carry = 0;
      }

      curr.next = new ListNode(sum);
      curr = curr.next;

      l1 = l1 != null ? l1.next : l1;
      l2 = l2 != null ? l2.next : l2;
    }

    if (carry != 0) {
      curr.next = new ListNode(carry);
    }

    return temp.next;
  }

}


class $2_BruteForceSolution {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    StringBuffer str1 = new StringBuffer();
    while (l1 != null) {
      str1.append(l1.val);
      l1 = l1.next;
    }

    StringBuffer str2 = new StringBuffer();
    while (l2 != null) {
      str2.append(l2.val);
      l2 = l2.next;
    }

    BigInteger i1 = new BigInteger(str1.reverse().toString());
    BigInteger i2 = new BigInteger(str2.reverse().toString());

    return strToListNode(new StringBuffer(i1.add(i2).toString()).reverse().toString());
  }

  private ListNode strToListNode(String str) {
    if (str.length() == 1) {
      return new ListNode(Integer.valueOf(str));
    } else {
      ListNode result = new ListNode(str.charAt(0) - '0');
      result.next = strToListNode(str.substring(1));
      return result;
    }
  }

}


class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }

  public String toString() {
    return "" + (next == null ? val : val + " -> " + next.toString());
  }

}
