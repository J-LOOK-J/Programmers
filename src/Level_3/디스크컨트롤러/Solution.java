package Level_3.디스크컨트롤러;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {

    private int answer = 0;

    public int solution(int[][] jobs) {

        int nowTime = 0;
        LinkedList<int[]> linkedList = new LinkedList<>();

        // plans 를 index 0,1 오름차순으로 정렬
        Arrays.sort(jobs, (j0, j1)->{
            return j0[0] != j1[0] ? j0[0] - j1[0] : j0[1] - j1[1];
        });

        //plans 를 linkedlist 에 담기
        for (int[] job : jobs) {
            linkedList.add(job);
        }

        while (!linkedList.isEmpty()) {
            // 수행할 작업의 index 구하기
            int index = findNext(nowTime, linkedList);

            // 작업 진행 수행
            nowTime = doTask(index, nowTime, linkedList);
        }

        return answer / jobs.length;

    }

    public int doTask(int i, int nowTime, LinkedList<int[]> linkedList) {
        // 수행 할 작업을 list 에서 제거
        int[] polled = linkedList.get(i);
        linkedList.remove(i);

        // nowTime 을 작업이 끝나는 시점으로 갱신
        if (nowTime <= polled[0]) {
            nowTime = polled[0] + polled[1];
        } else {
            nowTime += polled[1];
        }

        answer += (nowTime - polled[0]);

        return nowTime;
    }

    public int findNext(int nowTime, LinkedList<int[]> linkedList) {
        int i = 0;
        int min = linkedList.get(i)[1];
        int minIndex = i;

        // nowTime 보다 시작 시간이 크다 = 작업이 밀려 있지 않다 => 가장 첫번째 작업 수행 return 0
        while (i < linkedList.size() && linkedList.get(i)[0] <= nowTime) {
            int taken = linkedList.get(i)[1];
            if (taken < min) {
                min = taken;
                minIndex = i;
            }
            i++;
        } // while
        return minIndex;
    } // function: doNext

}
