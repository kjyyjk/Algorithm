import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder().append(br.readLine());

        if(sb.toString().equals(sb.reverse().toString())){
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}
