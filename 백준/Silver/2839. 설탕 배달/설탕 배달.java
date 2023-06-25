import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result=0;

        //5로 최대한 채우다가 나머지는 3으로 채워야하므로
        //3 씩 감소하다가, n이 5의 배수가 되면. 즉 5로 모두 배달할 수 있으면
        //그만.
        //3씩 감소하다가 0으로 딱떨어지는게 아닌, 음수로 가면? 3으로도 못나누는 거기 때문에
        //그만. https://hellodoor.tistory.com/92 참고함
        while(true){
            if(n%5==0){
                result += n/5;
                break;
            }
            else if(n<0){
                result=-1;
                break;
            }
            n-=3;
            result += 1;
        }

        System.out.println(new StringBuilder().append(result));
    }
}
