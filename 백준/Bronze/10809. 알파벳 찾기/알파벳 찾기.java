import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int i;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringBuilder sb =new StringBuilder();
        for(i=97; i<123; i++){
            sb.append(s.indexOf(i)).append(' ');
        }
        System.out.println(sb);
    }
}
