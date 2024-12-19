package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 최소 비용 -> bfs
 * 경우의 수 -> 각 정점별로 경우의 수 보관
 *
 * bfs이기 때문에 한번 방문한 시점에 최소 비용이 저장된다. 방문한 정점을 다시 방문하지 않으니 변경되지 않음.
 * 만약 방문한 적이 없다면 경우의 수 증가, 비용 저장
 * 방문한 적이 있다면. 만약 비용이 같은 경우, 즉 같은 최소 비용인데 경로만 다를 경우 방문은 하지 않고 경우의 수만 증가한다
 * 경우의 수 증가시 1씩 증가하는 것이 아닌 총 경우의 수를 증가해야한다.
 * 예를 들어 a까지 경우의 수가 1이었는데, b에서 a로 같은 비용에 갈 수 있고. b까지의 경우의 수가 2였다면
 * a까지 가는 경우의 수는 1 + 2가 된다.
 */
public class BJ_12851_숨바꼭질2 {
    static int[] visited =  new int[100001];
    static int[] cnt =  new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bfs(n); // 모든 정점에 대한 최소 비용과 최소 비용에 대한 경우의 수가 저장된다
        System.out.println(new StringBuilder().append(visited[k] - 1).append('\n').append(cnt[k]));
    }

    static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 1;
        cnt[n] = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next < 0 || next > 100000) continue;
                if (visited[next] == 0) { // 방문한 적 없으면 경우의 수 증가 후 방문
                    visited[next] = visited[now] + 1;
                    cnt[next] += cnt[now];
                    queue.add(next);
                } else { // 방문한 적 있어도 같은 비용이라면 경우의 수 증가, 방문은 하지 않음
                    if (visited[next] == visited[now] + 1) {
                        cnt[next] += cnt[now];
                    }
                }
            }
        }
    }
}
