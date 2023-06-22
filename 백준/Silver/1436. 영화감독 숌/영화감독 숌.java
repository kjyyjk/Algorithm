import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i;
        int count=0;
        int result;
        int n = Integer.parseInt(br.readLine());

        for(i=666; ; i+=1){
            if(Integer.toString(i).contains("666")){
                if(++count == n){
                    break;
                }
            }
        }
        System.out.println(new StringBuilder().append(i));
    }
}
