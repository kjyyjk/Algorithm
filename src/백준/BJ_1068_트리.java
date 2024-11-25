package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 루트부터 dfs 탐색을 시작한다.
 * dfs는 리프 노드의 개수를 반환한다.
 * 만약 현재 탐색중인 here 노드의 자식인 there이 제거 노드이면 방문하지 않는다.
 * here의 리프노드 개수는 모든 자식 노드 리프노드 개수를 합한 값이다.
 * 만약 here의 자식 노드가 존재하지 않으면 1을 반환한다.
 * 만약 루트 노드가 제거 대상이면 0을 출력한다.
 */
public class BJ_1068_트리 {
    static List<Integer>[] adj;
    static int n;
    static int r;
    static int root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        adj = new List[n+4];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
                continue;
            }
            adj[parent].add(i);
        }

        r = Integer.parseInt(br.readLine());

        int ret = dfs(root);
        if (r == root) {
            ret = 0;
        }
        System.out.println(new StringBuilder().append(ret));
    }

    static int dfs(int here) {
        int ret, child;
        child = 0;
        ret = 0;
        for (int there : adj[here]) {
            if (there == r) {
                continue;
            }
            ret += dfs(there);
            child++;
        }

        if (child == 0) {
            return 1;
        }
        return ret;
    }
}
