import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    for (int i = 0; i < t; i++) {
      int n = s.nextInt();
      boolean flag = false;
      for (int j = 2; j <= Math.sqrt(n); j++) {
        if (n % j == 0) {
          flag = true;
          break;
        }
      }
      if (flag) {
        System.out.println("not prime");
      } else {
        System.out.println("prime");
      }
    }
  }
}
