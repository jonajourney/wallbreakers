import java.util.*;

class DetectCapitalUse {
  public boolean detectCapitalUse(String word) {
        return (allCaps(word) || allLower(word) || startCaps(word));
    }

    public boolean allCaps(String s) {
        int len = s.length() - 1;
        while (len >= 0) {
            if (!Character.isUpperCase(s.charAt(len))) return false;
            len --;
        }

        return true;
    }

    public boolean allLower(String s) {
        int len = s.length() - 1;
        while (len >=0) {
            if (!Character.isLowerCase(s.charAt(len))) return false;
            len --;
        }

        return true;
    }

    public boolean startCaps(String s) {
        if (!Character.isUpperCase(s.charAt(0))) return false;
        return (allLower(s.substring(1)));
    }
}
