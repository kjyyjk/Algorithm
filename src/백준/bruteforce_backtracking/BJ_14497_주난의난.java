package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14497_주난의난 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m, x2, y2;
    static String[][] map;
    static boolean[][] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int y1 = Integer.parseInt(st.nextToken()) - 1;
        int x1 = Integer.parseInt(st.nextToken()) - 1;
        y2 = Integer.parseInt(st.nextToken()) - 1;
        x2 = Integer.parseInt(st.nextToken()) - 1;

        map = new String[n + 4][m + 4];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = split[j];
            }
        }

        flag = false;
        int cnt = 0;
        while (!flag) {
            visited = new boolean[n + 4][m + 4];
            visited[y1][x1] = true;
            dfs(y1, x1);
            cnt++;
        }
        System.out.println(new StringBuilder().append(cnt));
    }

    static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (visited[ny][nx]) continue;
            if (ny == y2 && nx == x2) {
                flag = true;
                break;
            }
            if (map[ny][nx].equals("1")) {
                map[ny][nx] = "0";
                visited[ny][nx] = true;
                continue;
            }

            visited[ny][nx] = true;
            dfs(ny, nx);
        }
    }
}
