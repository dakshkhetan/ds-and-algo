/*

Sample Input:
list1 = [1,2,4], list2 = [1,3,4]

Sample Output:
[1,1,2,3,4,4]

*/

class Solution {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    return mergeTwoListsIterative(list1, list2); // optimal space
    // return mergeTwoListsRecursive(list1, list2);
  }

  // Time Complexity: O(N+M)
  // Space Complexity: O(1)
  public ListNode mergeTwoListsIterative(ListNode head1, ListNode head2) {
    if (head1 == null) {
      return head2;
    }

    if (head2 == null) {
      return head1;
    }

    ListNode newHead = new ListNode(0); // assigning its value as 0 (to compare)
    ListNode current = newHead;

    while (head1 != null && head2 != null) {
      if (head1.val < head2.val) {
        current.next = head1;
        head1 = head1.next;
      } else {
        current.next = head2;
        head2 = head2.next;
      }
      current = current.next;
    }

    current.next = head1 == null ? head2 : head1;

    // if (head1 != null) {
    // current.next = head1;
    // } else if (head2 != null) {
    // current.next = head2;
    // }

    return newHead.next; // skipping the node with value 0 (defined above)
  }

  // Time Complexity: O(N+M)
  // Space Complexity: O(N+M)
  public ListNode mergeTwoListsRecursive(ListNode head1, ListNode head2) {
    if (head1 == null) {
      return head2;
    }

    if (head2 == null) {
      return head1;
    }

    if (head1.val < head2.val) {
      head1.next = mergeTwoListsRecursive(head1.next, head2);
      return head1;
    } else {
      head2.next = mergeTwoListsRecursive(head1, head2.next);
      return head2;
    }
  }

}
