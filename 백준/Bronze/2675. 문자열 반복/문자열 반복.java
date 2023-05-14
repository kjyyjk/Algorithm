import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int i,j,k,x;
        String s;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(i=0; i<n; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            s = st.nextToken();
            for(j=0;j<s.length();j++){
                for(x=0; x<k; x++){
                    sb.append(s.charAt(j));
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}