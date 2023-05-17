import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr;
        int i;
        int ind = 0;
        int count = 0;
        int max = 0;

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
                ind = i;
            }
        }

        for(i=0; i<arr.length; i++){
            if(arr[i]==max)
                count++;
        }

        StringBuilder sb = new StringBuilder();

        if(count>1)
            sb.append("?");
        else {
            sb.append((char)(ind+65));
        }

        System.out.println(sb);
    }
}
