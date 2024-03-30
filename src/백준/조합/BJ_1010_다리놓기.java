package 백준.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1010_다리놓기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[][] d= new int[31][31];

        int i;
        for (i=1; i<31; i++) {
            d[i][0] = 1;
            d[i][1] = i;
            d[i][i] = 1;
        }

        int j;
        for (i=2; i<31; i++) {
            for (j=2; j<i+1; j++) {
                d[i][j] = d[i-1][j-1] + d[i-1][j];
            }
        }

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n, m;
        for (i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            sb.append(d[m][n]).append('\n');
        }

        System.out.println(sb);
    }

}
