package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3474_교수가된현우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        long n;
        long ret2, ret5, ret;
        for (int i=0; i<t; i++) {
            n = Long.parseLong(br.readLine());
            ret2 = 0;
            ret5 = 0;

            for (int j=2; j<=n; j*=2) {
                ret2 += n/j;
            }

            for (int j=5; j<=n; j*=5) {
                ret5 += n/j;
            }

            ret = Math.min(ret2, ret5);
            sb.append(ret).append('\n');
        }

        System.out.println(sb);
    }
}
