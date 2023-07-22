package Level_1;

public class 콜라문제 {

    static int solution(int a, int b, int n) {
        // a 병당 b병을 준다. 현재 보유병수 : n

        int answer = 0;

        answer = retrunBottle(a, b, n);

        return answer;
    }

    static int retrunBottle(int a, int b, int n) {

        int plus = 0;

        if (n / a > 0) {
            plus = n / a * b;
            int total = n % a + plus;

            if (total / a != 0) {
                plus += retrunBottle(a, b, total);
            }
        }

        return plus;

    }

    public static void main(String[] args) {
        int solution1 = solution(2, 1, 20);
        System.out.println("solution1 = " + solution1);
        System.out.println("기대값: 19");

        int solution2 = solution(3, 1, 20);
        System.out.println("solution2 = " + solution2);
        System.out.println("기대값: 9");

    }
}
