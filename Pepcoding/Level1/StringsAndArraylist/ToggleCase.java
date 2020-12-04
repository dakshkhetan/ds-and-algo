import java.util.*;

class ToggleCase {

  public static String toggleCase(String str) {
    // formula :: upperCaseLetter - 'A' = lowerCaseLetter - 'a'
    // also, 'a' - 'A' = 97 - 65 = 32

    StringBuilder sb = new StringBuilder(str);

    for (int i = 0; i < sb.length(); i++) {
      char ch = sb.charAt(i);
      if (ch >= 'a' && ch <= 'z') {
        // char upperCase = (char) ('A' + ch - 'a');
        char upperCase = (char) (ch - 32);
        sb.setCharAt(i, upperCase);
      } else if (ch >= 'A' && ch <= 'Z') {
        // char lowerCase = (char) ('a' + ch - 'A');
        char lowerCase = (char) (ch + 32);
        sb.setCharAt(i, lowerCase);
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String str = s.next();
    System.out.println(toggleCase(str));
  }

}