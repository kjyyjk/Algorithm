package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 꽃을 3곳에 심어야한다.
 * 최대 시간 복잡도 -> 100C3 이므로 완전탐색 가능.
 *
 * 꽃을 심을 지점을 체크한다. (다른 꽃과 겹치는지)
 * 꽃을 심는다. (상하좌우 4방향으로 꽃을 표시한다.)
 * 심은 꽃 개수를 1증가하고, 비용을 증가시킨 뒤 go를 호출해 또 다른 꽃을 심는다.
 * 이렇게 반복하다가 꽃을 3개 심고나면 비용을 최소로 갱신한다.
 * 다른 지점 탐색이 끝나고 나면 심었던 꽃을 지운다.
 *
 * 꽃은 상하좌우로 피기 때문에 기본적으로 y = 0 또는 끝, x = 0 또는 끝은 불가하다.
 * 이를 체크로직에서 체크할 수도 있으나 나는 아예 탐색 범위에서 빼버렸다.
 * 따라서 코드에는 범위에 대한 별도의 체크 로직이 없다.
 *
 * 또한 순서가 상관없는 조합에 해당하므로, 이미 지나온 행을 다시 탐색 할 필요가 없다.
 * 따라서 go 재귀함수의 첫번째 파라미터로 탐색을 이어나갈 시작 행을 둔다.
 */
public class BJ_14620_꽃길 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int n, ret;
    static int[][] map, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n + 4][n + 4];
        visited = new int[n + 4][n + 4];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ret = 100000;

        go(1, 0, 0);
        System.out.println(new StringBuilder().append(ret));
    }

    static void go(int now, int cost, int cnt) {
        if (cnt == 3) {
            ret = Math.min(ret, cost);
            return;
        }

        for (int i = now; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!check(i, j)) continue;
                int temp = setFlower(i, j);
                go(i, cost + temp, cnt + 1);
                eraseFlower(i, j);
            }
        }
    }

    static boolean check(int y, int x) {
        if (visited[y][x] == 1) return false;
        for (int i = 0; i < 4; i++) {
            if (visited[y + dy[i]][x + dx[i]] == 1) {
                return false;
            }
        }
        return true;
    }

    static int setFlower(int y, int x) {
        int temp = map[y][x];
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            temp += map[y + dy[i]][x + dx[i]];
            visited[y + dy[i]][x + dx[i]] = 1;
        }
        return temp;
    }

    static void eraseFlower(int y, int x) {
        visited[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            visited[y + dy[i]][x + dx[i]] = 0;
        }
    }
}
