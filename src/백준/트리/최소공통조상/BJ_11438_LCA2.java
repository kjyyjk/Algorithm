package 백준.트리.최소공통조상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_11438_LCA2 {

    static int kMax;
    static ArrayList<Integer>[] tree;
    static int[][] parent;
    static int[] depth;
    static boolean[] visited;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        depth = new int[n + 1];
        visited = new boolean[n + 1];

        StringTokenizer st;
        int i;
        for (i=1; i<n+1; i++) {
            tree[i] = new ArrayList<>();
        }

        int a, b;
        for (i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        int temp = 1;
        kMax = 0;
        while (temp<=n) { //n은 노드의 개수이자 최대 높이 n-1
            temp = temp << 1; //temp는 최대 높이 보다 작은 2의 거듭 제곱 중 가장 큰 값
            kMax++; 
        } //결국 2^(kmax+1) 위에 있는 부모는 이 트리에 존재 x. kmax가 최대.

        parent = new int[kMax][n + 1];

        bfs(1);

        for (int k=1; k< kMax; k++) { //2^k 위 부모 값 채우기
            for (int j=1; j<n+1; j++) {
                parent[k][j] = parent[k-1][parent[k-1][j]];
            }
        }

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
        depth[root] = 0;
        queue.add(root);

        int nowNode;
        while (!queue.isEmpty()) {
            nowNode = queue.poll();

            for (int nextNode : tree[nowNode]) {
                if (visited[nextNode] == false) {
                    parent[0][nextNode] = nowNode;
                    depth[nextNode] = depth[nowNode] + 1;
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
    }

    static void lca(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int k= kMax -1; k>=0; k--) { //깊이 맞추기
            if (Math.pow(2, k) <= depth[b] - depth[a]) {
                b = parent[k][b];
            }
        }

        for (int k= kMax -1; k>=0; k--) { //a와 b의 2 거듭제곱 부모 중 처음으로 달라질 때로 이동
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        if (a != b) { //둘이 다르면 한칸 더 부모로 이동
            a = parent[0][a];
        }
        
        //이제 a는 a와 b의 최소 공통 조상에 위치하게 됨
        result.append(a).append('\n');
    }

}
