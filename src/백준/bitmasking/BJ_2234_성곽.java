package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 벽의 유무가 이진수 비트로 주어진다 -> 비트마스킹
 * 0번째 비트 on -> 서쪽 벽 존재
 * 1번째 비트 on -> 북쪽 벽 존재 (y가 -)
 * 2번째 비트 on -> 동쪽 벽 존재
 * 3번째 비트 on -> 남쪽 벽 존재 (y가 +)
 * 이에 맞추어 dy, dx를 초기화한다.
 *
 * 연결 요소의 개수(방 개수) = dfs 횟수
 * 최대 방 크기 = dfs()를 통해 반환 받은 연결 요소의 depth를 최대로 갱신. depths[방번호]에 방 크기를 저장.
 * 벽을 허물어 합친 방 최대 크기 = dfs()를 한번 더 수행해 갱신된 ret3
 *
 * dfs()는 인자로 주어지는 num으로 방문한 곳의 방 번호를 표기한다.
 * 만약 다음 방향에 벽이 없으면 -> 방문했는지 여부를 체크하고 방문하지 않았으면 이어서 탐색한다.
 * 만약 벽이 있으면 -> 만약 현재 방번호와 벽 넘어의 방 번호가 다르면 -> 두 방의 크기를 합하여 ret3로 최대 갱신한다.
 * (마지막 줄은 사실상 모든 방의 번호 표기와 넓이 저장이 완료되는 첫번째 dfs 탐색 이후 두번째 dfs에서 유효하다.)
 */
public class BJ_2234_성곽 {
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
    static int n, m;
    static int[][] visited, map;
    static int[] depths;
    static int ret3 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m + 4][n + 4];
        visited = new int[m + 4][n + 4];
        depths = new int[2500 + 4];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ret1 = 0;
        int ret2 = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0) {
                    int depth = dfs(i, j, ++ret1);
                    depths[ret1] = depth;
                    ret2 = Math.max(ret2, depth);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, visited[i][j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(ret1).append('\n').append(ret2).append('\n').append(ret3));
    }

    static int dfs(int y, int x, int num) {
        visited[y][x] = num;
        int ret = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= m || nx < 0 || nx >= n) continue;
            if ((map[y][x] & (1 << i)) != 0) {
                if (num != visited[ny][nx]) {
                    ret3 = Math.max(ret3, depths[num] + depths[visited[ny][nx]]);
                }
            } else {
                if (visited[ny][nx] != 0) continue;
                ret += dfs(ny, nx, num);
            }
        }
        return ret;
    }
}
