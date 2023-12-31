public class LeetCode11 {
    public static void main(String[] args) {
            System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int area = 0;
        while (i < j) {
            int tempArea = Math.min(height[i], height[j]) * (j - i);
            if (tempArea > area) {
                area = tempArea;
            }
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return area;
    }
}
