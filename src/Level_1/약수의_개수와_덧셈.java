package Level_1;

public class 약수의_개수와_덧셈 {

    /*
     두 정수 left와 right가 매개변수로 주어집니다.
     left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요
     * */

    static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {

            // 약수 갯수 세기
            if (diviCount(i) % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }

    static int diviCount(int n) {
        int count = 1;
        for (int i = 2; i <= n; i++) {
            count += n % i == 0 ? 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {

        int solution1 = solution(13, 17);
        System.out.println("solution1 = " + solution1);
        System.out.println("기대값: 43");

        int solution2 = solution(24, 27);
        System.out.println("solution2 = " + solution2);
        System.out.println("기대값: 52");
    }
}
