import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int i,j,k;
        int temp;
        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(i=0; i<n-2; i++){
            for(j=i+1; j<n-1; j++){
                for(k=j+1; k<n; k++){
                    temp = arr[i] + arr[j] + arr[k];
                    if(temp<m+1 && temp>result)
                        result = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(result));
    }
}
