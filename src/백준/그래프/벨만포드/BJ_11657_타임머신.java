package 백준.그래프.벨만포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11657_타임머신 {

    static long[] distance;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        distance = new long[n+1];
        edges = new Edge[m];

        int i;
        for (i=1; i<n+1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        int u,v,w;
        for (i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(u, v, w);
        }

        distance[1] = 0;

        Edge nowEdge;
        for (i=1; i<n; i++) {
            for (int j=0; j<m; j++) {
                nowEdge = edges[j];

                if (distance[nowEdge.u] != Integer.MAX_VALUE && distance[nowEdge.v] > distance[nowEdge.u] + nowEdge.w) {
                    distance[nowEdge.v] = distance[nowEdge.u] + nowEdge.w;
                }
            }
        }

        boolean cycle = false;
        for (i=0; i<m; i++) {
            nowEdge = edges[i];
            if (distance[nowEdge.u] != Integer.MAX_VALUE && distance[nowEdge.v] > distance[nowEdge.u] + nowEdge.w) {
                cycle = true; //음수 사이클 존재
            }
        }

        StringBuilder sb = new StringBuilder();
        if (cycle) {
            sb.append(-1);
        } else {
            for (i=2; i<n+1; i++) {
                if (distance[i] != Integer.MAX_VALUE) {
                    sb.append(distance[i]).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }
            }
        }

        System.out.println(sb);
    }

    static class Edge {
        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
