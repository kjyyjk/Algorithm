package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2164 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int i;

        Queue<Integer> queue = new LinkedList<>();

        for(i=1; i<n+1; i++) {
            queue.add(i);
        }

        for(i=0; i<n-1; i++) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(new StringBuilder().append(queue.peek()));
    }
}
