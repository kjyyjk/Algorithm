package 백준.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11051_이항계수2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] d = new int[n+1][n+1];

        int i;
        for (i=1; i<n+1; i++) {
            d[i][0] = 1;
            d[i][1] = i;
            d[i][i] = 1;
        }

        int j;
        for (i=2; i<n+1; i++) {
            for (j=2; j<i+1; j++) {
                d[i][j] = ((d[i-1][j-1] % 10007) + (d[i-1][j] % 10007)) % 10007;
            }
        }

        System.out.println(new StringBuilder().append(d[n][k]));
    }

}
