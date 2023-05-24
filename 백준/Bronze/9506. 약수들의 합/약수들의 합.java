import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n,i;
        int sum,ind;
        int[] arr;

        while(true){
            n = Integer.parseInt(br.readLine());

            if(n==-1)
                break;
            sum=0;
            ind=0;

            arr = new int[n];

            for(i=1; i<n; i++){
                if(n%i==0){
                    sum+=i;
                    arr[ind++]=i;
                }
            }

            sb.append(n).append(' ');

            if(sum==n){
                sb.append("= ").append(arr[0]);
                for(i=1; i<ind; i++){
                    sb.append(" + ").append(arr[i]);
                }
                sb.append('\n');
            }
            else {
                sb.append("is NOT perfect.\n");
            }
        }
        System.out.println(sb);
    }
}
