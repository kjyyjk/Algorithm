import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        boolean[] arr;
        int count = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String s = br.readLine();
            arr = new boolean[26];
            int check = 0;

            for(int j=0; j<s.length(); j++){
                if(arr[s.charAt(j)-97]==true){
                    if(s.charAt(j-1) != s.charAt(j))
                        check++;
                }
                else
                    arr[s.charAt(j)-97]=true;
            }

            if(check==0)
                count++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count);
        System.out.println(sb);
    }
}
