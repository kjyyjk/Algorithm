package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10808_알파벳개수 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int['z' - 'a' + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for (int i=0; i<s.length(); i++) {
            arr[s.charAt(i)-97]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<arr.length; i++) {
            sb.append(arr[i]).append(' ');
        }

        System.out.println(sb);
    }
}
