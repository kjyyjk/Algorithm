package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2003_수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int cnt = 0;

        int firstNum = Integer.parseInt(st.nextToken());
        queue.offer(firstNum); // 초기 값 설정
        sum += firstNum;
        while (st.hasMoreTokens()) {
            if (sum == m) { // 같으면 카운트 이후 앞에서 하나 빼기
                cnt++;
                sum -= queue.poll();
            } else if (sum > m) { // 크면 앞에서 하나 빼기
                sum -= queue.poll();
            } else { // 작으면 하나 추가하기
                int num = Integer.parseInt(st.nextToken());
                queue.offer(num);
                sum += num;
            }
        }

        while (!queue.isEmpty()) { // 더는 추가될 수가 없음.
            if (sum == m) { // 같으면 카운트하고 종료
                cnt++;
                break;
            } else if (sum < m) { // 작으면 종료
                break;
            }
            sum -= queue.poll(); // 크면 앞에서 하나 제거
        }
        System.out.println(new StringBuilder().append(cnt));
    }
}
