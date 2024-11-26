package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1325_효율적인해킹 {
    static boolean[] visited;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new List[n+4];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[b].add(a);
        }

        int ret = 0;
        int cnt;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+4];
            visited[i] = true;
            cnt = dfs(i);
            if (ret == cnt) {
                result.add(i);
            } else if (ret < cnt) {
                result.clear();
                result.add(i);
                ret = cnt;
            }
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }

    static int dfs(int here) {
        int ret = 1;
        for (int there : adj[here]) {
            if (visited[there]) continue;
            visited[there] = true;
            ret += dfs(there);
        }
        return ret;
    }
}
