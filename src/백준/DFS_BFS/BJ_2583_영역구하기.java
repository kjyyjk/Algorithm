package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2583_영역구하기 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int m, n;
    static int[][] a = new int[104][104];
    static boolean[][] visited = new boolean[104][104];
    static int depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y=y1; y<y2; y++) {
                for (int x=x1; x<x2; x++) {
                    a[y][x] = 1;
                }
            }
        }

        List<Integer> depths = new ArrayList<>();
        int cnt = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                depth = 0;
                if (a[i][j] == 1) continue;
                if (visited[i][j]) continue;
                dfs(i, j);
                depths.add(depth);
                cnt++;
            }
        }

        Collections.sort(depths);
        StringBuilder sb = new StringBuilder();

        sb.append(cnt).append('\n');
        for (int temp : depths) {
            sb.append(temp).append(' ');
        }

        System.out.println(sb);
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;
        depth++;

        for (int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= m || ny < 0 || nx >= n || nx < 0) continue;
            if (a[ny][nx] == 1) continue;
            if (visited[ny][nx]) continue;

            dfs(ny, nx);
        }
    }
}
