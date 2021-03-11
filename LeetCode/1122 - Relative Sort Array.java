/*

Sample Input
[2,3,1,3,2,4,6,7,9,2,19]
[2,1,4,3,9,6]

Sample Output
[2,2,2,1,4,3,3,9,6,7,19]

*/

class Solution {

  public int[] relativeSortArray(int[] arr1, int[] arr2) {

    HashMap<Integer, Integer> map = new HashMap<>(); // element vs frequency
    ArrayList<Integer> list = new ArrayList<>();

    for (int element : arr2) {
      map.put(element, 0);
    }

    for (int element : arr1) {
      if (map.containsKey(element)) {
        map.put(element, map.get(element) + 1);
      } else {
        list.add(element);
      }
    }

    Collections.sort(list);

    int k = 0;

    for (int element : arr2) {
      for (int i = 0; i < map.get(element); i++) {
        arr1[k++] = element;
      }
    }

    for (int element : list) {
      arr1[k++] = element;
    }

    return arr1;

  }

}
