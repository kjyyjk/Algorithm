import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int i,j,temp;
        int result = n;

        for(i=1; i<n; i++){
            temp = 0;
            String s = Integer.toString(i);
            for(j=0; j<s.length(); j++){
                temp+= s.charAt(j)-'0';
            }
            if(i+temp==n){
                if(result>i){
                    result = i;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        if(result == n)
            result = 0;
        System.out.println(sb.append(result));
    }
}
