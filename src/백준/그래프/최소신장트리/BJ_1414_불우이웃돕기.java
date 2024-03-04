package 백준.그래프.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_1414_불우이웃돕기 {

    static int[] parent;
    static PriorityQueue<Edge> edges;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int i;
        parent = new int[n];
        for (i=0; i<n; i++) {
            parent[i] = i;
        }

        edges = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.value - o2.value;
            }
        });

        String temp;
        int j, length;
        int totalLength = 0;
        char tempChar;
        for (i=0; i<n; i++) {
            temp = br.readLine();
            for (j=0; j<n; j++) {
                tempChar = temp.charAt(j);

                if (tempChar != '0') {
                    if (tempChar <= 'z' && tempChar >= 'a') {
                        length = tempChar - 96;
                    } else {
                        length = tempChar - 38;
                    }

                    totalLength += length;

                    if (i!=j) {
                        edges.add(new Edge(i, j, length));
                    }
                }
            }
        }

        int useEdge = 0;
        int mstLength = 0;
        Edge nowEdge;
        while (useEdge < n - 1 && !edges.isEmpty()) {
            nowEdge = edges.poll();

            if (find(nowEdge.a) != find(nowEdge.b)) {
                union(nowEdge.a, nowEdge.b);
                mstLength += nowEdge.value;
                useEdge++;
            }
        }

        if (useEdge != n-1) {
            System.out.println(new StringBuilder().append(-1));
        } else {
            System.out.println(new StringBuilder().append(totalLength - mstLength));
        }
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

        if (a != b) {
            parent[b] = a;
        }
    }

    static class Edge {
        int a;
        int b;
        int value;

        public Edge(int a, int b, int value) {
            this.a = a;
            this.b = b;
            this.value = value;
        }
    }

}
