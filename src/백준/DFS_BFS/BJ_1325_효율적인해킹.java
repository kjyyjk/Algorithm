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
    static int n;

    public static void main(String[] args) throws IOException {

        int i, a, b, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

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

        Queue<Integer> queue;
        for (i=1; i<n+1; i++) { // bfs를 메서드로 따로 뽑지 않고 안에서 구현해야 시간복잡도 더 줄음
            queue = new LinkedList();
            visited = new boolean[n+1];
            visited[i] = true;
            queue.add(i);

            while (!queue.isEmpty()) {
                int nowNode = queue.poll();

                for (int nextNode : arr[nowNode]) {
                    if (!visited[nextNode]) {
                        visited[nextNode] = true;
                        resultArr[nextNode]++;
                        queue.add(nextNode);
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
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


}
