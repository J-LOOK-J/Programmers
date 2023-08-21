package Level_2;

import java.text.ParseException;
import java.time.LocalTime;
import java.util.*;

public class 과제진행하기 {

    public static void main(String[] args) throws ParseException {
        Solution solution = new Solution();
        String[] solution1 = solution.solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}});
        for (String s : solution1) {
            System.out.println("s = " + s);
        }
        System.out.println("기대값 : [\"korean\", \"english\", \"math\"]");

        Solution solution2 = new Solution();

        String[] solution3 = solution2.solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}});
        for (String s : solution3) {
            System.out.println("s = " + s);
        }
        System.out.println("기대값: [\"science\", \"history\", \"computer\", \"music\"]");

    }
}


class Solution{

    private LinkedList<Object> result = new LinkedList<>();
    private int nextClass;    // 다음 수업 시작시간
    private int currClass;    // 진행 중인 수업시간
    private int currentTime;  // 현재 시각
    private int classTime;          // 진행중인 수업의 소요시간
    private  Stack<String[]> stack = new Stack<>();     // 잔여 수업정보 입력

    public String[] solution(String[][] plans) throws ParseException {
        String[] answer = {};

        // plans 를 index = 1 의 값으로 sort.
        Arrays.sort(plans, (p0, p1) -> {
            return LocalTime.parse(p0[1]).compareTo(LocalTime.parse(p1[1]));
        });

        // 수업진행 - 종료 시간이 다음 수업보다 앞인지 뒤인지 판단후 조치
        learning( plans, 0, plans.length);

        answer = result.toArray(new String[0]);

        return answer;
    }

    // 수업 진행
    public void learning( String[][] plans, int i, int size) {

        while (i < size - 1) {
            // 수업을 끝마친 경우
            if (canFinish(plans, i)) {
                result.add(plans[i][0]);        // 완료 테이블에 담기
                supplementary();                // 보충수업 진행
                i++;
                // 수업을 끝마치지 못하는 경우
            } else {
                stack.push(new String[]{plans[i][0], plans[i][2]});
                i++;
            }
        }

        // 남은 수업들 차례로 넣어주기
        result.add(plans[size - 1][0]);     // 정렬의 마지막 수업
        while (!stack.isEmpty()) {          // 보충수업
            result.add(stack.pop()[0]);
        }
    }

    // 보충수업 (queue 에 담겨있는 잔여 수업 진행하기)
    public void supplementary() {
        int emptyTime;
        int classTime;
        while (!stack.isEmpty() && currentTime != nextClass) {
            classTime = Integer.parseInt(stack.peek()[1]);
            emptyTime = nextClass - currentTime;
            // queue 에 든 보충수업 완료가능
            if (emptyTime >= classTime) {
                // 현재 시간 업데이트
                currentTime += classTime;
                // 완료된 수업 result 배열에 담기
                result.add(stack.peek()[0]);
                // 완료된 수업 보충수업 목록에서 제거
                stack.pop();
            }else {
                // 현재 시간 업데이트
                currentTime = nextClass;
                String[] pop = stack.pop();
                pop[1] = String.valueOf(classTime - emptyTime);
                stack.push(pop);
                return;
            }
        }
    }

    // 수업을 끝마칠수 있는지 여부 확인
    public boolean canFinish(String[][] plans, int i) {
        currClass = LocalTime.parse(plans[i][1]).getHour() * 60 + LocalTime.parse(plans[i][1]).getMinute();
        nextClass = LocalTime.parse(plans[i + 1][1]).getHour() * 60 + LocalTime.parse(plans[i + 1][1]).getMinute();
        classTime = Integer.parseInt(plans[i][2]);

        // 수업을 끝마칠수 없는 경우 (현재시각을 다음수업으로 업데이트 후 실패 반환)
        if (currClass + classTime - nextClass > 0) {
            currentTime = nextClass;
            plans[i][2] = String.valueOf(currClass + classTime - nextClass);
            return false;
        } else {
            // 수업을 완료 하는 경우 (현재시각을 수업종료 시점으로 업데이트)
            currentTime = currClass + classTime;
            return true;
        }
    }
}

