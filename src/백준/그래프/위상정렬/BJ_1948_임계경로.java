package 백준.그래프.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1948_임계경로 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] inDegree = new int[n+1];
        int[] result = new int[n+1];
        boolean[] visited = new boolean[n+1]; //역방향 시 사용하는 방문체크
        ArrayList<Node>[] arr = new ArrayList[n+1];
        ArrayList<Node>[] reverseArr = new ArrayList[n+1]; //역방향 인접리스트

        for (int i=1; i<n+1; i++) {
            arr[i] = new ArrayList<>();
            reverseArr[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int a, b, c;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            arr[a].add(new Node(b, c));
            reverseArr[b].add(new Node(a, c));

            inDegree[b]++;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(s, 0));

        Node nowNode;
        while (!queue.isEmpty()) { //순방향 위상정렬
            nowNode = queue.poll();

            for (Node nextNode : arr[nowNode.num]) {
                if (result[nowNode.num] + nextNode.value > result[nextNode.num]) { //임계경로값 갱신
                    result[nextNode.num] = result[nowNode.num] + nextNode.value;
                }

                if (--inDegree[nextNode.num] == 0) {
                    queue.add(nextNode);
                }
            }
        }

        int cnt = 0;
        queue.add(new Node(e, 0));

        while (!queue.isEmpty()) {
            nowNode = queue.poll();

            for (Node nextNode : reverseArr[nowNode.num]) {
                if (result[nowNode.num] == result[nextNode.num] + nextNode.value) { //임계경로이면
                    cnt++;

                    if (visited[nextNode.num] == false) { //방문노드를 체크해 임계경로 중복체크 방지
                        queue.add(nextNode);
                        visited[nextNode.num] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result[e]).append('\n').append(cnt);

        System.out.println(sb);
    }

    static class Node {
        int num;
        int value;

        public Node(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }

}
