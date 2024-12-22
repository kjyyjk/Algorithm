package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 범인을 잡을때까지 dfs를 반복하여 풀 수 있다.(이전 커밋 확인)
 * 하지만 이는 매 dfs마다 시작 지점부터 중복 탐색해야하기 때문에 비효율적인 시간 복잡도를 가진다.
 *
 * bfs에 queue를 두개 활용하여 이를 개선할 수 있다.
 * 문제에서 bfs 탐색 레벨은 1(친구)을 기점으로 증가한다.
 * 따라서 친구가 아닐 때는 일반 queue에 추가해 쭉 탐색해나가고, 1(친구)이면 tempQ에 잠시 보관한다.
 * 이후 일반 queue가 비어 현재 레벨에서의 탐색이 종료되면, 레벨을 증가시키고 tempQ의 정점들로부터 다시 탐색을 시작한다.
 *
 * 이렇게 되면 dfs 때와는 다르게 모든 정점을 한번만 탐색하면서 범인을 잡기까지의 비용을 구할 수 있다.
 */
public class BJ_14497_주난의난 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m, x2, y2;
    static String[][] map;
    static int[][] visited;

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
        visited = new int[n + 4][m + 4];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = split[j];
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> temp = new LinkedList<>();

        int cnt = 1;
        queue.add(new int[]{y1, x1});
        visited[y1][x1] = cnt;
        while(!map[y2][x2].equals("0")) { // 범인을 잡을 때까지
            cnt++;
            while (!queue.isEmpty()) {
                int[] yx = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = yx[0] + dy[i];
                    int nx = yx[1] + dx[i];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                    if (visited[ny][nx] != 0) continue;
                    visited[ny][nx] = cnt;
                    if (!map[ny][nx].equals("0")) { // 만약 친구이면 방문처리하고 temp에 추가한다. 실제 방문은 하지 않는다.
                        map[ny][nx] = "0";
                        temp.add(new int[]{ny, nx});
                    } else {
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
            // 현재 레벨에서의 탐색이 끝나면. temp에 있는 정점들을 불러와 다음 레벨 탐색을 시작한다.
            queue.addAll(temp);
            temp.clear();
        }

        int ret = visited[y2][x2] - 1;
        System.out.println(new StringBuilder().append(ret));
    }
}
