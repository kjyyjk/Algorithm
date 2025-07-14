package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "front":
                    Integer first = queue.peekFirst();
                    if (first == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(first).append('\n');
                    }
                    break;
                case "back":
                    Integer back = queue.peekLast();
                    if (back == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(back).append('\n');
                    }
                    break;
                case "pop":
                    Integer pop = queue.pollFirst();
                    if (pop == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(pop).append('\n');
                    }
                    break;
                case "push":
                    int addNum = Integer.parseInt(st.nextToken());
                    queue.offerLast(addNum);
                    break;
            }
        }
        System.out.println(sb);
    }
}
