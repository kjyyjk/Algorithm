package 백준.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9252_LCS2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] d = new int[s1.length() + 1][s2.length() + 1];

        int i, j;
        for (i = 1; i < s1.length() + 1; i++) {
            for (j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    d[i][j] = d[i - 1][j - 1] + 1;
                } else {
                    d[i][j] = Math.max(d[i][j - 1], d[i - 1][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        if (d[s1.length()][s2.length()] == 0) {
            System.out.println(sb.append(0));
            return;
        }

        i = s1.length();
        j = s2.length();
        while (sb.length() != d[s1.length()][s2.length()]) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (d[i][j - 1] > d[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        System.out.println(new StringBuilder().append(d[s1.length()][s2.length()]));
        System.out.println(sb.reverse());
    }
}
