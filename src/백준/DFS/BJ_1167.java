package 백준.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1167 {

    static ArrayList<Edge>[] arr;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {

        int v, i, e, value, max;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        v = Integer.parseInt(br.readLine());

        arr = new ArrayList[v+1];
        visited = new boolean[v+1];
        distance = new int[v+1];

        for(i=1; i<v+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for(i=1; i<v+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());

            while(true) {
                e = Integer.parseInt(st.nextToken());
                if(e==-1) {
                    break;
                }
                value = Integer.parseInt(st.nextToken());

                arr[s].add(new Edge(e, value));
            }
        }

        bfs(1);
        max = 1; //가장 큰 distance의 인덱스
        for(i=2; i<v+1; i++) {
            if(distance[i] > distance[max]) {
                max = i;
            }
        }
        distance = new int[v+1];
        visited = new boolean[v+1];
        bfs(max);
        Arrays.sort(distance);
        System.out.println(new StringBuilder().append(distance[v]));

    }

    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            int nowNode = queue.poll();
            for(Edge edge : arr[nowNode]) {
                if(visited[edge.e] == false) {
                    visited[edge.e] = true;
                    queue.add(edge.e);
                    distance[edge.e] = distance[nowNode] + edge.value;
                }
            }

        }
    }

    static class Edge {
        int e;
        int value;

        public Edge(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }

}
