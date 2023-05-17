import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr;
        int i;
        int ind = 0;
        int max = 0;
        char c= '?';

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        arr = new int[26];

        for(i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            if(Character.isUpperCase(temp)){
                arr[temp-65] += 1;
            }
            else{
                arr[temp-97] += 1;
            }
        }

        for(i=0; i<arr.length; i++){
            if(arr[i]>max) {
                max = arr[i];
                c = (char)(i+65);
            }
            else if(arr[i]==max)
                c = '?';
        }

        StringBuilder sb = new StringBuilder();

        sb.append(c);

        System.out.println(sb);
    }
}
