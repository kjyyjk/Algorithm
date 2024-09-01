package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2979_트럭주차 {
    public static void main(String[] args) throws IOException {

        int[] park = new int[100];
        int[] price = new int[4];
        int total = 0;
        int i;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        price[1] = Integer.parseInt(st.nextToken());
        price[2] = Integer.parseInt(st.nextToken());
        price[3] = Integer.parseInt(st.nextToken());

        for (i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            int in = Integer.parseInt(st.nextToken());
            int out = Integer.parseInt(st.nextToken());

            for (int j=in; j<out; j++) {
                park[j]++;
            }
        }

        for (i=1; i<100; i++) {
            total += price[park[i]] * park[i];
        }

        System.out.println(new StringBuilder().append(total));
    }
}
