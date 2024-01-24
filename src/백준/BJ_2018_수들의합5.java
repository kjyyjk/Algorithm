package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2018_수들의합5 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int start_pointer = 1;
        int end_pointer = 1;
        int sum = 1;
        int cnt = 1;

        while(end_pointer!=n){

            if(n > sum) {
                end_pointer++;
                sum += end_pointer;
            } else if (n < sum) {
                sum -= start_pointer;
                start_pointer++;
            } else {
                end_pointer++;
                sum += end_pointer;
                cnt++;
            }
        }

        System.out.println(new StringBuilder().append(cnt).append('\n'));
    }

}
