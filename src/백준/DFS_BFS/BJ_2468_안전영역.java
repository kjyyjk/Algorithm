package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2468_안전영역 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int[][] a;
    static boolean[][] visited;
    static int n;
    static int rain;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        a = new int[101][101];

        int height = 0;
        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                a[i][j] = temp;
                height = Math.max(height, temp);
            }
        }

        int ret = 1;
        for (rain=0; rain<height; rain++) {
            visited = new boolean[101][101];
            int cnt = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (a[i][j] <= rain) continue;
                    if (visited[i][j]) continue;
                    dfs(i, j);
                    cnt++;
                }
            }

            ret = Math.max(ret, cnt);
        }

        System.out.println(new StringBuilder().append(ret));
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= n || ny < 0 || nx >= n || nx < 0) continue;
            if (a[ny][nx] <= rain) continue;
            if (visited[ny][nx]) continue;

            dfs(ny, nx);
        }
    }
}
