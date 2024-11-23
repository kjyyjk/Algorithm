package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 한번 탐색에 껍질 한 칸을 깔 수 있으므로 최대 반복횟수는 10번이 될 것이다.
 * 0, 0에서 탐색을 시작하여 가장자리의 치즈 좌표들을 저장한다. 가장자리만을 저장하기 위해 치즈이면 방문 표시만하고 dfs는 시행하지 않는다.
 * 탐색이 끝나면 좌표들의 값을 전부 0으로 변경하여 치즈를 녹인다.
 * 녹인 만큼 치즈 크기를 줄인다.
 * 치즈 크기가 0이 될때까지 반복한다.
 * 치즈 크기가 0이 되면 반복 횟수와 마지막 녹인 크기 출력한다.
 */
public class BJ_2636_치즈 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int n, m;
    static boolean[][] visited;
    static int[][] map;
    static List<int[]> melt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int cheeze = 0;
        map = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    cheeze++;
                }
                map[i][j] = num;
            }
        }

        int hour = 0;
        while (true) {
            if (cheeze == 0) { //다 녹았으면 종료
                break;
            }
            visited = new boolean[n + 1][m + 1];
            melt = new ArrayList<>();

            visited[0][0] = true;
            dfs(0, 0); // 0,0에서 시작하면 모든 가장자리를 돌면서 탐색할 수 있다.

            for (int[] yx : melt) { // 공기와 맞닿아 표시된 치즈 녹이기
                map[yx[0]][yx[1]] = 0;
            }
            cheeze -= melt.size();
            hour++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(hour).append('\n');
        sb.append(melt.size()).append('\n'); // 마지막 녹인 크기
        System.out.println(sb);
    }

    private static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (visited[ny][nx]) continue;

            visited[ny][nx] = true;
            if (map[ny][nx] == 1) { // 치즈이면 방문 처리랑 녹일 표시만 하고 진입은 하지 않는다.
                melt.add(new int[]{ny, nx});
            } else {
                dfs(ny, nx);
            }
        }
    }
}
