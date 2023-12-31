import java.util.Arrays;

public class LeetCode561 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.arrayPairSum(new int[]{4,2,6,5,1,2}));
    }
}
class Solution {
    public int arrayPairSum(int[] nums) {
        System.out.println(Arrays.toString(nums));
        QuickSort.sort(nums, 0, nums.length - 1);
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i +=2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }
        return sum;
    }
}

class MergeSort {
    static void sort(int[] arr) {
        int length = arr.length;
        int mid = arr.length / 2;

        if (length <= 1) {
            return;
        }
        int[] leftArray = new int[mid];
        int[] rightArray = new int[length - mid];
        for (int i = 0, j = 0; i < length; i++) {
            if (i < mid) {
                leftArray[i] = arr[i];
            } else {
                rightArray[j] = arr[i];
                j++;
            }
        }
        sort(leftArray);
        sort(rightArray);
        merge(leftArray, rightArray, arr);
    }

    static void merge(int[] leftArray, int[] rightArray, int[] arr) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
                k++;
            } else if (leftArray[i] > rightArray[j]) {
                arr[k] = rightArray[j];
                j++;
                k++;
            } else {
                arr[k] = leftArray[i];
                arr[k + 1] = rightArray[j];
                k+=2;
                i++;
                j++;
            }
        }
        while (i < leftArray.length) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightArray.length) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}

class QuickSort {
    static void sort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int[] mid = partition(arr, begin, end);
        System.out.println(Arrays.toString(arr));
        sort(arr, begin, mid[0]);
        sort(arr, mid[1], end);

    }

    static int[] partition(int[] arr, int begin, int end) {
        int i = begin;
        int j = begin;
        int k = end;
        int mid = arr[(end + begin) / 2];

        while (j <= k) {
            if (arr[j] < mid) {
                swap(arr, j, i);
                i++;
                j++;
            } else if (arr[j] > mid) {
                swap(arr, j, k);
                k--;
            } else {
                j++;
            }
            System.out.println(Arrays.toString(arr));
        }
        return new int[]{i, j};
    }

    static void swap(int[] arr, int a, int b) {
        int temp;
        temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}