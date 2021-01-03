/*

Sample Input
6
22 28
1 8
25 27
14 19
27 30
5 12

Sample Output
1 12
14 19
22 30

*/

import java.util.*;

class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}

public class Main {

  // O(n*logn)
  public static ArrayList<Interval> mergeOverlappingIntervals(ArrayList<Interval> intervals) {
    // if there are less than 2 intervals, then there is nothing to merge
    if (intervals.size() < 2) {
      return intervals;
    }

    // sort the interval on the basis of their start-time
    Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

    ArrayList<Interval> output = new ArrayList<>();

    // take the first interval
    Interval temp = intervals.get(0);
    int start = temp.start;
    int end = temp.end;

    for (int i = 1; i < intervals.size(); i++) {
      temp = intervals.get(i);

      if (temp.start <= end) {
        end = Math.max(temp.end, end);
      } else {
        // add previous interval to output list
        Interval newInterval = new Interval(start, end);
        output.add(newInterval);

        // update start & end with temp
        start = temp.start;
        end = temp.end;
      }
    }

    // add last interval
    Interval newInterval = new Interval(start, end);
    output.add(newInterval);

    return output;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();

    ArrayList<Interval> intervals = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int start = s.nextInt();
      int end = s.nextInt();

      Interval interval = new Interval(start, end);
      intervals.add(interval);
    }

    ArrayList<Interval> output = mergeOverlappingIntervals(intervals);

    for (Interval interval : output) {
      System.out.println(interval.start + " " + interval.end);
    }
  }

}
