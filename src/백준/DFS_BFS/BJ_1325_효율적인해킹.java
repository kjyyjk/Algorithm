package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1325_효율적인해킹 {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] resultArr;

    public static void main(String[] args) throws IOException {

        int i, a, b;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        resultArr = new int[n+1];

        for (i=1; i<n+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
        }

        for (i=1; i<n+1; i++) {
            visited = new boolean[n+1];
            bfs(i);
        }

        int max = 0;
        for (i=1; i<n+1; i++) {
            max = Math.max(max, resultArr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (i=1; i<n+1; i++) {
            if (resultArr[i] == max) {
                sb.append(i).append(' ');
            }
        }

        System.out.println(sb);
    }

    static void bfs(int n) {
        Queue<Integer> queue = new LinkedList();
        visited[n] = true;
        queue.add(n);

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();

            for (int nextNode : arr[nowNode]) {
                if (visited[nextNode] == false) {
                    visited[nextNode] = true;
                    resultArr[nextNode]++;
                    queue.add(nextNode);
                }
            }
        }
    }
}
