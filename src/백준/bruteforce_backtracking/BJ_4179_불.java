package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 모서리에 불보다 빨리 도착하면 탈출할 수 있다. -> 최단 거리가 불보다 작아야한다
 * bfs를 통해 불의 최단 거리를 먼저 구한다
 * 이후 bfs를 통해 진수의 최단 거리를 구한다
 * 진수는 불을 지날 수 없으므로 매 좌표마다 불의 최단거리와 비교하여 탐색 여부를 판단한다
 * 만약 모서리 지점에 달하면 그 즉시 반복을 중단하고 정답을 출력한다
 * 
 * 불이 없는 경우도 있다. 이 경우 불의 최단 거리가 모두 0으로 처리되어,
 * 모든 좌표에서 진수보다 최단 거리가 작아 진수의 탐색이 제대로 이루어지지 않는다.
 * 따라서 불의 경우에는 초기에 fvisited를 정수 최대값으로 초기화한다.
 */
public class BJ_4179_불 {
    static int r, c;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static String[][] map;
    static int[][] visited, fVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new String[r][c];
        visited = new int[r][c];
        fVisited = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                fVisited[i][j] = Integer.MAX_VALUE; // 불의 최단 거리를 전부 최대값으로 초기화
            }
        }

        int sy = 0;
        int sx = 0;
        Queue<int[]> fire = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                String temp = split[j];
                if (temp.equals("F")) {
                    fire.add(new int[]{i, j});
                    fVisited[i][j] = 1;
                }
                if (temp.equals("J")) {
                    sy = i;
                    sx = j;
                }
                map[i][j] = temp;
            }
        }

        while (!fire.isEmpty()) {
            int[] yx = fire.poll();
            int y = yx[0];
            int x = yx[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny >= r || ny < 0 || nx >= c || nx < 0) continue;
                if (fVisited[ny][nx] != Integer.MAX_VALUE) continue;
                if (map[ny][nx].equals("#")) continue;
                fire.add(new int[]{ny, nx});
                fVisited[ny][nx] = fVisited[y][x] + 1;
            }
        }

        int ret = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        visited[sy][sx] = 1;
        queue.add(new int[]{sy, sx});
        while (!queue.isEmpty()) {
            int[] yx = queue.poll();
            int y = yx[0];
            int x = yx[1];
            if (y == 0 || y == r - 1 || x == 0 || x == c - 1) { //모서리에 닿았으면
                ret = visited[y][x];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny >= r || ny < 0 || nx >= c || nx < 0) continue;
                if (visited[ny][nx] != 0) continue;
                if (map[ny][nx].equals("#")) continue;
                if (fVisited[ny][nx] <= visited[y][x] + 1) continue; //불보다 빨리 도착하면 탐색
                queue.add(new int[]{ny, nx});
                visited[ny][nx] = visited[y][x] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (ret < Integer.MAX_VALUE) {
            sb.append(ret);
        } else {
            sb.append("IMPOSSIBLE");
        }
        System.out.println(sb);
    }
}
