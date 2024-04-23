package 백준.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2342_DanceDanceRevolution {

    static int MAX = 10000000;

    public static void main(String[] args) throws IOException {

        int[][] m = {{1, 2, 2, 2, 2},
                    {0, 1, 3, 4, 3},
                    {0, 3, 1, 3, 4},
                    {0, 4, 3, 1, 3},
                    {0, 3, 4, 3, 1}};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[][][] d = new int[100001][5][5];

        int i, l, r;
        for (l=0; l<5; l++) {
            for (r=0; r<5; r++) {
                for (i=0; i<100001; i++) {
                    d[i][l][r] = MAX;
                }
            }
        }
        d[0][0][0] = 0;

        int cnt = 0;
        int n;
        while (true) {
            n = Integer.parseInt(st.nextToken()); //밟아야할 발판

            if (n==0) {
                break;
            }

            cnt++;

            //왼발을 움직일 경우
            for (r=0; r<5; r++) { //오른발 위치
                if (n==r) {
                    continue;
                } else {
                    for (i=0; i<5; i++) { //왼발의 이전 위치
                        d[cnt][n][r] = Math.min(d[cnt][n][r], d[cnt-1][i][r] + m[i][n]);
                    }
                }
            }

            //오른발을 움직일 경우
            for (l=0; l<5; l++) { //왼발 위치
                if (n==l) {
                    continue;
                } else {
                    for (i=0; i<5; i++) { //오른발의 이전 위치
                        d[cnt][l][n] = Math.min(d[cnt][l][n], d[cnt-1][l][i] + m[i][n]);
                    }
                }
            }
        }

        int result = MAX;
        for (l=0; l<5; l++) {
            for (r=0; r<5; r++) {
                result = Math.min(result, d[cnt][l][r]); //마지막 시행번째에서 최솟값이 곧 답
            }
        }

        System.out.println(new StringBuilder().append(result));


    }

}
