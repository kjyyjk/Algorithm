package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2023_신기한소수 {

    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);

        System.out.println(sb);
    }

    static void dfs(int k, int count) {

        if(count == n) {
            sb.append(k).append('\n');
            return;
        }

        for(int i=1; i<10; i+=2) {
            if(isPrime(k*10 + i)) {
                dfs(k*10 + i, count+1);
            }
        }
    }

    static boolean isPrime(int k) {
        for(int i=2; i<=k/2; i++) {
            if(k%i==0) {
                return false;
            }
        }
        return true;
    }
}
