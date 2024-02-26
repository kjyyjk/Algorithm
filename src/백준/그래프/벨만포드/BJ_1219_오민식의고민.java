package 백준.그래프.벨만포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1219_오민식의고민 {

    static long[] mMoney;
    static int[] cMoney;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        mMoney = new long[n];
        cMoney = new int[n];
        edges = new Edge[m];

        Arrays.fill(mMoney, Integer.MIN_VALUE);

        int i, u, v, w;
        for (i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(u, v, w);
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (i=0; i<n; i++) {
            cMoney[i] = Integer.parseInt(st.nextToken());
        }

        mMoney[s] = cMoney[s];

        int j;
        Edge nowEdge;
        for (i=0; i<n+100; i++) { //n의 최댓값인 100만큼 더 반복하여 양수사이클에 관련된 노드 검출
            for (j=0; j<m; j++) {
                nowEdge = edges[j];

                if (mMoney[nowEdge.u] == Integer.MAX_VALUE) { //v도 양수사이클에 관련
                    mMoney[nowEdge.v] = Integer.MAX_VALUE;
                } else if (mMoney[nowEdge.u] != Integer.MIN_VALUE &&
                    mMoney[nowEdge.u] - nowEdge.w + cMoney[nowEdge.v] > mMoney[nowEdge.v]) {

                    mMoney[nowEdge.v] = mMoney[nowEdge.u] - nowEdge.w + cMoney[nowEdge.v];

                    if (i > n-1) { //양수 사이클
                        mMoney[nowEdge.v] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (mMoney[e] == Integer.MIN_VALUE) {
            System.out.println(sb.append("gg"));
        } else if (mMoney[e] == Integer.MAX_VALUE) {
            System.out.println(sb.append("Gee"));
        } else {
            System.out.println(sb.append(mMoney[e]));
        }
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
