package Level_1;

import java.rmi.activation.ActivationGroup_Stub;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class 같은숫자는싫어 {

    static int[] solution(int []arr) {
        int[] answer = {};


        LinkedList<Integer> linkedlist = new LinkedList<>();

        // 큐에 넣기 직전값
        int tempVal = arr[0];
        // 다음 값이 temp 와 같으면 그다음 값으로 이동 , 다르면 temp 를 linkedlist 에넣고 temp 에 해당값을 할당
        for (int i = 1; i < arr.length; i++) {
            if(tempVal == arr[i]){
                continue;
            }
            linkedlist.add(tempVal);
            tempVal = arr[i];
        }

        // 마지막 값은 linkedlist 에 넣어주기
        linkedlist.add(tempVal);

        answer = linkedlist.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public static void main(String[] args) {
        int[] solution1 = solution(new int[]{1, 1, 3, 3, 0, 1, 1});
        System.out.println("solution1 = " + solution1);
        for (int i : solution1) {
            System.out.print(i+",");
        }
        System.out.println();
        System.out.println("기대값: [1,3,0,1]");


        System.out.println("-----------------------------");

        int[] solution2 = solution(new int[]{4,4,4,3,3});
        for (int i : solution2) {
            System.out.print(i+",");
        }
        System.out.println();
        System.out.println("기대값: [4,3]");
    }
}
