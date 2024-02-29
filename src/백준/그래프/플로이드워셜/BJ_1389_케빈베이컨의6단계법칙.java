package 백준.그래프.플로이드워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1389_케빈베이컨의6단계법칙 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] distance = new int[n+1][n+1];
        int[] result = new int[n+1];

        int i, j;
        for (i=1; i<n+1; i++) {
            for (j=1; j<n+1; j++) {
                if (i==j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = 500001;
                }
            }
        }

        int a, b;
        for (i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            distance[a][b] = 1;
            distance[b][a] = 1;
        }

        int k;
        for (k=1; k<n+1; k++) {
            for (i=1; i<n+1; i++) {
                for (j=1; j<n+1; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        int temp;
        int min = 500001;
        for (i=1; i<n+1; i++) {
            temp = 0;
            for (j=1; j<n+1; j++) {
                temp += distance[i][j];
            }

            result[i] = temp;

            if (min > temp) {
                min = temp;
            }
        }

        for (i=1; i<n+1; i++) {
            if (result[i] == min) {
                System.out.println(new StringBuilder().append(i));
                break;
            }
        }
    }


}
