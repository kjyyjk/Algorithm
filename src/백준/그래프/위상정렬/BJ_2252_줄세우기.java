package 백준.그래프.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2252_줄세우기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] inDegree = new int[n+1];

        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for (int i=1; i<n+1; i++) {
            arr[i] = new ArrayList<>();
        }

        int a, b;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            inDegree[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i=1; i<n+1; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int nowNode;
        while (!queue.isEmpty()) {
            nowNode = queue.poll();
            sb.append(nowNode).append(' ');

            for (int nextNode : arr[nowNode]) {
                if (--inDegree[nextNode] == 0) {
                    queue.add(nextNode);
                }
            }
        }

        System.out.println(sb);


    }

}
