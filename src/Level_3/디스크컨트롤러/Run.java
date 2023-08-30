package Level_3.디스크컨트롤러;

public class Run {

    public static void main(String[] args) {

        int[][] smaple = {{0, 3}, {1, 9}, {2, 6}};
//        결과: 9

        Solution solution = new Solution();

        int solution1 = solution.solution(smaple);
        System.out.println("solution1 = " + solution1);
    }


}
