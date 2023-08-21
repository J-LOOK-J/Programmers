package Level_2;

import java.util.PriorityQueue;

public class 더맵게 {

    public static void main(String[] args) {
        int solution = solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        System.out.println("solution = " + solution);
        System.out.println("기대값: 2");

    }


    static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        // scoville 을 오름차순으로 pQueue 에 insert
        for (int i : scoville) {
            pQueue.add(i);
        }

        // pQueue 의 최솟값이 K 보다 작지 않을때까지 진행
        while (pQueue.peek() < K) {
            // pQueue 의 값이 1개 이면 더이상 진행할 수 없으므로 실패
            if (pQueue.size() < 2) {
                return -1;
            }
            // 가장 작은 값2개를 꺼내 섞은 후 add
            int scov = pQueue.poll() + pQueue.poll() * 2;
            pQueue.add(scov);
        }

        // 섞는 과정이 몇번이 일어났는지 길이 변화로 체크
        answer = scoville.length - pQueue.size();
        return answer;
    }

}
