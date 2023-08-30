package Level_2;

import java.text.ParseException;
import java.time.LocalTime;
import java.util.*;

public class 과제진행하기 {

    public static void main(String[] args) throws ParseException {
/*        Solution solution = new Solution();
        String[] solution1 = solution.solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}});
        for (String s : solution1) {
            System.out.println("s = " + s);
        }
        System.out.println("기대값 : [\"korean\", \"english\", \"math\"]");*/

        Solution solution2 = new Solution();

        String[] solution3 = solution2.solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}});
        for (String s : solution3) {
            System.out.println("s = " + s);
        }
        System.out.println("기대값: [\"science\", \"history\", \"computer\", \"music\"]");

    }
}


class Solution{

//    private int nextClass;    // 다음 수업 시작시간
//    private int currClass;    // 진행 중인 수업시간
    private int currentTime;  // 현재 시각
    private int nextTime;       // 다음 수업시간
//    private int classTime;          // 진행중인 수업의 소요시간
    private Stack<School> stack = new Stack<>();     // 잔여 수업정보 입력
    private String[] answer;
    private int answerIdx = 0;


    static class School implements Comparable<School>{
        private String subject;
        private int startTime;
        private int remainTime;

        public School(String subject, int startTime, int remainTime) {
            this.subject = subject;
            this.startTime = startTime;
            this.remainTime = remainTime;
        }

        public String getSubject() {
            return subject;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getRemainTime() {
            return remainTime;
        }

        private void setRemainTime(int remainTime) {
            this.remainTime = remainTime;
        }

        @Override
        public int compareTo(School o) {
            return this.startTime - o.startTime;
        }

        private void minusTime(int minutes) {
            this.remainTime -= minutes;
        }


    }

    /*public String[] solution(String[][] plans) throws ParseException {
        answer = new String[plans.length];

        // plans 를 index = 1 의 값으로 sort.
        Arrays.sort(plans, (p0, p1) -> {
            return LocalTime.parse(p0[1]).compareTo(LocalTime.parse(p1[1]));
        });

        // 수업진행 - 종료 시간이 다음 수업보다 앞인지 뒤인지 판단후 조치
        learning( plans, 0, plans.length);

        return answer;
    }*/

    public String[] solution(String[][] plans) throws ParseException {
        answer = new String[plans.length];
//        PriorityQueue<School> schools = new PriorityQueue<>();
        ArrayList<School> schools = new ArrayList<>();

        for (int i = 0; i < plans.length; i++) {
            int startTime = LocalTime.parse(plans[i][1]).getHour() * 60 + LocalTime.parse(plans[i][1]).getMinute();
            int remainTime = Integer.parseInt(plans[i][2]);
            schools.add(new School(plans[i][0], startTime, remainTime));
        }

        Collections.sort(schools);

        // 수업진행 - 종료 시간이 다음 수업보다 앞인지 뒤인지 판단후 조치
        learning(schools);

        return answer;
    }

    // 수업 진행
    /*public void learning( String[][] plans, int i, int size) {

        while (i < size - 1) {
            // 수업을 끝마친 경우
            if (canFinish(plans, i)) {
                answer[answerIdx++] = plans[i][0];// 완료 테이블에 담기
                supplementary();                // 보충수업 진행
                i++;
                // 수업을 끝마치지 못하는 경우
            } else {
                stack.push(new String[]{plans[i][0], plans[i][2]});
                i++;
            }
        }

        // 남은 수업들 차례로 넣어주기
        answer[answerIdx++] = plans[size - 1][0];   // 정렬의 마지막 수업
        while (!stack.isEmpty()) {                  // 보충수업
            answer[answerIdx++] = stack.pop()[0];
        }
    }*/
    public void learning(ArrayList<School> schools) {

        int i = 0;
        int size = schools.size();
        while (i < size - 1) {
            // 수업을 끝마친 경우
            if (canFinish(schools, i)) {
                answer[answerIdx++] = schools.get(i).getSubject();
//                answer[answerIdx++] = plans[i][0];// 완료 테이블에 담기
                supplementary();                // 보충수업 진행
                i++;
                // 수업을 끝마치지 못하는 경우
            } else {
                stack.push(schools.get(i));
//                stack.push(new String[]{plans[i][0], plans[i][2]});
                i++;
            }
        }

        // 남은 수업들 차례로 넣어주기
        answer[answerIdx++] = schools.get(size - 1).getSubject();   // 정렬의 마지막 수업
        while (!stack.isEmpty()) {                  // 보충수업
            answer[answerIdx++] = stack.pop().getSubject();
        }
    }

    // 보충수업 (queue 에 담겨있는 잔여 수업 진행하기)
    public void supplementary() {
        int emptyTime;
        int classTime;
        while (!stack.isEmpty() && currentTime != nextTime) {

            classTime = stack.peek().getRemainTime();
            emptyTime = nextTime - currentTime;
            // queue 에 든 보충수업 완료가능
            if (emptyTime >= classTime) {
                // 현재 시간 업데이트
                currentTime += classTime;
                // 완료된 수업 result 배열에 담기
                answer[answerIdx++] = stack.pop().getSubject();
            }else {
                // 현재 시간 업데이트
                currentTime = nextTime;
                School pop = stack.pop();
                pop.setRemainTime(classTime - emptyTime);
                stack.push(pop);
                return;
            }
        }
    }

    // 수업을 끝마칠수 있는지 여부 확인
    public boolean canFinish(ArrayList<School> schools, int i) {
/*        currClass = LocalTime.parse(plans[i][1]).getHour() * 60 + LocalTime.parse(plans[i][1]).getMinute();
        nextClass = LocalTime.parse(plans[i + 1][1]).getHour() * 60 + LocalTime.parse(plans[i + 1][1]).getMinute();
        classTime = Integer.parseInt(plans[i][2]);*/
        int finishTime = schools.get(i).getStartTime() + schools.get(i).getRemainTime();
        nextTime = schools.get(i + 1).getStartTime();

        // 수업을 끝마칠수 없는 경우 (현재시각을 다음수업으로 업데이트 후 실패 반환)
        if (finishTime - nextTime > 0) {
            currentTime = nextTime;
            schools.get(i).minusTime(nextTime - schools.get(i).getStartTime());
//            plans[i][2] = String.valueOf(currClass + classTime - nextClass);
            return false;
        } else {
            // 수업을 완료 하는 경우 (현재시각을 수업종료 시점으로 업데이트)
            currentTime = finishTime;
            return true;
        }
    }
}

