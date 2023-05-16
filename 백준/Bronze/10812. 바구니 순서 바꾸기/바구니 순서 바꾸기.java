import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        int t, l, n, m, i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for(t=0; t<n; t++){
            arr[t] = t+1;
        }


        for(t=0; t<m; t++){
            st = new StringTokenizer(br.readLine(), " ");

            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            //i~k-1을 담을 입시 배열
            int[] tmp = new int[j-i+1];
            //ind는 tmp의 인덱스
            int ind = 0;
            //i~k-1을 tmp에
            for(l=i-1; l<k-1; l++){
                tmp[ind++] = arr[l];
            }
            //k~j를 i인덱스부터 넣는다.
            for(l=k-1;l<j;l++){
                arr[l-k+i] = arr[l];
            }

            ind = 0;

            //k~j를 넣은 뒤 부터 j까지 tmp에 있는 값을 넣는다
            for(l=j-k+i; l<j; l++){
                arr[l] = tmp[ind++];
            }
        }

        StringBuilder sb = new StringBuilder();

        for(t=0; t<n; t++){
            sb.append(arr[t]).append(' ');
        }

        System.out.println(sb);
    }
}
