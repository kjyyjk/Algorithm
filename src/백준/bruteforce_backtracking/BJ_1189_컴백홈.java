package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 한수가 위치한 곳부터 집까지의 모든 경로를 완전 탐색한다.
 * 한수가 집에 도착했을 때 그 거리가 k이면 정답을 1 증가하고 거기서 탐색을 이어나가지 않는다.
 * 아니라면 다른 거리로 다시 집에 방문할 수 없기 때문에 탐색을 이어나가지 않는다.
 * 또한 집에 도착하기 이전에 이동 거리가 k이상에 달하면 탐색을 이어나가지 않는다.
 * 
 * 주의할 것은 처음 한수가 위치하는 곳부터 거리 1을 세어야한다.
 * 또한 T에 대한 조건이 자세히 나와있지 않으므로, 한수가 처음 위치하는 곳에 T가 있을 경우도 고려했다.
 *
 * 현재 코드는 전역변수 ret을 두어 조건을 만족했을 때 1씩 증가하는 식으로 작성했으나
 * go가 총 경우의 수를 반환하게끔 작성할 수도 있다.
 * 이 경우에는 cnt파라미터가 아닌, visited에 이동 거리를 보관한 뒤 집에 도달했을 때 거리를 비교한다.
 * 그리고 같다면 한가지 경우의 수인 1을 반환한다. 아니라면 0을 반환한다.
 * go 메서드는 다음과 같은 형태일 것이다.
 *
 * 값 비교 및 반환
 * ret = 0
 * for ny, nx
 *   visited[ny][nx] = visited[y][x] + 1
 *   ret += go(ny, nx)
 *   visited[ny][nx] = 0
 * return ret
 */
public class BJ_1189_컴백홈 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int r, c, k, ret;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[r + 4][c + 4];
        visited = new boolean[r + 4][c + 4];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        ret = 0;
        if (map[r - 1][0] != 'T') {
            visited[r - 1][0] = true;
            go(r - 1, 0, 1);
        }
        System.out.println(new StringBuilder().append(ret));
    }

    static void go(int y, int x, int cnt) {
        if (y == 0 && x == c - 1) {
            if (cnt == k) {
                ret++;
            }
            return;
        }
        if (cnt >= k) return;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
            if (visited[ny][nx]) continue;
            if (map[ny][nx] == 'T') continue;
            visited[ny][nx] = true;
            go(ny, nx, cnt + 1);
            visited[ny][nx] = false;
        }
    }
}
