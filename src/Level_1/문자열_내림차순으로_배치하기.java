package Level_1;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

public class 문자열_내림차순으로_배치하기 {
    /*
    *  문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
        s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
* */

    static String solution(String s) {
        String answer = "";

        String[] array = s.split("");
        Arrays.sort(array, reverseOrder());
        answer = Arrays.stream(array).collect(Collectors.joining());;

        return answer;
    }


    public static void main(String[] args) {
        String solution1 = solution("Zbcdefg");
        System.out.println("solution1 = " + solution1);
        System.out.println("기대값 : gfedcbZ");

    }
}
