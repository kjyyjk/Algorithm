package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9996_한국이그리울땐서버에접속하지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String pattern = br.readLine();
        String prefix = pattern.substring(0,pattern.indexOf('*'));
        String suffix = pattern.substring(pattern.indexOf('*')+1);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            String file = br.readLine();
            if (file.startsWith(prefix)) {
                if (file.substring(prefix.length()).endsWith(suffix)) {
                    sb.append("DA\n");
                } else {
                    sb.append("NE\n");
                }
            } else {
                sb.append("NE\n");
            }
        }

        System.out.println(sb);
    }
}