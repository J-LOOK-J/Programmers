package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수_찾기_1920 {

    static int[] a ;
    static int[] result;

    public static void main(String[] args) throws IOException {
        int countA;
        int countM;
        int[] m;

        /*   ---------- 입력 -------------*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        countA = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[countA];
        for (int i = 0; i < countA; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        countM = Integer.parseInt(br.readLine());

        m = new int[countM];
        result = new int[countM];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countM; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }
        /*   ---------- 입력 종료 -------------*/

        /*  ----------  이진 탐색  ----------  */
        Arrays.sort(a);

        // m 배열의 값을 돌아가며 체크해 있으면 1을 없으면 0을 담아주기
        for (int i = 0; i < m.length; i++) {
            result[i] = binarySearch(m[i], 0, a.length - 1);
        }

        for (int i : result) {
            System.out.println(i);
        }

    }

    // Binary Search : 이진탐색 알고리즘.
    static int binarySearch(int checkNum, int startIndex, int endIndex) {
        int middle = (startIndex + endIndex) / 2;

        // = 이 없으면 checkNum 의 값이 endIndex 와 같은경우를 체크하지 못함
        while (startIndex <= endIndex) {

            // 재귀함수에서 1혹은 0을 반환시 그 값을 최초 호출하는 곳으로 가져오기 위해 재귀함수에 return 을 붙여줌.
            if (checkNum < a[middle]) {
                return binarySearch(checkNum, startIndex, middle - 1);
            } else if (checkNum > a[middle]) {
                return binarySearch(checkNum, middle + 1, endIndex);
            } else {
                return 1;
            }

        }

        return 0;


    }

}
