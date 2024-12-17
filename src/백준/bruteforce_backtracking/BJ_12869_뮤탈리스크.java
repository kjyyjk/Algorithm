package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 모든 scv의 체력이 0 이하가 되는 최단 거리 -> bfs
 * 각 scv의 체력을 x y z 좌표로 하여 bfs를 진행한다.
 * 공격 순서에 따른 데미지가 다르므로 데미지를 dxyz 같이 사용한다.
 * 만약 nx, ny, nz가 모두 0이 된다면. 그때의 visited - 1(1에서 시작하므로)이 곧 최소 공격 횟수가 된다.
 *
 * 체력이 인덱스로 쓰이기 때문에 음수는 0으로 바꿔주는 작업이 필요하다.
 */
public class BJ_12869_뮤탈리스크 {
    static int[][] damage = {{9, 3, 1}, {9, 1, 3}, {1, 3, 9}, {1, 9, 3}, {3, 1, 9}, {3, 9, 1}};
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] abc = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            abc[i] = Integer.parseInt(st.nextToken());
        }

        visited = new int[61][61][61];

        int sa = abc[0];
        int sb = abc[1];
        int sc = abc[2];
        visited[sa][sb][sc] = 1;
        int ret = bfs(sa, sb, sc);
        System.out.println(new StringBuilder().append(ret));
    }

    private static int bfs(int sa, int sb, int sc) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sa, sb, sc});
        while (!queue.isEmpty()) {
            int[] abc = queue.poll();
            int a = abc[0];
            int b = abc[1];
            int c = abc[2];
            for (int i = 0; i < 6; i++) {
                int na = Math.max(a - damage[i][0], 0);
                int nb = Math.max(b - damage[i][1], 0);
                int nc = Math.max(c - damage[i][2], 0);
                if (visited[na][nb][nc] != 0) continue;
                visited[na][nb][nc] = visited[a][b][c] + 1;
                queue.add(new int[]{na, nb, nc});
                if (na == 0 && nb == 0 && nc == 0) {
                    return visited[na][nb][nc] - 1;
                }
            }
        }

        return visited[0][0][0];
    }
}
