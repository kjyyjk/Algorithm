package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();

        int t, i;

        t = Integer.parseInt(br.readLine());

        for(i=0; i<t; i++){
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()){
                temp = new StringBuilder();
                result.append(temp.append(st.nextToken()).reverse().toString());
                result.append(' ');
            }
            result.append('\n');
        }
        System.out.println(result);
    }
}
