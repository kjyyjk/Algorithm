import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) throws IOException {
        int i;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //HashSet : 순서 x 중복 x
        HashSet<Integer> hashset = new HashSet<>();

        for(i=0; i<10; i++){
            hashset.add(Integer.parseInt(br.readLine()) % 42);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(hashset.size());

        System.out.println(sb);
    }
}
