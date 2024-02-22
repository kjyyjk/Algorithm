package 백준.그래프.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1753_최단경로 {

    static ArrayList<Edge>[] arr;
    static boolean[] visited;
    static int[] distance;
    static Queue<Edge> queue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int i;
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        arr = new ArrayList[v+1];
        visited = new boolean[v+1];
        distance = new int[v+1];

        for (i=1; i<v+1; i++) {
            arr[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        int a, b, w;
        for (i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            arr[a].add(new Edge(b,w));
        }

        queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.value - o2.value;
            }
        });

        distance[k] = 0;
        queue.add(new Edge(k, 0));

        Edge now;
        while (!queue.isEmpty()) {
            now = queue.poll();

            if (visited[now.vertex]) {
                continue;
            }
            visited[now.vertex] = true;

            for (Edge next : arr[now.vertex]) {
                if (visited[next.vertex]) {
                    continue;
                }

                if (distance[next.vertex] > distance[now.vertex] + next.value) {
                    distance[next.vertex] = distance[now.vertex] + next.value;
                    queue.add(new Edge(next.vertex, distance[next.vertex]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (i=1; i<v+1; i++) {
            if (visited[i]) {
                sb.append(distance[i]).append('\n');
            } else {
                sb.append("INF\n");
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
