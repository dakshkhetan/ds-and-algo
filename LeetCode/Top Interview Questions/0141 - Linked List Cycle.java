/*

Sample Input 1:
head = [3,2,0,-4], pos = 1

Sample Output 1:
true

Explanation:
There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).


Sample Input 2:
head = [1,2,4], pos = -1

Sample Output 2:
false

Explanation:
There is no cycle in the linked list.


Note: Refer the problem statement on LeetCode for better understanding using given diagrams.

*/

class Solution {

  public boolean hasCycle(ListNode head) {
    // return hasCycleHashSet(head);
    return hasCycleTwoPointer(head);
  }

  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public boolean hasCycleHashSet(ListNode head) {
    if (head == null) {
      return false;
    }

    Set<ListNode> set = new HashSet<>();

    while (head != null) {
      if (set.contains(head)) {
        return true;
      }

      set.add(head);
      head = head.next;
    }

    return false;
  }

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  public boolean hasCycleTwoPointer(ListNode head) {
    // Using Floyd's Cycle Detection Algorithm:

    if (head == null) {
      return false;
    }

    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        return true;
      }
    }

    return false;

    // Note: This method is also used to find the middle node of
    // a linked list without needing to calculate its length
  }

}
