package leetcode.array;

/**
 * 배열의 in-place 수정
 *
 * 외부 검증문에서는 nums 주소를 참조한다.
 * 따라서 nums 변수가 가리키는 주소를 변경하지 말아야한다.
 *
 * 참조를 유지한 채 배열의 요소를 직접 바꿔야한다.
 */
public class LC_26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int prevNum = -101;
        int ind = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != prevNum) {
                int newNum = nums[i];
                nums[ind++] = newNum;
                prevNum = newNum;
                count++;
            }
        }

        return count;
    }
}
