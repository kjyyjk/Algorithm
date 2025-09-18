package 백준.DP_누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11049_행렬곱셈순서 {

    static int[][] matrix;
    static long[][] d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        matrix = new int[n+1][2];
        d = new long[n+1][n+1];

        StringTokenizer st;
        int i, r, c;
        for (i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            matrix[i] = new int[]{r, c};
        }

        int j;
        for (i=1; i<n+1; i++) {
            for (j=i; j<n+1; j++) {
                if (i==j) {
                    d[i][j] = 0;
                } else if (j-i == 1) {
                    d[i][j] = matrix[i][0] * matrix[j][0] * matrix[j][1];
                } else {
                    d[i][j] = -1;
                }
            }
        }

        System.out.println(new StringBuilder().append(cal(1, n)));
    }

    static long cal(int a, int b) {
        if (d[a][b] != -1) {
            return d[a][b];
        } else {
            long min = Integer.MAX_VALUE;
            for (int k=a; k<b; k++) {
                min = Math.min(min, cal(a, k) + cal (k+1, b) + (matrix[a][0] * matrix[k+1][0] * matrix[b][1]));
            }
            d[a][b] = min;
            return d[a][b];
        }
    }
}
