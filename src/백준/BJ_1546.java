package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1546 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int max = 0;
        int temp;

        StringTokenizer st =  new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++) {

            temp = Integer.parseInt(st.nextToken());

            sum += temp;
            if(temp>max)
                max = temp;
        }

        System.out.println(sb.append(sum*100.0/n/max));
    }
}
