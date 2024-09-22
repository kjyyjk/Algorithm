package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178_미로탐색 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int[][] map;
    static int[][] visited;

    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for (int i=0; i<n; i++) {
            String[] input = br.readLine().split("");
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs(0, 0);
        System.out.println(new StringBuilder().append(visited[n-1][m-1]));
    }

    static void bfs(int sy, int sx) {
        Queue<int[]> queue = new LinkedList<>();
        visited[sy][sx] = 1;
        queue.add(new int[]{sy, sx});

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int y = temp[0];
            int x = temp[1];

            for (int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >=n || nx <0 || nx >= m) continue;
                if (map[ny][nx] != 1) continue;
                if (visited[ny][nx] != 0) continue;

                queue.add(new int[]{ny, nx});
                visited[ny][nx] = visited[y][x] + 1;
            }
        }
    }
}
