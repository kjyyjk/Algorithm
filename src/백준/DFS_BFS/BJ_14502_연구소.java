package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14502_연구소 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];

        int ret = 0;

        int wallCnt = 3;
        int virusCnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    virusCnt++;
                }
                if (num == 1) {
                    wallCnt++;
                }
                map[i][j] = num;
            }
        }

        for (int i = 0; i < n * m; i++) {
            if (map[i / m][(i % m)] != 0) continue;
            map[i / m][(i % m)] = 1;

            for (int j = i + 1; j < n * m; j++) {
                if (map[j / m][(j % m)] != 0) continue;
                map[j / m][(j % m)] = 1;

                for (int k = j + 1; k < n * m; k++) {
                    if (map[k / m][(k % m)] != 0) continue;
                    map[k / m][(k % m)] = 1;

                    cnt = 0;
                    visited = new boolean[n][m];

                    for (int y = 0; y < n; y++) {
                        for (int x = 0; x < m; x++) {
                            if (map[y][x] == 2 && !visited[y][x]) {
                                visited[y][x] = true;
                                dfs(y, x);
                            }
                        }
                    }

                    int safe = n * m - wallCnt - virusCnt - cnt;
                    ret = Math.max(ret, safe);

                    map[k / m][(k % m)] = 0;
                }
                map[j / m][(j % m)] = 0;
            }
            map[i / m][(i % m)] = 0;
        }

        System.out.println(new StringBuilder().append(ret));
    }

    private static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (visited[ny][nx]) continue;
            if (map[ny][nx] != 0) continue;

            visited[ny][nx] = true;
            cnt++;
            dfs(ny, nx);
        }
    }
}
