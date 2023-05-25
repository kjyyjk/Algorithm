import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i;
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        //어떤 수를 두 인수의 곱으로 나타낼 때 한 인수는 무조건 루트 n보다 작거나 같다.
        for(i=2; i<=Math.sqrt(n); i++){
            while(n%i==0){
                sb.append(i).append('\n');
                n/=i;
            }
        }

        if(n!=1)
            sb.append(n);

        System.out.println(sb);
    }
}