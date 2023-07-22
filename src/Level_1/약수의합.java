package Level_1;

public class 약수의합 {

    static int solution(int n) {
        int answer = 0;
        int sqrt = (int)Math.sqrt(n);

        for (int i = 1; i < sqrt; i++) {
            if (n % i == 0) {
                answer += i;
                answer += n / i;
            }
        }

        if (n / Math.sqrt(n) == Math.sqrt(n) && n % Math.sqrt(n) == 0) {
            answer += Math.sqrt(n);
        }

        return answer;
    }


    public static void main(String[] args) {

        int solution1 = solution(12);
        System.out.println("solution1 = " + solution1);
        System.out.println("기대값: 28");

        int solution2 = solution(5);
        System.out.println("solution2 = " + solution2);
        System.out.println("기대값: 6");

        int solution3 = solution(16);
        System.out.println("solution3 = " + solution3);
        System.out.println("기대값: 31");

        solution(0);


    }
}
