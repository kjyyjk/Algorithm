import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int min = n;
        int hap = 0;
        int count=0;
        int j;

        for(int i = m; i<n+1; i++){
            //1과 i 자기 자신 제외하고 약수 나오면 break
            for(j = 2; j<i; j++){
                if(i%j==0)
                    break;
            }

            //중간에 break 없이 끝까지 갔으면 소수이다.
            if(i==j){
                count++;
                hap += i;
                if(min>i)
                    min = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(hap==0)
            sb.append(-1);
        else
            sb.append(hap).append('\n').append(min);

        System.out.println(sb);
    }
}
