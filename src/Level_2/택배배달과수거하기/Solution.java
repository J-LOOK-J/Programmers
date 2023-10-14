package Level_2.택배배달과수거하기;
/*
* 설계
* 1. 끝집부터 가까운 집순으로 이동
* 2. 끝부터 deliveries , pickups 를 더해줌
* 3. 각 합이 cap 과 동일하거나 커질때 물류창고를 방문.
* */
public class Solution {

    private long answer = 0;
    private int sumDeliv = 0;
    private int sumPickup = 0;
    private int length = 0;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        for (int i = n - 1; i >= 0; i--) {

            // 가야할 집들중 가장 먼 집의 거리 구하기
            if (length <= 0) {
                if (pickups[i] > 0 || deliveries[i] > 0) {
                    length = i + 1;
                }
            }

            sumPickup += pickups[i];
            sumDeliv += deliveries[i];

            // 수거 용량이 꽉찬경우
            if (sumPickup >= cap) {

                //
                if (sumDeliv < cap) {
                    deliveries = removeBox(deliveries, sumDeliv, cap, i);
                }

                pickups[i] = sumPickup - cap;
                deliveries[i] = (sumDeliv - cap) > 0 ? sumDeliv - cap : 0;

                // 전부 수거 하지 못한경우 for문 반복을 위해 i증가
                if (pickups[i] > 0 || deliveries[i] > 0) {
                    i++;
                }

                setValue(); // answer, length, sum~ 값 계산


            // 배달 용량'만' 꽉 찬 경우
            } else if (sumDeliv >= cap) {

                // 돌아오면서 수거하기
                pickups = removeBox(pickups, sumPickup, cap, i);

                deliveries[i] = sumDeliv - cap;
                pickups[i] = 0;

                // 전부 수거 하지 못한경우 for문 반복을 위해 i증가
                if (deliveries[i] > 0) {
                    i++;
                }

                setValue(); // answer, length, sum~ 값 계산

            }

        } //for

        // 마지막 방문 집 거리 더해주기
        answer += length * 2;

        return answer;
    } //solution()

    // answer, length, sum 값 계산
    private void setValue() {
        // 거리 계산
        answer += (long) (length * 2);
        // 값 초기화
        length = 0;
        sumPickup = 0;
        sumDeliv = 0;
    }


    // 남은 공간만큼 배달 or 수거하기
    private int[] removeBox(int[] remove, int sum, int cap, int i) {
        int remainScope = cap - sum;
        for (int k = i - 1; k >= 0; k--) {

            if (remove[k] <= 0) {
                continue;
            }

            if (remove[k] >= remainScope) {
                remove[k] -= remainScope;
                return remove;
            } else {
                remainScope -= remove[k];
                remove[k] = 0;
            }

        }

        return remove;
    }   // removeBox()

}
