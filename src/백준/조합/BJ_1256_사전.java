package 백준.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1256_사전 {

    public static void main(String[] args) throws IOException {

        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long[][] d = new long[n + m + 1][n + m + 1];

        int i, j;
        for (i=0; i<n+m+1; i++) {
            d[i][0] = 1;
            d[i][1] = i;
            d[i][i] = 1;
        }

        for (i=3; i<n+m+1; i++) {
            for (j=2; j<i+1; j++) {
                d[i][j] = d[i-1][j-1] + d[i-1][j];
                if (d[i][j] > 1000000000) {
                    d[i][j] = 1000000001;
                }
            }
        }

        if (d[n+m][m] < k) {
            System.out.println(result.append(-1));
            return;
        }

        while(!(n==0 && m==0)) {
            if (d[n+m-1][m] >= k) { //a를 선택
                result.append('a');
                n--; //남은 a 개수
            } else { //z를 선택
                result.append('z');
                k -= d[n+m-1][m];
                m--;
            }
        }

        System.out.println(result);
    }
}
