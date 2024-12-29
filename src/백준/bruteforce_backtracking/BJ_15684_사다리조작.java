package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15684_사다리조작 {
    static int n, h;
    static boolean[][] map;

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

        StringBuilder sb = new StringBuilder();
        int ret = dfs(0);
        if (ret > 3) {
            sb.append(-1);
        } else {
            sb.append(ret);
        }
        System.out.println(sb);
    }

    static int dfs(int level) {
        if (solve() || level > 3) return level;
        int ret = Integer.MAX_VALUE;
        for (int i = 1; i < h + 1; i++) {
            for (int j = 1; j < n; j++) { //5는 가로선 추가 x
                if (map[i][j]) continue;
                if (j != 1 && map[i][j-1]) continue;
                if (j != 5 && map[i][j+1]) continue;
                map[i][j] = true;
                int temp = dfs(level + 1);
                ret = Math.min(ret, temp);
                map[i][j] = false;
            }
        }

        return ret;
    }

    static boolean solve() {
        boolean flag = true;
        for (int i = 1; i < n + 1; i++) {
            if (!flag) break;

            int temp = i;
            for (int j = 1; j < h + 1; j++) {
                if (temp != 1 && map[j][temp - 1]) {
                    temp--;
                } else if (temp != n && map[j][temp]){
                    temp++;
                }
            }
            if (temp != i) {
                flag = false;
            }
        }

        return flag;
    }
}
