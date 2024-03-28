package 백준.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2775_부녀회장이될테야 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int [][] d = new int[15][15];

        int i;
        for (i=0; i<15; i++) {
            d[0][i] = i;
            d[i][1] = 1;
        }

        int j;
        for (i=1; i<15; i++) {
            for (j=2; j<15; j++) {
                d[i][j] = d[i][j-1] + d[i-1][j];
            }
        }

        StringBuilder result = new StringBuilder();
        int k, n;
        for (i=0; i<t; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());

            result.append(d[k][n]).append('\n');
        }

        System.out.println(result);
    }
}
