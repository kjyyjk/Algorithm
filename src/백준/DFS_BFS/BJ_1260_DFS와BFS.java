package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static StringBuilder dfsResult;
    static StringBuilder bfsResult;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a, b;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        visited = new boolean[n+1];
        dfsResult = new StringBuilder();
        bfsResult = new StringBuilder();

        for (int i=0; i<n+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        for(ArrayList<Integer> array : arr) {
            Collections.sort(array);
        }

        dfs(v);
        visited = new boolean[n+1];
        bfs(v);

        System.out.println(dfsResult + "\n" + bfsResult);
    }

    static void dfs(int k) {
        visited[k] = true;
        dfsResult.append(k).append(' ');

        for (int i : arr[k]) {
            if(visited[i] == false) {
                dfs(i);
            }
        }
    }

    static void bfs(int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        visited[k] = true;

        while(!queue.isEmpty()) {
            int nowNode = queue.poll();
            bfsResult.append(nowNode).append(' ');
            for(int i : arr[nowNode]) {
                if(visited[i] == false) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
