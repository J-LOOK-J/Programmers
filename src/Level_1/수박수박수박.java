package Level_1;

public class 수박수박수박 {

    /*
    길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.
    n은 10,000이하 자연수
    */

    static String solution(int n) {
        String answer = "";
        String str = "수박";

        answer = str.repeat(n / 2);

        if (n % 2 == 1) {
            answer += "수";
        }

        return answer;

        // 다른사람 코드
        // return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
    }

    public synchronized static void main(String[] args) {
        String solution1 = solution(3);
        System.out.println("solution1 = " + solution1);
        System.out.println("기대값: 수박수");

        String solution2 = solution(4);
        System.out.println("solution2 = " + solution2);
        System.out.println("기대값: 수박수박");
    }
}
