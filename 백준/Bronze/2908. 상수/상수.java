import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        String a,b;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = st.nextToken();
        b = st.nextToken();

        StringBuilder sb = new StringBuilder();

        if(a.charAt(2)>b.charAt(2))
            sb.append(a);
        else if(a.charAt(2)<b.charAt(2))
            sb.append(b);
        else{
            if(a.charAt(1)>b.charAt(1))
                sb.append(a);
            else if(a.charAt(1)<b.charAt(1))
                sb.append(b);
            else{
                if(a.charAt(0)>b.charAt(0))
                    sb.append(a);
                else
                    sb.append(b);
            }
        }
        System.out.println(sb.reverse());
    }
}