public class LeetCode1903 {
    public static void main(String[] args) {
        LeetCode1903 problem = new LeetCode1903();
        System.out.println(problem.largestOddNumber("52"));
    }
    public String largestOddNumber(String num) {
        String largestOddNumber = "";
        int indexOfEnd = -1;
        for (int i = num.length() - 1; i >= 0; i--) {
            switch (num.charAt(i)) {
                case '2', '4', '6', '8', '0' -> {
                    continue;
                }
            }
            indexOfEnd = i;
            break;
        }
        if (indexOfEnd != -1) {
            largestOddNumber = num.substring(0, indexOfEnd + 1);
        }
        return largestOddNumber;
    }
}
