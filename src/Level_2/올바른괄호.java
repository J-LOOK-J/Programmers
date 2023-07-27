package Level_2;

import java.util.ArrayList;

public class 올바른괄호 {

    static boolean solution(String s) {
        boolean answer = true;

        // 시간초과로 효율성 점수 제로
        /*while (s.contains("()")) {
            s = s.replace("()", "");
        }

        if (s.length() == 0) {
            return true;
        }*/


        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ( '(' == (s.charAt(i)) ) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }

        if (count != 0) {
            return false;
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println( solution("()()") );
        System.out.println("기대값: true");

        System.out.println( solution("(())()") );
        System.out.println("기대값: true");

        System.out.println( solution(")()(") );
        System.out.println("기대값: false");

        System.out.println( solution("(()(") );
        System.out.println("기대값: false");

    }
}
