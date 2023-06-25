import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int i,j,temp;
        int result = 0;
        int[] arr = new int[5];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(i=0; i<5; i++){
            arr[i] = Integer.parseInt(br.readLine());
            result += arr[i];
        }

        for(i=0; i<arr.length; i++){
            for(j=0; j<arr.length-1; j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(result/5).append('\n').append(arr[2]));
    }
}
