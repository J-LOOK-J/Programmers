package Level_1;

public class 자릿수더하기 {

    /*
    자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
    예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
    */

    static int solution(int n) {
        int answer = 0;

        while (n != 0) {
            answer += n % 10;
            n = n / 10;
        }

        return answer;
    }

    public static void main(String[] args) {
        int solution1 = solution(123);
        System.out.println("solution1 = " + solution1);
        System.out.println("기대값 6");

        int solution2 = solution(987);
        System.out.println("solution2 = " + solution2);
        System.out.println("기대값 24");

    }
}
