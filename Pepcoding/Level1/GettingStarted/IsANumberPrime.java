import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();

    for (int i = 0; i < t; i++) {
      int n = s.nextInt();
      boolean isPrime = true;

      for (int j = 2; j <= Math.sqrt(n); j++) {
        if (n % j == 0) {
          isPrime = false;
          break;
        }
      }

      if (isPrime) {
        System.out.println("prime");
      } else {
        System.out.println("not prime");
      }
    }
  }
}
