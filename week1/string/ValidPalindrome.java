import java.util.*;

class ValidPalindrome {
  public boolean isPalindrome(String s) {
        String temp = s.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase().replaceAll(" ","");
        if (temp.length() == 1) return true;
        for(int i = 0; i< temp.length() / 2 ; i++) {
            if (temp.charAt(i) != temp.charAt(temp.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
