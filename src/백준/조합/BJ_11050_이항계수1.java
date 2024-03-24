package 백준.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11050_이항계수1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] d = new int[n+1][n+1];

        int i, j;
        for (i=1; i<n+1; i++) {
            for (j=0; j<i+1; j++) {
                if (j==0) {
                    d[i][j] = 1; //iC0 = 1
                } else if (j==1) {
                    d[i][j] = i; //iC1= i
                } else if (i==j) {
                    d[i][j] = 1; //iCi = 1
                }
            }
        }

        for (i=2; i<n+1; i++) { //i=1 인 경우는 이미 앞에서 채움
            for (j=2; j<i+1; j++) { //j=0, j=1인 경우도 앞에서 채움
                d[i][j] = d[i-1][j] + d[i-1][j-1]; //조합의 점화식
            }
        }

        System.out.println(new StringBuilder().append(d[n][k]));
    }

}
