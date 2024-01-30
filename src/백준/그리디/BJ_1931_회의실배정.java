package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1931_회의실배정 {

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Node> pQ = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.e > o2.e) {
                    return 1;
                } else if (o1.e < o2.e) {
                    return -1;
                } else {
                    return o1.s - o2.s;
                }
            }
        });

        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            pQ.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Node nowNode;
        int cnt = 0;
        int end = 0;

        while(!pQ.isEmpty()) {
            nowNode = pQ.poll();
            if(nowNode.s >= end) {
                cnt++;
                end = nowNode.e;
            }
        }

        System.out.println(new StringBuilder().append(cnt));
    }

    static class Node{
        int s;
        int e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

}
