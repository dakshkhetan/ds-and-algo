/*

Sample Input 1:
5
01111
10000
10010
00000
01010

Sample Output 1:
3


Sample Input 2:
3
011
010
100

Sample Output 2:
none

*/

import java.util.*;

public class Main {

  public static int celebrityProblem(String[] arr) {
    int n = arr.length;
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < n; i++) {
      st.push(i);
    }

    while (st.size() > 1) {
      int person2 = st.pop();
      int person1 = st.pop();

      // check if person1 (row) knows person2 (column)
      char status = arr[person1].charAt(person2);

      if (status == '0') {
        // person2 is not a celebrity
        st.push(person1);
      } else if (status == '1') {
        // person1 is not a celebrity
        st.push(person2);
      }
    }

    // potential celebrity
    int person = st.peek(); // or st.pop()

    for (int i = 0; i < n; i++) {
      char statusRow = arr[person].charAt(i);
      if (statusRow == '1') {
        // the person knows somebody
        return -1;
      }

      char statusColumn = arr[i].charAt(person);
      if (i != person && statusColumn == '0') {
        // someone doesn't know the person
        return -1;
      }
    }

    return person;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    String arr[] = new String[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.next();
    }

    int result = celebrityProblem(arr);
    if (result != -1) {
      System.out.println(result);
    } else {
      System.out.println("none");
    }
  }

}
