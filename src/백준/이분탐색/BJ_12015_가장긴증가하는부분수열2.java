package 백준.이분탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * lis(longest increasing subsequence), 최장 증가 부분 수열
 * +
 * 이분탐색 (시간초과 땜시)
 */
public class BJ_12015_가장긴증가하는부분수열2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> nums = new ArrayList<>();
        nums.add(Integer.parseInt(st.nextToken()));

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (nums.get(nums.size() - 1) < num) { // lis의 마지막 원소보다 큰 경우 그냥 list에 추가
                nums.add(num);
            } else { // lis의 길이는 유지하며 낮은 숫자들로 구성을 바꾼다
                int ind = binarySearch(nums, num);
                nums.set(ind, num);
            }
        }

        System.out.println(nums.size());
    }

    static int binarySearch(List<Integer> nums, int num) { // lis 중 num을 갱신할 인덱스(num보다 큰 수중 제일 작은)를 찾아 반환
        int start = 0;
        int end = nums.size() - 1;

        int ret = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums.get(mid) >= num) {
                ret = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ret;
    }
}
