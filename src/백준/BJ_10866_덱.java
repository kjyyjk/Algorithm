package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_10866_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dequeue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "size":
                    sb.append(dequeue.size()).append('\n');
                    break;
                case "empty":
                    if (dequeue.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "front":
                    Integer first = dequeue.peekFirst();
                    if (first == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(first).append('\n');
                    }
                    break;
                case "back":
                    Integer back = dequeue.peekLast();
                    if (back == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(back).append('\n');
                    }
                    break;
                case "pop_front":
                    Integer popFirst = dequeue.pollFirst();
                    if (popFirst == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(popFirst).append('\n');
                    }
                    break;
                case "pop_back":
                    Integer popBack = dequeue.pollLast();
                    if (popBack == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(popBack).append('\n');
                    }
                    break;
                case "push_front":
                    dequeue.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dequeue.offerLast(Integer.parseInt(st.nextToken()));
                    break;
            }
        }
        System.out.println(sb);
    }
}
