package 백준.DP_누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1915_가장큰정사각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n+1][m+1];
        int[][] d = new int[n+1][m+1];

        int i, j;
        String s;
        for (i=1; i<n+1; i++) {
            s = br.readLine();
            for (j=1; j<m+1; j++) {
                a[i][j] = Integer.parseInt(String.valueOf(s.charAt(j-1)));
            }
        }

        int max = 0;
        for (i=1; i<n+1; i++) {
            for (j=1; j<m+1; j++) {
                if (a[i][j] == 1) {
                    d[i][j] = Math.min(Math.min(d[i-1][j], d[i][j-1]), d[i-1][j-1]) + 1;

                    if (d[i][j] > max) {
                        max = d[i][j];
                    }
                }
            }
        }

        int result = max * max;
        System.out.println(new StringBuilder().append(result));

    }

}
