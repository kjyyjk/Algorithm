package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17071_숨바꼭질5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[2][500004];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int turn = 0;
        visited[0][n] = true;
        boolean flag = false;
        while (!queue.isEmpty()) {
            k += turn;
            if (k > 500000) break;
            if (visited[turn % 2][k]) {
                flag = true;
                break;
            }
            int q = queue.size();
            for (int i = 0; i < q; i++) {
                int now = queue.poll();
                if (now == k) {
                    flag = true;
                    break;
                }
                for (int next : new int[]{now - 1, now + 1, now * 2}) {
                    if (next > 500000 || next < 0) continue;
                    if (visited[(turn + 1) % 2][next]) continue;
                    visited[(turn + 1) % 2][next] = true;
                    queue.add(next);
                }
                if (flag) break;
            }
            if (flag) break;
            turn++;
        }

        if (flag) {
            System.out.println(new StringBuilder().append(turn));
        } else {
            System.out.println(new StringBuilder().append(-1));
        }
    }
}