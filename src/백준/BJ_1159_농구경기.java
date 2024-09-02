package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1159_농구경기 {
    public static void main(String[] args) throws IOException {

        int[] count = new int[26];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            String name = br.readLine();
            count[name.charAt(0)-'a']++;
        }

        StringBuilder result = new StringBuilder();
        for (int i=0; i<26; i++) {
            if (count[i] > 4) {
                result.append((char) (i + 'a'));
            }
        }

        if (result.length() == 0) {
            result.append("PREDAJA");
        }

        System.out.println(result);
    }
}
