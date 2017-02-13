package MatchLetter;

/**
 * Created by lilei on 16/7/29.
 */
public class KMP {
    public void KMPMatcher(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int prefix[] = computePrefix(pattern);
        int q = 0;

        int count = 0;
        for (int i = 0; i < n; i++) {

            while (q > 0 && pattern.charAt(q) != text.charAt(i)) {
                q = prefix[q - 1];
            }

            if (pattern.charAt(q) == text.charAt(i))
                q++;

            if (q == m) {
                System.out.println("Pattern occurs with shift  " + ++count + "times");
                q = prefix[q - 1];
            }
        }

        if (count == 0) {
            System.out.println("There is no matcher!");
        }
    }

    private int[] computePrefix(String pattern) {
        int length = pattern.length();
        int[] prefix = new int[length];

        prefix[0] = 0;

        int k = 0;
        for (int i = 1; i < length; i++) {
            while (k > 0 && pattern.charAt(k) != pattern.charAt(i)) {
                k = prefix[k - 1];
            }
            if (pattern.charAt(k) == pattern.charAt(i))
                k++;
            prefix[i] = k;
        }

        return prefix;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        kmp.KMPMatcher("abcdsse", "abc");

    }

}
