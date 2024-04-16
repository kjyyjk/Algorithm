package 백준.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10844_쉬운계단수 {

    static long M = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] d = new long[n+1][10];

        int i, j;
        for (i=1; i<10; i++) {
            d[1][i] = 1;
        }

        for (i=2; i<n+1; i++) {
            d[i][0] = d[i-1][1];
            d[i][9] = d[i-1][8];

            for (j=1; j<9; j++) {
                d[i][j] = (d[i-1][j-1] + d[i-1][j+1]) % M;
            }
        }

        long result = 0;
        for (i=0; i<10; i++) {
            result =  (result + d[n][i]) % M;
        }

        System.out.println(new StringBuilder().append(result));
    }

}
