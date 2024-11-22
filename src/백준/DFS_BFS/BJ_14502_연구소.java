package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_14502_연구소 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> wallList;
    static List<int[]> virusList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];

        wallList = new ArrayList<>();
        virusList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    virusList.add(new int[]{i, j});
                }
                if (num == 0) {
                    wallList.add(new int[]{i, j});
                }
                map[i][j] = num;
            }
        }

        int ret = 0;
        for (int i = 0; i < wallList.size(); i++) {
            for (int j = i + 1; j < wallList.size(); j++) {
                for (int k = j + 1; k < wallList.size(); k++) {
                    map[wallList.get(i)[0]][wallList.get(i)[1]] = 1;
                    map[wallList.get(j)[0]][wallList.get(j)[1]] = 1;
                    map[wallList.get(k)[0]][wallList.get(k)[1]] = 1;

                    ret = Math.max(ret, solve());

                    map[wallList.get(i)[0]][wallList.get(i)[1]] = 0;
                    map[wallList.get(j)[0]][wallList.get(j)[1]] = 0;
                    map[wallList.get(k)[0]][wallList.get(k)[1]] = 0;
                }
            }
        }

        System.out.println(new StringBuilder().append(ret));
    }

    private static int solve() {
        int cnt = 0;
        visited = new boolean[n][m];

        for (int i = 0; i < virusList.size(); i++) {
            int y = virusList.get(i)[0];
            int x = virusList.get(i)[1];
            visited[y][x] = true;
            dfs(y, x);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (visited[ny][nx]) continue;
            if (map[ny][nx] != 0) continue;

            visited[ny][nx] = true;
            dfs(ny, nx);
        }
    }
}
