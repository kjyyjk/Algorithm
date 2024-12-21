package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 수빈이가 동생과 만나는 것은
 * 1. 동시에 같은 정점에 모이거나
 * 2. 수빈이가 이미 방문한 정점을 이후에 동생이 방문한 경우. 단, 수빈이와 동생의 방문 시점이 홀-홀 이거나 짝-짝으로 일치해야한다.
 * 그래야 수빈이가 동생이 방문할 때까지 +1, -1로 제자리 대기를 할 수 있기 때문이다.
 *
 * 공간 복잡도를 줄이기 위해 2차원 배열 선언. 첫번째 0은 짝수 시간, 1은 홀수 시간을 의미.
 * bfs를 하며 만약 동생이 수빈이가 방문했던 정점에 도착하고 두 도착 시간의 짝홀이 일치하면 동생이 도착한 시간이 최소 시간.
 * q=queue.size로 각 turn(시간) 구분
 */
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