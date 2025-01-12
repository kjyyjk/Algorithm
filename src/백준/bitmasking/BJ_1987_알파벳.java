package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대 거리 구해야한다 -> 완전 탐색
 * 최대 거리는 알파벳 개수인 26이다 -> 백트래킹
 * 방문 상태가 30이하이다 -> 비트 마스킹
 *
 * 전역 변수로 방문 상태를 저장하지 않고, dfs의 인자로 방문 상태(num)를 넘긴다.
 * 따라서 현재 위치에서 탐색이 끝난 이후 현재 위치의 방문 상태를 다시 변경할 필요가 없다.
 *
 * 만약 최대 거리인 26에 도달하면 탐색을 중단한다.
 */
public class BJ_1987_알파벳 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int r, c, ret;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r + 4][c + 4];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        ret = 0;
        dfs(0, 0, 1 << (map[0][0] - 'A'), 1);
        System.out.println(new StringBuilder().append(ret));
    }

    static void dfs(int y, int x, int num, int cnt) {
        ret = Math.max(ret, cnt);
        for (int i = 0; i < 4; i++) {
            if (ret == 26) return;
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= r || ny < 0 || nx >= c || nx < 0) continue;
            if ((num & (1 << (map[ny][nx] - 'A'))) != 0) continue;
            dfs(ny, nx, num | (1 << (map[ny][nx] - 'A')), cnt + 1);
         }
    }
}