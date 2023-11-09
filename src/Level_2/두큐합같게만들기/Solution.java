package Level_2.두큐합같게만들기;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {

        int count = 0;

        Queue<Long> qu1 = new LinkedList();
        Queue<Long> qu2 = new LinkedList();

        for (int i = 0; i < queue1.length; i++) {
            qu1.add((long) queue1[i]);
            qu2.add((long) queue2[i]);
        }

        Long sum1 = (long) Arrays.stream(queue1).sum();
        Long total = sum1 + Arrays.stream(queue2).sum();
        Long average = total / 2;
        if (total % 2 != 0) {
            return -1;
        }

        // 아래 조건에서 *4부분 왜 *4인지 더 고민해보기
        while (!qu1.isEmpty() && !qu2.isEmpty() && count <= queue1.length * 4) {

            if (sum1 > average) {
                sum1 -= qu1.peek();

                qu2.add(qu1.poll());


            } else if (sum1 < average) {
                sum1 += qu2.peek();

                qu1.add(qu2.poll());

            } else {
                return count;
            }

            count++;

        }

        return -1;
    }
}
