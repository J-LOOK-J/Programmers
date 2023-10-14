package Level_2.메뉴리뉴얼;

import java.util.*;

public class Solution {

    private HashMap<String, Integer> hashMap = new HashMap<>();
    private char[] charAssem;
    private int index;
    private int max = 0;
    Queue<String> maxValue = new LinkedList<>();

    public String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        String[] answer = {};
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();

        for (int limit : course) {

            /****** 한자씩 char에 담기 ******/
            for (String order : orders) {
                char[] charArray = order.toCharArray();
                Arrays.sort(charArray);

                boolean[] visited = new boolean[order.length()];
                charAssem = new char[limit];
                index = 0;
                dfs(charArray, visited, limit, 0, sb);  // limit(코스조합) 를 변수로 보내 해당 갯수 조합의 경우만 판단

            }

            // limit 갯수 조합에서 가장 큰 주문 누적수를 가진 데이터를 list에 옮겨담는다.
            while (!maxValue.isEmpty()) {
                list.add(maxValue.poll());
            }
            max = 0;    // max값 초기화

        }
            Collections.sort(list);

            answer = list.toArray(new String[0]);

        return answer;
    }


    // dfs
    public void dfs(char[] charArray, boolean[] visited, int limit, int start, StringBuilder sb) {

        // 배열에 길이가 limit 과 동일한 경우에만 counting
        if (index == limit) {
            String temp = String.valueOf(charAssem);
            if (hashMap.containsKey(temp)) {
                if (hashMap.get(temp) + 1 > max) {
                    max = hashMap.get(temp) + 1;
                    maxValue.clear();
                    maxValue.add(temp);
                } else if (hashMap.get(temp) + 1 == max) {
                    maxValue.add(temp);
                }
                hashMap.put(temp, hashMap.get(temp) + 1);

            } else {
                hashMap.put(temp, 1);
            }
            return;
        }

        // dfs
        for (int i = start; i < charArray.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                charAssem[index++] = charArray[i];
                dfs(charArray, visited, limit, i + 1, sb);
                index--;
                visited[i] = false;
            }
        }

    }

}
