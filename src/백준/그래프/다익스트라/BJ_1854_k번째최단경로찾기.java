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
                kNum = distance[i].peek(); //k번째 비용 출력 (우선순위큐의 사이즈를 k로 유지했기에 peek)
            }

            sb.append(kNum).append('\n');
        }

        System.out.println(sb);
    }

    static void dijkstra() {
        //최대한 모든 노드 고려하므로 우선순위큐가 필요하지는 않으나 우선순위 큐를 통해 비용이 경로를 먼저 고려하면
        //갱신 수도 줄고, 본 queue에 저장하여 또 다른 경로를 탐색할 일이 조금이라도 줄어든다
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });
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
                } else { //k개 이상이면, k번째 작은 값과 비교해 더 작은 값으로 갱신
                    if (distance[nextNode.node].peek() > temp) {
                        distance[nextNode.node].poll();
                        distance[nextNode.node].add(temp);
                        //갱신했을 때에만 큐에 추가. 무한반복방지.
                        //갱신 안했을 때 추가하더라도 이 경로로 탐색하는 다른 경로도 결국 k번째 밖에 들기에 추가 x
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