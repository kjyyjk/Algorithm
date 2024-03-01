package 백준.그래프.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1197_최소스패닝트리 {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v+1];

        int i;
        for (i=1; i<v+1; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> edges = new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.c - o2.c;
            }
        });

        int a, b, c;
        for (i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, c));
        }

        int edgeCnt=0;
        int result = 0;
        Edge nowEdge;
        while (edgeCnt < v-1) {
            nowEdge = edges.poll();

            if (find(nowEdge.a) != find(nowEdge.b)) {
                union(nowEdge.a, nowEdge.b);
                edgeCnt++;
                result += nowEdge.c;
            }
        }

        System.out.println(new StringBuilder().append(result));
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            int temp = find(parent[a]);
            parent[a] = temp;
            return temp;
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a!=b) {
            parent[b] = a;
        }
    }

    static class Edge {
        int a;
        int b;
        int c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

}
