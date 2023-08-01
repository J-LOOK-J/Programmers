package Level_2;

public class 피보나치수 {

    // ************   case 3 ******************************************************************
/*    static int solution(int n) {
        int answer = 0;

        // 배열생성.
        int[] fiboVal = new int[n + 1];
        fiboVal[0] = 0;
        fiboVal[1] = 1;

        fibo2(n, fiboVal);
        return fiboVal[n];
    }

    static void fibo2(int n, int[] fiboVal) {
        int index = 2;
        while (n >= index) {
            fiboVal[index] = (fiboVal[index - 1] + fiboVal[index - 2]) % 1234567;
            index++;
        }
    }*/


// ************   case 2 ******************************************************************
    static int solution(int n) {
        int answer = 0;

        // 이미 가지고 있는값을 중복으로 구하지 않기 위해 배열생성.
        int[] fiboVal = new int[n + 1];
        fiboVal[0] = 0;
        fiboVal[1] = 1;
        answer = (int)(fibo(n, fiboVal));

        return answer;
    }
    static int fibo(int n, int[] fiboVal) {
        int result = 0;

        if (fiboVal[n] != 0) {  // 배열에 해당 값이 있으면 바로 꺼내 쓰고
            return fiboVal[n];
        } else if (n >= 2) {    // 없으면 값을 구한뒤 배열에 저장.
            result = fibo(n - 2, fiboVal) + fibo(n - 1, fiboVal);
            fiboVal[n] = result % 1234567;
        }
        return fiboVal[n];
    }


// ************   case 1 ******************************************************************
/*    static int solution(int n) {
        int answer = 0;

        answer = fibo(n);

        return answer % 1234567;
    }
    // 피보나치 수열
    static int fibo(int n) {
        int result = 0;
        if (n >= 2) {
            result = fibo(n - 1) + fibo(n - 2);
        } else if (n == 1) {
            return 1;
        }
        return result;
    }*/

    public static void main(String[] args) {
        int solution1 = solution(3);
//        System.out.println("solution1 = " + solution1);
//        System.out.println("기대값 : 2");
//
//        int solution2 = solution(5);
//        System.out.println("solution2 = " + solution2);
//        System.out.println("기대값 : 5");
//
        int solution = solution(20_000);
        System.out.println("solution = " + solution);


    }
}
