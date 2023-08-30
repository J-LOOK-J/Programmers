package Level_2.수식최대화;

public class Run {

    public static void main(String[] args) {

        String sample = "100-200*300-500+20";
//        기대값: 60420

//        String sample = "50*6-3*2";
//        기대값: 300

        Solution ss = new Solution();
        long solution = ss.solution(sample);
        System.out.println("solution = " + solution);

    }
}
