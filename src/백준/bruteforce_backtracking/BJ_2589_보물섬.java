package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 가장 먼 최단거리를 구하는 문제이다.
 * 특정 L에서 BFS를 수행해 가장 먼 최단 거리를 구하고
 * 모든 L에서 이를 반복하여 가장 큰 값을 채택한다.
 * 최대 범위의 50 * 50에서 나올 수 있는 가장 큰 값은 100이다.
 * 만약 ret이 최대값인 100이 되면 반복을 중단한다.
 * BFS에서 최단 거리는 1부터 시작하여 (실제 거리 + 1)임을 주의한다.
 */
public class BJ_2589_보물섬 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static String[][] map;
    static int[][] visited;
    static int n, m;
    static List<int[]> lands = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new String[n][m];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j ++) {
                String s = input[j];
                if (s.equals("L")) {
                    lands.add(new int[]{i, j});
                }
                map[i][j] = s;
            }
        }

        int ret = 0;
        for (int[] land : lands) {
            if (ret == 100) {
                break;
            }
            visited = new int[n][m];
            ret = Math.max(ret, bfs(land[0], land[1]));
        }

        System.out.println(new StringBuilder().append(ret));
    }

    static int bfs(int sy, int sx) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sy, sx});
        visited[sy][sx] = 1;
        int ret = 0;

        while(!queue.isEmpty()) {
            int[] yx = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = yx[0] + dy[i];
                int nx = yx[1] + dx[i];

                if (ny >= n || ny < 0 || nx >= m || nx < 0) continue;
                if (visited[ny][nx] != 0) continue;
                if (map[ny][nx].equals("W")) continue;
                queue.add(new int[]{ny, nx});
                visited[ny][nx] = visited[yx[0]][yx[1]] + 1;
                ret = visited[yx[0]][yx[1]];
            }
        }

        return ret;
    }
}
