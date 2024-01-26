package 백준.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1300_K번째수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, k, s, e, cnt, m, i;

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        s = 1;
        e = k;

        while(s<e+1) {
            m = (s+e)/2;
            cnt = 0;

            for(i=1; i<n+1; i++) {
                cnt += Math.min((m/i), n);
            }

            if(cnt < k) {
                s = m+1;
            } else {
                e = m-1;
            }
        }

        System.out.println(new StringBuilder().append(s));
    }
}
