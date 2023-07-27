package Level_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 문제_2016년 {


    static String solution(int a, int b) {
        //SUN,MON,TUE,WED,THU,FRI,SAT
        //2016년 1월 1일은 금요일
        String answer = "";

        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        Date date1 = new Date("2016/01/01");
        Date date2 = new Date("2016/" + a + "/" + b);

        long diffSec = date2.getTime() - date1.getTime();

        int diffDay = (int) (diffSec / (60 * 60 * 24 * 1000));
        int nowDays = (diffDay) % 7;
        answer = days[nowDays];

        return answer;
    }
    public static void main(String[] args) {

        String solution1 = solution(5, 24);
        System.out.println("solution1 = " + solution1);
        System.out.println("기대값: TUE");

    }
}
