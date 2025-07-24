package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * List로 하면 시간초과, Set으로 하면 통과!
 * 어떤 차이가 있을까?
 *
 * AbstracCollection#retainAll을 까보면
 * a.retainAll(b) -> b 자료형의 contains 연산 속도가 중요하다.
 * O(a.retainAll(b)) = a * O(b.contains(object))
 * 
 * list#contains는 내부에서 indexOf로 전체를 순회하기 때문에 O(n) 소요
 * 반면 set#contains는 해시값을 빠르게 비교한다.(해시 충돌이 나지 않는다면 O(1))
 *      찾고자하는 객체의 해시값을 모드 연산해 버킷 인덱스를 구하고 해당 버킷만 순회한다.
 *      최악의 상황으로 모든 객체의 해시값이 충돌난다면 하나의 버킷에 모두 담기게 되고 순회는 O(n).
 *
 * https://codingdog.tistory.com/entry/java-retainAll-%EB%A9%94%EC%86%8C%EB%93%9C%EB%A5%BC-%EA%B0%84%EB%8B%A8%ED%95%98%EA%B2%8C-%EB%B6%84%EC%84%9D%ED%95%B4-%EB%B4%85%EC%8B%9C%EB%8B%A4
 */
public class BJ_1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> first = new HashSet<>();
        for (int i = 0; i < n; i++) {
            first.add(br.readLine());
        }

        Set<String> second = new HashSet<>();
        for (int i = 0; i < m; i++) {
            second.add(br.readLine());
        }

        first.retainAll(second);
        List<String> result = first.stream().sorted(String::compareTo).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append(first.size()).append('\n');
        for (String name : result) {
            sb.append(name).append('\n');
        }
        System.out.println(sb);
    }
}
