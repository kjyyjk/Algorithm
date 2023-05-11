import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        int i;
        int result = 0;
        boolean[] arr = new boolean[42];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(i=0; i<10; i++){
            arr[(Integer.parseInt(br.readLine()))%42] = true;
        }

        for(i=0; i<42; i++){
            if(arr[i]){
                result++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result);
        System.out.println(sb);
    }
}
