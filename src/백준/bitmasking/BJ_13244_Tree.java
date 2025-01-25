package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 사이클 존재 여부와 모든 노드가 연결되어있는 지를 확인해야한다.
 *
 * 사이클 존재 여부 확인을 위해 탐색 시 직전 노드(pre)를 인자로 보관한다.
 * 만약 다음 탐색할 노드(there)가 직전 노드(pre)가 아닌데도 이미 방문한 상태라면 사이클이 존재하는 것이다.
 *
 * 모든 노드 연결 여부는 1번 노드에서의 트리 탐색이 끝난 뒤 모든 노드가 방문되었는 지를 체크한다.
 *
 * 만약 flag가 true이면 사이클이 존재하지 않고 모든 노드가 연결된 tree이며,
 * false이면 사이클이 존재하거나 모든 노드가 연결되지 않은 graph이다.
 */
public class BJ_13244_Tree {
    static List<Integer>[] tree;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n, m, a, b;
        StringBuilder sb = new StringBuilder();
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
            flag = true;
            go(0, 1);
            for (int i = 1; i < n + 1; i++) { // 모든 노드 연결 확인
                if (!visited[i]) {
                    flag = false;
                }
            }
            if (flag) {
                sb.append("tree").append('\n');
            } else {
                sb.append("graph").append('\n');
            }
        }
        System.out.println(sb);
    }

    static void go(int pre, int here) {
        visited[here] = true;
        for (int there : tree[here]) {
            if (pre == there) { // 직전 노드이면 그냥 방문하지 않는다.
                continue;
            }
            if (visited[there]) { // 직전 노드가 아닌데도 이미 방문한 상태이면 사이클이 존재하는 것이다.
                flag = false;
                return;
            }
            go(here, there);
        }
    }
}
