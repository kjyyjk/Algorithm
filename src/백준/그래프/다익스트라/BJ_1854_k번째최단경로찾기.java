package 백준.그래프.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1854_k번째최단경로찾기 {

    static ArrayList<Node>[] arr;
    static PriorityQueue<Integer>[] distance;
    static int k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        distance = new PriorityQueue[n+1];
        arr = new ArrayList[n+1];

        int i;
        for (i=1; i<n+1; i++) {
            arr[i] = new ArrayList<>();
            distance[i] = new PriorityQueue<>(k, new Comparator<Integer>() { //큰 수가 앞으로
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }

        int a, b, c;
        for (i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            arr[a].add(new Node(b, c));
        }

        dijkstra();

        StringBuilder sb = new StringBuilder();
        int kNum;
        for (i=1; i<n+1; i++) {
            if (distance[i].size() < k) {
                kNum = -1;
            } else {
                kNum = distance[i].peek();
            }

            sb.append(kNum).append('\n');
        }

        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        }); //큐의 모든 노드 고려하므로 우선순위 필요하지는 않으나, 더 작은 값을 먼저 고려해 탐색 횟수를 줄이기 위해
        queue.add(new Node(1, 0));
        distance[1].add(0);

        Node nowNode;
        while (!queue.isEmpty()) {
            nowNode = queue.poll();

            int temp;
            for (Node nextNode : arr[nowNode.node]) {

                temp = nowNode.cost + nextNode.cost;

                if (distance[nextNode.node].size() < k) {
                    distance[nextNode.node].add(temp);
                    queue.add(new Node(nextNode.node, temp));
                } else {
                    if (distance[nextNode.node].peek() > temp) {
                        distance[nextNode.node].poll();
                        distance[nextNode.node].add(temp);
                        queue.add(new Node(nextNode.node, temp));
                    }
                }
            }
        }
    }

    static class Node {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}