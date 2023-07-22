package Level_1;

public class 소수만들기 {
    static int solution(int[] nums) {
        int answer = 0;
        int num = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int k = i + 1; k < nums.length - 1; k++) {
                for (int m = k + 1; m < nums.length; m++) {
                    num = nums[i] + nums[k] + nums[m];
                    if (checkPrime(num)) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    static boolean checkPrime(int num) {

        if (num % 2 == 0) {
            return false;
        }

        int sqrt = (int) Math.sqrt(num) +1 ;

        for (int i = 3; i < sqrt; i = i + 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] val1 = {1, 2, 3, 4};
        int solution1 = solution(val1);
        System.out.println("solution = " + solution1);

        int[] val2 = {1, 2, 7, 6, 4};
        int solution2 = solution(val2);
        System.out.println("solution2 = " + solution2);

    }
}