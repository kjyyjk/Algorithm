package 백준.그래프.플로이드워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11403_경로찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] distance = new int[n][n];

        int i, j;
        StringTokenizer st;
        for (i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (j=0; j<n; j++) {
                distance[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int k, s, e;
        for (k=0; k<n; k++) {
            for (s=0; s<n; s++) {
                for (e=0; e<n; e++) {
                    if (distance[s][e]==0) {
                        if (distance[s][k]==1 && distance[k][e]==1) {
                            distance[s][e] = 1;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (i=0; i<n; i++) {
            for (j=0; j<n; j++) {
                sb.append(distance[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

}
