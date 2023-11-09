package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 트리순회_1991 {

    static HashMap<String, String> leftMap = new HashMap<>();
    static HashMap<String, String> rightMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        /*   ---------- 입력 -------------*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

//        int countLine = Integer.parseInt(br.readLine());

        int countLine = Integer.parseInt(st.nextToken());
        String root = "";
        for (int i = 0; i < countLine; i++) {

//            StringTokenizer st = new StringTokenizer(br.readLine());
            st = new StringTokenizer(br.readLine());

            String middle = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            if (i == 0) {
                root = middle;
            }

            if (!left.equals(".")) {
                leftMap.put(middle, left);
            }

            if (!right.equals(".")) {
                rightMap.put(middle, right);
            }

        } //for

        /*   ---------- 입력 종료 -------------*/

        /*   ---------- 순회 시작 -------------*/
        preOrder(root);     // 전위순회
        System.out.println();
        inOrder(root);      // 중위순회
        System.out.println();
        postOrder(root);    // 후위순회
        /*   ---------- 순회 종료 -------------*/

    }

    public static void preOrder(String key) {

        System.out.print(key);
        if (leftMap.get(key) != null) {
            preOrder(leftMap.get(key));
        }
        if (rightMap.get(key) != null) {
            preOrder(rightMap.get(key));
        }

    }

    public static void inOrder(String key) {

        if (leftMap.get(key) != null) {
            inOrder(leftMap.get(key));
        }
        System.out.print(key);
        if (rightMap.get(key) != null) {
            inOrder(rightMap.get(key));
        }

    }

    public static void postOrder(String key) {
        if (leftMap.get(key) != null) {
            postOrder(leftMap.get(key));
        }
        if (rightMap.get(key) != null) {
            postOrder(rightMap.get(key));
        }
        System.out.print(key);
    }

}
