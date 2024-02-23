package 백준.그래프.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1916_최소비용구하기 {

    static ArrayList<Edge>[] arr;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        arr = new ArrayList[n+1];
        distance = new int[n+1];
        visited = new boolean[n+1];

        int i;
        for (i=1; i<n+1; i++) {
            arr[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        int a, b, v;
        for (i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            arr[a].add(new Edge(b, v));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        Queue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.value - o2.value;
            }
        });
        distance[s] = 0;
        queue.add(new Edge(s, 0));

        StringBuilder sb = new StringBuilder();
        Edge now;
        while (!queue.isEmpty()) {
            now = queue.poll();

            if (visited[now.vertex]) {
                continue;
            }
            visited[now.vertex] = true;

            if (now.vertex == e) {
                sb.append(now.value);
            }

            for (Edge next : arr[now.vertex]) {
                if (visited[next.vertex]) {
                    continue;
                } else {
                    if (distance[next.vertex] > distance[now.vertex] + next.value) {
                        distance[next.vertex]  = distance[now.vertex] + next.value;
                        queue.add(new Edge(next.vertex, distance[next.vertex]));
                    }
                }
            }
        }

        System.out.println(sb);
    }

    static class Edge {
        int vertex;
        int value;

        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }
    }

}
