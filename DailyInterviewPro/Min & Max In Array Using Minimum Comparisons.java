import java.util.Scanner;

public class Main {

  static class Pair {
    int min;
    int max;
  }

  public static Pair getMinMaxBetter(int[] arr) {
    Pair pair = new Pair();
    int n = arr.length;
    int i;

    // if there is only one element then,
    // return it as min and max both
    if (n == 1) {
      pair.max = arr[0];
      pair.min = arr[0];
      return pair;
    }

    // if there is more than one elements then first,
    // initialize min and max from first two elements,
    // then compare other elements (see the 'for' loop below)

    if (arr[0] > arr[1]) {
      pair.max = arr[0];
      pair.min = arr[1];
    } else {
      pair.max = arr[1];
      pair.min = arr[0];
    }

    for (i = 2; i < n; i++) {
      if (arr[i] > pair.max) {
        pair.max = arr[i];
      } else if (arr[i] < pair.min) {
        pair.min = arr[i];
      }
    }

    return pair;
  }

  public static Pair getMinMaxBest(int[] arr) {
    Pair pair = new Pair();
    int n = arr.length;
    int i;

    // if array has even number of elements then,
    // initialize min & max from the first two elements

    if (n % 2 == 0) {
      if (arr[0] > arr[1]) {
        pair.max = arr[0];
        pair.min = arr[1];
      } else {
        pair.min = arr[0];
        pair.max = arr[1];
      }

      i = 2; // set the starting index for loop

    } else {
      // if array has odd number of elements then,
      // initialize the first element as as min & max

      pair.min = arr[0];
      pair.max = arr[0];

      i = 1; // set the starting index for loop
    }

    // in the loop below, pick 2 elements (at index i & i+1)
    // and, compare them with max & min so far as shown

    while (i < n - 1) {
      if (arr[i] > arr[i + 1]) {
        if (arr[i] > pair.max) {
          pair.max = arr[i];
        }
        if (arr[i + 1] < pair.min) {
          pair.min = arr[i + 1];
        }
      } else {
        if (arr[i + 1] > pair.max) {
          pair.max = arr[i + 1];
        }
        if (arr[i] < pair.min) {
          pair.min = arr[i];
        }
      }

      // increment the index by 2
      // as two elements are processed
      i += 2;
    }

    return pair;
  }

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);

    int n = s.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }

    /* Naive approach */
    // Total number of comparisons: 2*(n-1)

    /* Better than Naive approach */
    // Pair result = getMinMaxBetter(arr);

    // Total number of comparisons:
    // Worst case (desc order): 1 + 2*(n-2)
    // Best case (asc order): 1 + n–2

    /* Better than above approach (maybe best) */
    Pair result = getMinMaxBest(arr);

    // Total number of comparisons:
    // If n is odd: 3*(n-1)/2
    // If n is even: 1 + 3*(n-2)/2

    System.out.println("Minimum = " + result.min);
    System.out.println("Maximum = " + result.max);
  }

}
