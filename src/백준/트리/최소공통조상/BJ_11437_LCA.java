package 백준.트리.최소공통조상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_11437_LCA {

    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] parent;
    static int[] depth;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        parent = new int[n + 1];
        depth = new int[n + 1];

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

        //루트 노드 처리
        parent[1] = 0;
        depth[1] = 0;

        bfs(1);

        int m = Integer.parseInt(br.readLine());

        for (i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            lca(a, b);
        }

        System.out.println(result);
    }

    static void bfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        visited[root] = true;
        queue.add(root);

        int nowNode;
        while (!queue.isEmpty()) {
            nowNode = queue.poll();

            for (int nextNode : tree[nowNode]) {
                if (visited[nextNode] == false) {
                    parent[nextNode] = nowNode;
                    depth[nextNode] = depth[nowNode] + 1;
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
    }

    static void lca(int a, int b) {
        if (depth[a] < depth[b]) { //무조건 a가 더 깊게끔 설정
            int temp = b;
            b = a;
            a = temp;
        }

        while (depth[a] != depth[b]) {
            a = parent[a];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        result.append(a).append('\n');
    }
}
