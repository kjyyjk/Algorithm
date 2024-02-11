package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_18352_특정거리의도시찾기 {

    static ArrayList<Integer>[] arr;
    static Integer[] visited;
    static int cnt;
    static Queue<Integer> result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        visited = new Integer[n+1];

        int i;
        for (i=1; i<n+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (i=1; i<n+1; i++) {
            visited[i] = -1;
        }

        int a, b;
        for (i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
        }

        bfs(k, x);

        cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (i=1; i<n+1; i++) { // 최소거리가 k인 도시 오름차순으로
            if (visited[i] == k) {
                sb.append(i).append('\n');
                cnt++;
            }
        }

        if (cnt == 0) { // 조건에 만족하는 도시가 없으면
            sb.append(-1);
        }

        System.out.println(sb);

    }

    static void bfs(int k, int x) {

        Queue<Integer> queue = new LinkedList();
        queue.add(x);
        visited[x] = 0;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            if (visited[nowNode] == k) { //현재 노드의 최소거리가 k이면 인접노드 체크 안하고 다음 노드로
                continue;
            }

            for (int nextNode : arr[nowNode]) {
                if (visited[nextNode] == -1) {
                    queue.add(nextNode);
                    visited[nextNode] = visited[nowNode]+1;
                }
            }
        }
    }
}
