import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int a, b, i, j,k;
        int count = 0;
        int[][] arr = new int[100][100];

        for(i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            for(j=a; j<a+10; j++){
                for(k=b; k<b+10; k++){
                    arr[j][k] += 1;
                }
            }
        }

        br.close();

        for(i=0; i<100; i++){
            for(j=0; j<100; j++){
                if(arr[i][j]>0)
                    count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count);
        System.out.println(sb);
    }
}
