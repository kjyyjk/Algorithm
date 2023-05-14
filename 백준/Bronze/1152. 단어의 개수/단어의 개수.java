import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
         int count = 0;
         int pre_str = 32; //첫 공백에 증가하는 것을 막기 위해 시작 시 이전 입력을 공백으로
         int str;

         while(true){
             str = System.in.read();
             
             //공백 입력 시
             if(str == 32){
                 //이전 입력이 공백이 아니면 증가
                 if(pre_str != 32){
                     count++;
                 }
             }
             //개행, 즉 엔터 입력 시
             else if(str == 10){
                 //이전 입력 공백 아니면
                 if(pre_str != 32){
                     count++;
                 }
                 break;
             }

             //반복 한번 끝나면 입력받은 문자가 이전문자가 된다
             pre_str = str;
         }

        System.out.println(count);
    }
}

