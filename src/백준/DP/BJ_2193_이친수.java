package 백준.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2193_이친수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] d = new long[n+1][2]; //d[i][0] : i번째의 0의 개수, d[i][1] : i번째의 1의 개수
        d[1][0] = 0;
        d[1][1] = 1;

        for (int i=2; i<n+1; i++) {
            d[i][0] = d[i-1][0] + d[i-1][1]; //이전 0 개수 + 이전 1 개수
            d[i][1] = d[i-1][0]; // 이전 0 개수
        }

        long result = d[n][0] + d[n][1];
        System.out.println(new StringBuilder().append(result));
    }
}

