import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int i,j,k;
        int result = 0;
        int count;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(i= 0; i<n; i++){
            count = 0;
            j = Integer.parseInt(st.nextToken());
            for(k=1; k<j+1; k++){
                if(j%k==0)
                    count++;
            }
            if(count==2)
                result++;
        }

        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(result));
    }
}