package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 모든 경로를 탐색해야하는 완전 탐색 문제.
 * dfs를 이용하여 탐색을 하고, 최대 개수를 갱신한다.
 * 이미 방문한 알파벳은 탐색하지 않음.
 * 모든 경로를 탐색해야하기 때문에 다음과 같은 코드 구조를 가져야한다.
 * 
 * 다음 정점 visited 처리
 * dfs(다음 정점)
 * 다음 정점 visited 취소
 */
public class BJ_1987_알파벳 {
    static int r, c, cnt;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;
    static int[] visited = new int['Z' - 'A' + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        visited[map[0][0] - 'A'] = 1;
        dfs(0, 0, 1);
        System.out.println(new StringBuilder().append(cnt));
    }

    static void dfs(int y, int x, int num) {
        cnt = Math.max(cnt, num);
        if (cnt == 26) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
            if (visited[map[ny][nx] - 'A'] != 0) continue;
            visited[map[ny][nx] - 'A'] = 1;
            dfs(ny, nx, num + 1);
            visited[map[ny][nx] - 'A'] = 0;
            if (cnt == 26) {
                return;
            }
        }
    }
}
