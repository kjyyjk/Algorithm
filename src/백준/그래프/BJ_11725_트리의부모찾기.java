package 백준.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_11725_트리의부모찾기 {

    static ArrayList<Integer>[] tree;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n+1];
        parent = new int[n+1];
        visited = new boolean[n+1];

        int i;
        for (i=1; i<n+1; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int a, b;
        for (i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (i=2; i<n+1; i++) {
            sb.append(parent[i]).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int nextNode : tree[node]) {
            if (!visited[nextNode]) {
                parent[nextNode] = node;
                dfs(nextNode);
            }
        }
    }

}
