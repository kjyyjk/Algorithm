import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int a,b,c,d,e,f;
        int x,y;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        for(x=-999; x<1000; x++){
            for(y=-999; y<1000; y++){
                if((a*x + b*y == c)&&(d*x + e*y == f)){
                    sb.append(x).append(' ').append(y);
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
