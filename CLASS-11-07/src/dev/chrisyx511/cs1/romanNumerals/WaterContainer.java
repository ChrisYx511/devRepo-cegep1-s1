package dev.chrisyx511.cs1.romanNumerals;



public class WaterContainer {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,2,4,3}));
    }
    public static int maxArea(int[] height) {
        int minPointX = 0, minPointHeight = 0;
        int maxPointX = 0, maxPointHeight = 0;
        int area =0;

        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                minPointHeight = height[i];
                continue;
            }
            if ((height.length - 1 - i) + height[i] > (height.length - 1 - minPointX) + minPointHeight) {
                minPointX = i;
                minPointHeight = height[i];
            }
        }
        for (int j = 0; j < height.length; j++) {
            if (j == minPointX) {
                continue;
            }
            if (j == 0) {
                maxPointHeight = height[j];
                area = Math.abs(maxPointX - minPointX) * Math.min(maxPointHeight, minPointHeight);
                continue;
            }
            if (Math.abs(j - minPointX) * Math.min(height[j], minPointHeight) > Math.abs(maxPointX - minPointX) * Math.min(maxPointHeight, minPointHeight)) {
                maxPointX = j;
                maxPointHeight = height[j];
                area = Math.abs(maxPointX - minPointX) * Math.min(maxPointHeight, minPointHeight);
            }
        }
        return area;
    }
}
