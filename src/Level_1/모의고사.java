package Level_1;

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {

    /*문제 설명
    수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

    1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

    1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.*/


    static int[] solution(int[] answers) {


        int[] math0 = {1, 2, 3, 4, 5};
        int[] math1 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] math2 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == math0[i % 5]) {
                score[0]++;
            }
            if (answers[i] == math1[i % 8]) {
                score[1]++;
            }
            if (answers[i] == math2[i % 10]) {
                score[2]++;
            }
        }

        int max = Math.max(score[2], Math.max(score[0], score[1]));

        ArrayList<Integer> rank = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (max == score[i]) {
                rank.add(i + 1);
            }
        }


        int[] answer = new int[rank.size()];
        for (int i = 0; i < rank.size(); i++) {
            answer[i] = rank.get(i);
        }

        //return list.stream().mapToInt(i->i.intValue()).toArray();

        return answer;
    }

    public static void main(String[] args) {
        int[] solution1 = solution(new int[]{1, 2, 3, 4, 5});
        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("기대값: 1");

        int[] solution2 = solution(new int[]{1, 3, 2, 4, 2});
        System.out.println("solution2 = " + Arrays.toString(solution2));
        System.out.println("기대값: 1,2,3");
    }

}
