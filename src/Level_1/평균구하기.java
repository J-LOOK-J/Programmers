package Level_1;

public class 평균구하기 {

    static double solution(int[] arr) {
        double answer = 0;

        double sum = 0;

        for (int i : arr) {
            sum += i;
        }

        answer = sum / arr.length;

        return answer;
    }

    public static void main(String[] args) {
        double solution1 = solution(new int[]{1, 2, 3, 4});
        System.out.println("solution1 = " + solution1);
        System.out.println("기대값: 2.5");


    }
}
