package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대 경우는 300개의 가로선 중 3개를 뽑는 것임 -> 450만정도. 완전탐색 가능
 *
 * 시간 복잡도가 빡세기 때문에 백트래킹.
 * 현재 레벨이 이미 조건을 만족한 ret 이상이라면 더 탐색할 필요가 없다. 최소의 ret을 구해야하므로.
 * 현재 레벨이 4이상이면( > 3) 더 탐색할 필요가 없다.
 *
 * 문제에서 입력으로 주어지는 입력 포맷을 그대로 저장한다.
 * a, b -> 행(h), 열(n)
 *
 * go()는 재귀함수로 가로선을 추가한 모든 경우를 탐색한다.
 * 현재까지의 가로선 위치(행)와 레벨(추가 가로선의 개수)을 파라미터로 가진다.
 * 위에서 언급한 조건에 따라 백트래킹.
 * solve()를 통해 사다리 조건을 성립하면 ret 갱신.
 * 아니라면 현재까지 가로선 위치부터 다시 가로선을 추가하고 레벨을 증가시켜 재귀호출한다.
 * 사다리 조건에 따라 이미 가로선이 존재하거나 앞뒤로 가로선이 존재하면 패스한다.
 *
 * 현재까지 가로선 위치부터 가로선을 추가하지 않고 처음부터 탐색하며 추가해도 되지만, 시간초과에 걸린다.
 * 가로선 추가는 순열이 아닌 조합이므로 현재 위치부터 추가한다.
 */
public class BJ_15684_사다리조작 {
    static int n, h;
    static boolean[][] map;
    static int ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new boolean[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
        }

        ret = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        go(1, 0);
        if (ret > 3) {
            sb.append(-1);
        } else {
            sb.append(ret);
        }
        System.out.println(sb);
    }

    static void go(int now, int level) {
        if (level > 3 || ret <= level) return;
        if (solve()) {
            ret = Math.min(ret, level);
            return;
        }
        for (int i = now; i < h + 1; i++) {
            for (int j = 1; j < n; j++) {
                if (map[i][j] || map[i][j-1] || map[i][j+1]) continue;
                map[i][j] = true;
                go(i, level + 1);
                map[i][j] = false;
            }
        }
    }

    static boolean solve() {
        for (int i = 1; i < n + 1; i++) {
            int temp = i;
            for (int j = 1; j < h + 1; j++) {
                if (map[j][temp - 1]) {
                    temp--;
                } else if (temp != n && map[j][temp]){
                    temp++;
                }
            }
            if (temp != i) {
                return false;
            }
        }

        return true;
    }
}
