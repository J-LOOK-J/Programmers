package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 수열_2559 {

    static ArrayList<Integer> list = new ArrayList();

    public static void main(String[] args) throws IOException {

        /*   ---------- 입력 -------------*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        int keepDays = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < length; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        /*   ---------- 입력 종료 -------------*/

        int[] sumlist = new int[length - keepDays + 1];


        for (int i = 0; i < length ; i++) {
            for (int k = 0; k < keepDays; k++) {
                if (i - k >= 0 && i - k < sumlist.length) {
                    sumlist[i - k] += list.get(i);
                }
            }
        }

        int max = sumlist[0];
        for (int num : sumlist) {
            max = Math.max(max, num);
        }

        System.out.println(max);
    }
}
