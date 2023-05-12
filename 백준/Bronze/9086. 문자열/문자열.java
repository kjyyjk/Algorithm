import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int i;
        String s;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(i=0; i<n; i++){
            s = br.readLine();
            sb.append(s.charAt(0)).append(s.charAt(s.length()-1)).append('\n');
        }

        br.close();
        System.out.println(sb);
    }
}
