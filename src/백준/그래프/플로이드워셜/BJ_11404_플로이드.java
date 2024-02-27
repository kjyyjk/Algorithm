package 백준.그래프.플로이드워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11404_플로이드 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] distance = new int[n+1][n+1];

        int i, j;
        for (i=1; i<n+1; i++) {
            for (j=1; j<n+1; j++) {
                if (i==j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = 10000001;
                }
            }
        }

        StringTokenizer st;
        int a, b, c;
        for (i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (distance[a][b] > c) { // 노선 동일하고 가중치가 다른 버스 존재
                distance[a][b] = c;
            }
        }

        int k;
        for (k=1; k<n+1; k++) {
            for (i=1; i<n+1; i++) {
                for (j=1; j<n+1; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (i=1; i<n+1; i++) {
            for (j=1; j<n+1; j++) {
                if (distance[i][j] == 10000001) {
                    sb.append(0).append(' ');
                }else {
                    sb.append(distance[i][j]).append(' ');
                }
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
