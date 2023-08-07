package Level_1;

import java.util.Arrays;
import java.util.HashMap;

public class 가장가까운_같은글자 {

    static int[] solution(String s) {
        int[] answer = new int[s.length()];

        // hasMap ( 알파벳 , 인덱스 )
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            // 판단할 알파벳
            char c = s.charAt(i);

/*            if (hashMap.get(c) == null) {
                // 이전값이 존재하지 않는경우
                answer[i] = -1;
                hashMap.put(c, i);
            } else {
                // 이전 값이 존재하는 경우
                answer[i] = i - hashMap.get(c);
                hashMap.put(c, i);
            }*/

            answer[i] = i - hashMap.getOrDefault(c, i+1);
            hashMap.put(c, i);

        }

        return answer;
    }
    public static void main(String[] args) {
        int[] solution1 = solution("banana");
        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("기대값: [-1, -1, -1, 2, 2, 2]");


    }

}
