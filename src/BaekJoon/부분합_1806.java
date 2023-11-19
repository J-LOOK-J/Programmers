package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합_1806 {

    public static void main(String[] args) throws IOException {

        /*   ---------- 입력 -------------*/
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int sum = 0;
        int count = 0;


        int[] list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        /*   ---------- 입력 끝 -------------*/

        // index 0 부터 숫자를 더해 sum을 넘으면 나온다.
        int i = 0;

        while (i < N) {
            sum += list[i++];
            if (sum >= S) {
                break;
            }
        }

        int sP = 0;     // 시작점
        int eP = i;     // 끝지점

        // index 0부터 끝까지 더한경우 합이 S 보다 작으면 0반환 크면 연속숫자를 반환
        if (sum >= S) {
            count = eP - sP;
        }

        // 앞에 index 는 빼고 뒤에 index 를 더해가며 sum 이상을 만든다.
        while (eP <= N && sum >= S ) {
            sum -= list[sP++];
            while( eP < N && sum < S){
                sum += list[eP++];
            }

            if (sum < S) {
                break;
            }else {
                count = Math.min(count, eP - sP);
            }
        }

        System.out.println(count);

    }
}
