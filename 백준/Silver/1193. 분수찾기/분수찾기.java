import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x, y;

        int n = Integer.parseInt(br.readLine());

        //대각선 개수 1 2 3 4 5.... 임. 곧 인덱스 개수. 이 대각선 합이 n보다 작은동안
        //set 1씩 증가
        //temp 도 증가 . temp는 현재 참조하고 있는 인덱스 역할을 한다
        int temp = 0;
        int set = 1;
        while(temp<n){
            temp += set++;
        }
        
        //다 완료하고 set에서 -1, temp에서 set값을 빼고 +1 하면
        //set은 찾고자하는 놈이 있는 번호의 열 또는 행.
        //temp는 그 대각선 상의 첫 인덱스
        set --;
        temp = temp-set+1;

        //set이 짝수이면 1헹 / set열 부터 왼쪽 아래로이동
        //홀수이면 1열 / set 행부터 오른쪽 위로 이동
        //temp가 대각선 상의 첫 인덱스 이므로
        //temp의 인덱스가 찾고자하는 인덱스 될 때까지
        if(set%2==0){
            x = 1;
            y = set;

            for(int i = temp; i<n; i++){
                x++;
                y--;
            }
        }
        else {
            x= set;
            y= 1;

            for(int i= temp; i<n; i++){
                x--;
                y++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(x).append('/').append(y);
        System.out.println(sb);
    }
}
