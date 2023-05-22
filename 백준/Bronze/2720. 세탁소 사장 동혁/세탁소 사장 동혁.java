import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int a,b,c,d,i,j;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(i= 0; i<t; i++){
            j = Integer.parseInt(br.readLine());
            a = j%25;
            b = a%10;
            c = b%5;

            sb.append(j/25).append(' ');
            sb.append(a/10).append(' ');
            sb.append(b/5).append(' ');
            sb.append(c).append(' ');
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
