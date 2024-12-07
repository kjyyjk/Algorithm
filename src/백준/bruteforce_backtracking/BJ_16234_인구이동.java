package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * dfs를 통해 특정 나라에서 연합국들을 탐색(연합국의 y,x 보관 : union, 연합국의 인구 수 합 보관 : sum)
 * 연합국의 개수가 2이상이면 연합국들의 인구 수를 연합 전체의 평균으로 조정(인구 이동이 일어났으므로 flag = true)
 * 방문하지 않은 나라에서 반복 수행(모든 나라를 방문할 때까지)
 * 모든 나라를 방문하고 난 뒤, 만약 인구 이동이 일어나지 않았으면 종료 후 ret 출력
 * 인구 이동이 일어났으면 ret 증가 후 다시 전체 반복
 */
public class BJ_16234_인구이동 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int n, l, r, sum;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> union;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ret = 0;
        while (true) {
            boolean flag = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) continue;
                    union = new ArrayList<>();
                    visited[i][j] = true;
                    sum = map[i][j];
                    union.add(new int[]{i, j});
                    dfs(i, j);
                    if (union.size() == 1) continue;
                    for (int[] yx : union) {
                        map[yx[0]][yx[1]] = sum / union.size();
                        flag = true;
                    }
                }
            }
            if (!flag) break;
            ret++;
        }

        System.out.println(new StringBuilder().append(ret));
    }

    static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= n || ny < 0 || nx >= n || nx < 0) continue;
            if (visited[ny][nx]) continue;
            if (Math.abs(map[ny][nx] - map[y][x]) < l || Math.abs(map[ny][nx] - map[y][x]) > r) continue;
            visited[ny][nx] = true;
            union.add(new int[]{ny, nx});
            sum += map[ny][nx];
            dfs(ny, nx);
        }
    }
}
