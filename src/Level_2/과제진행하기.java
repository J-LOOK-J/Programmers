package Level_2;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

public class 과제진행하기 {

    public static void main(String[] args) throws ParseException {
        Solution solution = new Solution();
        String[] solution1 = solution.solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}});
        System.out.println("solution1 = " + solution1);
        System.out.println("기대값 : [\"korean\", \"english\", \"math\"]");

        String[] solution2 = solution.solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}});
        System.out.println("solution2 = " + solution2);
        System.out.println("기대값: [\"science\", \"history\", \"computer\", \"music\"]");

    }



}


class Solution{

    private LinkedList<Object> result = new LinkedList<>();
    private LocalTime nextClass;    // 다음 수업 시작시간
    private LocalTime currClass;    // 진행 중인 수업시간
    private LocalTime currentTime;  // 진행중인 수업의 소요시간
    private int currClassTime;      // 현재 시각
    private Queue<String[][]> queue = new LinkedList<>();   // 잔여 수업정보 입력



    public String[] solution(String[][] plans) throws ParseException {
        String[] answer = {};
        String[][] doing;   // 현재 진행하고 있는 수업 정보
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        Date current = sdf.parse(plans[0][1]);    // 현재 시각
        Queue<String[][]> queue = new LinkedList();

        // plans 를 index = 1 의 값으로 sort.
        Arrays.sort(plans, (p0, p1) -> {
            return LocalTime.parse(p0[1]).compareTo(LocalTime.parse(p1[1]));
        });

        // 수업진행 - 종료 시간이 다음 수업보다 앞인지 뒤인지 판단후 조치
        learning( plans, 0, plans.length);



        return answer;
    }

    // 수업 진행
    public void learning( String[][] plans, int i, int size) {

        while (i < size) {
            // 수업을 끝마친 경우
            if (canFinish(i) ) {
                result.add(plans[i][0]);        // 완료 테이블에 담기
                supplementary();                // 보충수업 진행
                learning(plans, i + 1, size);

            // 수업을 끝마치지 못하는 경우
            } else if (canFinish(i)) {
                queue.add(new String[][] {plans[0],[]})     // 보충수업 목록에 저장
            }
        }

    }

    // 보충수업 (queue 에 담겨있는 잔여 수업 진행하기)
    public void supplementary() {
        while (!queue.isEmpty() || currentTime == nextClass) {
//            분기처리
        }
    }

    // 수업을 끝마칠수 있는지 여부 확인
    public boolean canFinish(int i) {
        currClass = LocalTime.parse(plans[i][1]);
        nextClass = LocalTime.parse(plans[i + 1][1]);
        currClassTime = LocalTime.parse(plans[i][2]).getMinute();

        // 수업을 끝마칠수 없는 경우 (현재시각을 다음수업으로 업데이트 후 실패 반환)
        if (currClass.plusMinutes(currClassTime).compareTo(nextClass) > 0) {
            currentTime = nextClass;
            return false;
        } else {
            // 수업을 완료 하는 경우 (현재시각을 수업종료 시점으로 업데이트)
            currentTime = currClass.plusMinutes(currClassTime);
            return true;
        }
    }


}

/*class School {
    private LocalTime nextClass;
    private LocalTime currClass;
    private int currClassTime;
    private Queue<String[][]> queue = new LinkedList<>();   // 잔여 수업정보 입력
    private String[][] plans;

    public School(String[][] plans) {
        this.plans = plans;
    }

    public int getPlansLength() {
        return plans.length;
    }

    public boolean canFinish(int i) {
        currClass = LocalTime.parse(plans[i][1]);
        nextClass = LocalTime.parse(plans[i + 1][1]);
        currClassTime = LocalTime.parse(plans[i][2]).getMinute();
        return currClass.plusMinutes(currClassTime).compareTo(nextClass) > 0 ? false : true;
    }




}*/
