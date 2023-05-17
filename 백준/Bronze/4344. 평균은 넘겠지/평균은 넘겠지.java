import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        int i,j;
        int sum;
        int overAverage;
        int[] score;
        double average, result;
        StringBuilder sb;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());

        for(i=0; i<c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            score = new int[n];

            sum=0;
            overAverage = 0;

            for(j=0; j<n; j++){
                score[j] = Integer.parseInt(st.nextToken());
                sum += score[j];
            }

            average = (double)sum/n;

            for(j=0;j<n;j++){
                if(score[j]>average)
                    overAverage++;
            }

            result = (double)overAverage/n*100;
            sb = new StringBuilder();
            sb.append(String.format("%.3f",result)).append('%');
            System.out.println(sb);
        }

        br.close();
    }
}
