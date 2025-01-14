package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 비트마스킹으로 하면 혼쭐나는 문제. -> 시간 잡아먹은 이유 1
 * n의 범위가 30을 넘어 100까지 간다.
 * 따라서 비트마스킹으로 경사로 상태를 저장하는 것은 불가하다.
 *
 * 만약 다음 칸이 현재 칸보다 1칸 높으면 현재 칸을 기준으로 l개의 칸에 경사로를 설치할 수 있는 지 확인하고 경사로를 설치한다.
 * 만약 다음 칸이 현재 칸보다 1칸 낮으면 다음 칸을 기준으로 l개의 칸에 경사로를 설치할 수 있는 지 확인하고 경사로를 설치한다. 
 * 만약 다음 칸과 현재 칸의 높이 차가 1보다 크면 해당 열 또는 행은 길이 될 수 없다.
 *
 * 위 로직을 행과 열에 맞게 두개로 만들 수 있다. 하지만 중복도 많고 헷갈린다.
 * 이때 주어진 행렬을 전치시키면 하나의 로직을 행열 모두에 적용할 수 있다.
 * 1 2 3    1 4 7
 * 4 5 6 -> 2 5 8
 * 7 8 9    3 6 9
 * 이러면 행에 대한 로직을 열에 적용한 것과 같다.
 *
 * 추가로 가로 길과 세로 길은 서로 독립적이다. 즉, 가로 세로 경사로는 겹쳐도 상관없다. -> 시간 다 잡아먹은 이유 2
 */
public class BJ_14890_경사로 {
    static int n, l;
    static int[][] map1, map2;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map1 = new int[n + 4][n + 4];
        map2 = new int[n + 4][n + 4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map1[i][j] = temp;
                map2[j][i] = temp;
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (check(map1, i)) {
                ret++;
            }
            if (check(map2, i)) {
                ret++;
            }
        }
        System.out.println(new StringBuilder().append(ret));
    }

    static boolean check(int[][] map, int y) {
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
}