package 백준.그래프.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1043_거짓말 {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        int[] truth;
        ArrayList<Integer>[] partyArr;

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        partyArr = new ArrayList[m];

        for (int i=1; i<n+1; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine(), " ");
        truth = new int[Integer.parseInt(st.nextToken())];

        if(truth.length == 0) { //진실러가 없으면 파티 전부
            System.out.println(m);
            return;
        }

        for (int i=0; i<truth.length; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<m; i++) {

            partyArr[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine(), " ");

            st.nextToken();
            int firstAttender = Integer.parseInt(st.nextToken());
            partyArr[i].add(firstAttender); //파치 참석자 최소 한명 등록
 
            while (st.hasMoreTokens()) { // 파티 참석자가 둘 이상일 때
                int nextAttender = Integer.parseInt(st.nextToken());
                partyArr[i].add(nextAttender);
                union(firstAttender, nextAttender); //각 파티의 참석자들을 하나의 집합으로
            }
        }

        for (int i=0; i<truth.length; i++) {
            truth[i] = find(truth[i]); //진실러들의 대표 노드
        }

        int cnt = m;
        for (int i=0; i<m; i++) {
            int temp = find(partyArr[i].get(0)); //각 파티의 아무나의 대표노드를

            for (int j=0; j<truth.length; j++) { //진실러의 대표노드와 비교
                if (temp == truth[j]) { //같다 -> 파티에 진실러 혹은 전해들은 사람이 있다
                    cnt--;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            int temp = find(parent[x]);
            parent[x] = temp;
            return temp;
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a!=b) {
            parent[b] = a;
        }
    }

}
