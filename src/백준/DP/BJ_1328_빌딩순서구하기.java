package 백준.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1328_빌딩순서구하기 {

    static long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        long[][][] d = new long[n+1][l+1][r+1];

        d[1][1][1] = 1;

        int i, j, k;
        for (i=2; i<n+1; i++) {
            for (j=1; j<l+1; j++) {
                for (k=1; k<r+1; k++) {
                    d[i][j][k] = (d[i-1][j-1][k] + d[i-1][j][k-1] + (d[i-1][j][k] * (i-2))) % MOD;
                }
            }
        }

        System.out.println(new StringBuilder().append(d[n][l][r]));
    }

}
