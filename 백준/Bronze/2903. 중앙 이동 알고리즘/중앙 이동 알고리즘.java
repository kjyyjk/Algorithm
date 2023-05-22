import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int temp = 2;

        for(int i=0; i<n; i++){
            temp = temp*2 - 1;
        }

        System.out.println(temp*temp);
    }
}
