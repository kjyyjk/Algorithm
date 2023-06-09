import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int i,j,temp;
        int ind=0;

        int[] arr = new int[n];

        for(i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(i=0; i<n; i++){
            for(j=0; j<n-1; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int a : arr){
            sb.append(a).append('\n');
        }
        System.out.println(sb);
    }
}
