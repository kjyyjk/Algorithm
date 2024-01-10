package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_11286 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int i;
        long inputNum;

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) { //반환값이 음수이면 o1이 o2보다 앞서고(o1,o2순서), 양수이면 o2가 o1보다 앞선다(o2,o1순서).
                if(Math.abs(o1) > Math.abs(o2)) {
                    return 1;
                } else if(Math.abs(o1) < Math.abs(o2)) {
                    return -1;
                } else {
                    return (int) (o1 - o2);
                    /*
                    if(o1 > o2) {
                        return 1;
                    } else if(o1 < o2) {
                        return -1;
                    } else {
                        return 0;
                    }*/
                }
            }
        });

        for(i=0; i<n; i++) {
            inputNum = Long.parseLong(br.readLine());

            if(inputNum == 0 && !priorityQueue.isEmpty()) {
                sb.append(priorityQueue.poll()).append('\n');
            } else if (inputNum==0) {
                sb.append(0).append('\n');
            } else {
                priorityQueue.add(inputNum);
            }
        }

        System.out.println(sb);
    }
}
