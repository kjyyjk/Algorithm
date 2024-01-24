package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_11003_최솟값찾기 {

    static class Node {
        long ind;
        long val;

        Node(long ind, long val) {
            this.ind = ind;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int i;
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine(), " ");

        Deque<Node> deque = new LinkedList<>();

        for(i=0; i<n; i++) {
            long temp = Long.parseLong(st.nextToken());

            while(!deque.isEmpty() && deque.getLast().val > temp) {
                deque.removeLast();
            }

            deque.add(new Node(i, temp));

            if(deque.getFirst().ind <= i - l) {
                deque.removeFirst();
            }

            sb.append(deque.getFirst().val).append(" ");
        }

        System.out.println(sb);
        br.close();
    }

}