/*

Reference Video - https://youtu.be/u4FWXfgS8jw


Sample Input 1:
intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3

Sample Output 1:
Intersected at '8'

Explanation:
The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. 
There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.


Sample Input 2:
intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2

Sample Output 2:
No intersection

Explanation:
From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two 
lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
The two lists do not intersect, so return null.

*/

class Solution {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // return getIntersectionNodeBruteForce(headA, headB);
    // return getIntersectionNodeHashSet(headA, headB);
    return getIntersectionNodeOptimal(headA, headB);
  }

  // Time Complexity: O(M*N)
  // Space Complexity: O(1)
  public ListNode getIntersectionNodeBruteForce(ListNode head1, ListNode head2) {
    if (head1 == null || head2 == null) {
      return null;
    }

    ListNode _head2 = head2;

    while (head1 != null) {
      while (head2 != null) {
        if (head1 == head2) {
          // intersection node found
          return head2;
        }

        head2 = head2.next;
      }

      head2 = _head2; // reset head2
      head1 = head1.next;
    }

    return null;
  }

  // Time Complexity: O(M+N)
  // Space Complexity: O(N)
  public ListNode getIntersectionNodeHashSet(ListNode head1, ListNode head2) {
    if (head1 == null || head2 == null) {
      return null;
    }

    HashSet<ListNode> set = new HashSet<>();

    while (head1 != null) {
      set.add(head1);
      head1 = head1.next;
    }

    while (head2 != null) {
      if (set.contains(head2)) {
        // intersection node found
        return head2;
      }

      head2 = head2.next;
    }

    return null;
  }

  // Time Complexity: O(2*M)
  // Space Complexity: O(1)
  // Important: refer video for explanation & calculating complexity
  public ListNode getIntersectionNodeOptimal(ListNode head1, ListNode head2) {
    ListNode _head1 = head1;
    ListNode _head2 = head2;

    while (head1 != head2) {
      // head1 = head1 != null ? head1.next : _head2;
      // head2 = head2 != null ? head2.next : _head1;

      if (head1 != null) {
        head1 = head1.next;
      } else {
        head1 = _head2;
      }

      if (head2 != null) {
        head2 = head2.next;
      } else {
        head2 = _head1;
      }
    }

    return head1;
  }

}
