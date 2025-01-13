package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 비트마스킹으로 하면 혼쭐나는 문제. -> 시간 다 잡아먹은 이유 2
 * n의 범위가 30을 넘어 100까지 간다.
 * 따라서 비트마스킹으로 경사로 상태를 저장하는 것은 불가하다.
 *
 * 행과 열을 하나씩 확인한다.
 * 만약 다음 칸이 현재 칸보다 1칸 높으면 현재 칸을 기준으로 l개의 칸에 경사로를 설치할 수 있는 지 확인하고 경사로를 설치한다.
 * 만약 다음 칸이 현재 칸보다 1칸 낮으면 다음 칸을 기준으로 l개의 칸에 경사로를 설치할 수 있는 지 확인하고 경사로를 설치한다. 
 * 만약 다음 칸과 현재 칸의 높이 차가 1보다 크면 해당 열 또는 행은 길이 될 수 없다.
 * 
 * 추가로 가로 길과 세로 길은 서로 독립적이다. 즉, 가로 세로 경사로는 겹쳐도 상관없다. -> 시간 다 잡아먹은 이유 2
 */
public class BJ_14890_경사로 {
    static int n, l;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n + 4][n + 4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (row(i)) {
                ret++;
            }
            if (col(i)) {
                ret++;
            }
        }

        System.out.println(new StringBuilder().append(ret));
    }

    static boolean row(int y) {
        visited = new boolean[n + 4];
        for (int x = 0; x < n - 1; x++) {
            if (map[y][x] == map[y][x + 1]) {
                continue;
            } else if (map[y][x] + 1 == map[y][x + 1]) {
                if (x - l + 1 < 0) return false; // 범위 벗어나면
                for (int i = x - l + 1; i < x + 1; i++) { // l개의 칸에 경사로를 설치할 수 있는 지
                    if (map[y][x] != map[y][i]) return false;
                    if (visited[i]) return false;
                    visited[i] = true; // 경사로 설치
                }
            } else if (map[y][x] - 1 == map[y][x + 1]) {
                if (x + l >= n) return false;
                for (int i = x + 1; i < x + l + 1; i++) {
                    if (map[y][x + 1] != map[y][i]) return false;
                    if (visited[i]) return false;
                    visited[i] = true;
                }
            } else {
                return false; // 높이 차가 1보다 크다
            }
        }
        return true; // 해당 행은 정상적인 길이 될 수 있다.
    }

    static boolean col(int x) {
        visited = new boolean[n + 4];
        for (int y = 0; y < n - 1; y++) {
            if (map[y][x] == map[y + 1][x]) {
                continue;
            } else if (map[y][x] + 1 == map[y + 1][x]) {
                if (y - l + 1 < 0) return false;
                for (int i = y - l + 1; i < y + 1; i++) {
                    if (map[y][x] != map[i][x]) return false;
                    if (visited[i]) return false;
                    visited[i] = true;
                }
            } else if (map[y][x] - 1 == map[y + 1][x]) {
                if (y + l >= n) return false;
                for (int i = y + 1; i < y + l + 1; i++) {
                    if (map[y + 1][x] != map[i][x]) return false;
                    if (visited[i]) return false;
                    visited[i] = true;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}