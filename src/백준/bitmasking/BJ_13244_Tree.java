package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 트리의 모든 노드가 연결되어있어야하고, 사이클이 존재해서는 안된다.
 * 만약 트리에 사이클이 존재한다면 트리의 특성 중 하나인 V - 1 = E 특성이 깨지게 된다.
 * 따라서 N - 1 = M이 성립하는 지를 확인해 사이클 존재 여부를 확인한다.
 * 모든 노드 연결 여부는 1번 노드에서의 트리 탐색이 끝난 뒤 모든 노드가 방문되었는 지를 체크한다.
 */
public class BJ_13244_Tree {
    static List<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n, m, a, b;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int k = 0; k < t; k++) {
            n = Integer.parseInt(br.readLine());
            tree = new List[n + 4];
            for (int i = 1; i < n + 1; i++) {
                tree[i] = new ArrayList<>();
            }
            visited = new boolean[n + 4];
            m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                tree[a].add(b);
                tree[b].add(a);
            }
            go(1);
            boolean flag = true;
            for (int i = 1; i < n + 1; i++) { // 모든 노드 연결 확인
                if (!visited[i]) {
                    flag = false;
                }
            }
            if (flag && (n - 1 == m)) {
                sb.append("tree").append('\n');
            } else {
                sb.append("graph").append('\n');
            }
        }
        System.out.println(sb);
    }

    static void go(int here) {
        visited[here] = true;
        for (int there : tree[here]) {
            if (visited[there]) continue;
            go(there);
        }
    }
}
