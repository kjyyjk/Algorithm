import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int i;
        int max = 0;
        double hap=0;
        double result;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] score = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(i=0; i<n; i++){
            score[i]=Integer.parseInt(st.nextToken());
            if(score[i]>max)
                max = score[i];
        }

        for(i=0; i<n; i++){
            hap += ((double)score[i] * 100 / max);
        }

        StringBuilder sb = new StringBuilder();
        result = hap/n;
        sb.append(result);
        System.out.println(sb);
    }
}
