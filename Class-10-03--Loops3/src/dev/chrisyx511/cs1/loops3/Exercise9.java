package dev.chrisyx511.cs1.loops3;

public class Exercise9 {
    public static void main(String[] args) {
        class Solution {
            public String longestCommonPrefix(String[] strs) {
                boolean breakLoop = false;
                String result = "";
                for (int i = 0; i < strs[0].length(); i++) {
                    for (int j = 1; j < strs.length; j++) {
                        if (strs[0].charAt(i) != strs[j].charAt(i)) {
                            breakLoop = true;
                            break;
                        }
                    }
                    if (breakLoop) {
                        break;
                    }
                    result += strs[0].charAt(i);
                }
            }
        }
    }
}
