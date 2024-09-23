package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1012_유기농배추 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int n, m, k;
    static int[][] a;
    static boolean[][] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int z=0; z<t; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            a = new int[n][m];
            visited = new boolean[n][m];
            cnt = 0;

            for (int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                a[y][x] = 1;
            }

            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (a[i][j] != 1) continue;
                    if (visited[i][j]) continue;
                    dfs(i, j);
                    cnt++;
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= n || ny < 0 || nx >= m || nx < 0) continue;
            if (a[ny][nx] != 1) continue;
            if (visited[ny][nx]) continue;
            dfs(ny, nx);
        }
    }
}
