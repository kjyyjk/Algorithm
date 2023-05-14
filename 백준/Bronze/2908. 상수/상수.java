import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int a,b;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append(br.readLine());

        StringTokenizer st = new StringTokenizer(sb.reverse().toString());

        sb.delete(0,sb.length());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if(a>b)
            sb.append(a);
        else
            sb.append(b);

        System.out.println(sb);
    }
}
