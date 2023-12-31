import java.util.Arrays;

public class LeetCode80 {
    public static void main(String[] args) {
        LeetCode80 q = new LeetCode80();
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(q.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
    public int removeDuplicates(int[] nums) {
        int lastDigit = nums[0];
        int count = 0;
        int totalRemoved = 0;
        int i = 0;
        while (i < nums.length - totalRemoved) {
            if (lastDigit != nums[i]) {
                lastDigit = nums[i];
                count = 1;
                i++;
                continue;
            }
            if (count >= 2) {
                shiftBack(nums, i, nums.length - totalRemoved);
                totalRemoved++;
            } else {
                count++;
                i++;
            }

        }
        return nums.length - totalRemoved;
    }

    public void shiftBack(int[] arr, int begin, int end) {
        for (int i = begin; i < end - 1; i++) {
            arr[i] =arr[i + 1];
        }
    }

}
