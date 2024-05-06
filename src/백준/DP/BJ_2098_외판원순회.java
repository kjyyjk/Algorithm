package 백준.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2098_외판원순회 {

    static int n;
    static int[][] w;
    static int[][] d;
    static int INF = 16*1000000 + 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        w = new int[n][n];
        d = new int[n][1<<16];

        StringTokenizer st;
        int i, j;
        for (i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (j=0; j<n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = tsp(0, 1); //0번 도시를 방문했고 현재 0번도시에 위치해있을때 모든 도시 순회 최소 비용

        System.out.println(new StringBuilder().append(result));
    }

    static int tsp(int c, int v) {
        if (v == ((1<<n)-1)) { //모든 도시 방문
            if (w[c][0] != 0) { //현재 도시에서 시작도시로 갈 수 있으면
                return w[c][0];
            } else { //갈 수 없으면
                return INF;
            }
        }

        if (d[c][v] != 0) { //계산한 적이 있으면
            return d[c][v];
        }

        int min = INF;
        int i;
        for (i=0; i<n; i++) {
            if (((v & (1<<i)) == 0) && (w[c][i] != 0)) { //방문하지 않았고 현재 도시에서 갈 수 있으면
                min = Math.min(min, tsp(i, v|(1<<i)) + w[c][i]); //재귀
            }
        }

        d[c][v] = min; // v 도시들을 방문했고 현재도시 c일때 순회 최소 비용

        return d[c][v];
    }
}
