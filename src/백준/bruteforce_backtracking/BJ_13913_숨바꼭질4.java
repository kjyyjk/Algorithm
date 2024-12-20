package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 최소 비용 -> bfs
 * 방문 경로 -> prev 배열에 이전 정점 보관
 *
 * bfs이기 때문에 한번 방문한 시점에 최소 비용이 저장된다. 방문한 정점을 다시 방문하지 않으니 변경되지 않음.
 * 만약 방문한 적이 없다면 방문 처리(비용 저장)
 * 해당 정점의 이전 정점을 현재 정점으로 설정(prev[next] = now)
 * 
 * bfs가 끝나면 k부터 이전 정점으로 역으로 탐색한다
 */
public class BJ_13913_숨바꼭질4 {
    static int n, k;
    static int[] visited =  new int[200004];
    static int[] prev =  new int[200004];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next < 0 || next > 200000) continue;
                if (visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    prev[next] = now;
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(visited[k] - 1).append('\n');

        List<Integer> root = new ArrayList<>();
        for (int i = k; i != n; i = prev[i]) {
            root.add(i);
        }
        root.add(n);

        Collections.reverse(root);
        for (int i = 0; i < root.size(); i++) {
            sb.append(root.get(i)).append(' ');
        }

        System.out.println(sb);
    }
}