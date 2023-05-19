import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        int i;
        int count=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        br.close();

        for(i=0; i<s.length(); i++){

            if(s.charAt(i)=='c'){
                if(i==s.length()-1){
                    count++;
                }
                else{
                    if(s.charAt(i+1)=='='||s.charAt(i+1)=='-'){
                        i++;
                    }
                    count++;
                }
            }

            else if(s.charAt(i)=='l'){
                if(i==s.length()-1){
                    count++;
                }
                else{
                    if(s.charAt(i+1)=='j'){
                        i++;
                    }
                    count++;
                }
            }

            else if(s.charAt(i)=='n'){
                if(i==s.length()-1){
                    count++;
                }
                else{
                    if(s.charAt(i+1)=='j'){
                        i++;
                    }
                    count++;
                }
            }

            else if(s.charAt(i)=='s'){
                if(i==s.length()-1){
                    count++;
                }
                else{
                    if(s.charAt(i+1)=='='){
                        i++;
                    }
                    count++;
                }
            }

            else if(s.charAt(i)=='z'){
                if(i==s.length()-1){
                    count++;
                }
                else{
                    if(s.charAt(i+1)=='='){
                        i++;
                    }
                    count++;
                }
            }

            else if(s.charAt(i)=='d'){
                if(i==s.length()-1){
                    count++;
                }
                else{
                    if(s.charAt(i+1)=='-'){
                        i++;
                    }
                    else if (i!=s.length()-2) {
                        if(s.charAt(i+1)=='z'&&s.charAt(i+2)=='=')
                            i+=2;
                    }
                    count++;
                }
            }
            else{
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count);
        System.out.println(sb);
    }
}
