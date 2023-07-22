package Level_1;

import java.util.HashSet;

public class 과일장수 {

    private static int solution(int[] score, int k, int m ) {
        int answer = 0;
        int temp = 0;

        // 정렬
        /*for (int i = 0; i < score.length - 1; i++) {
            for (int n = i + 1; n < score.length; n++) {
                if (score[i] < score[n]) {
                    temp = score[n];
                    score[n] = score[i];
                    score[i] = temp;
                }
            }
        }*/

        //퀵 정렬
        quickSort(score, 0, score.length - 1 );


        // m개씩 끊어서 계산
        int limit = score.length / m;
        for (int i = 0; i < limit; i++) {
            answer += score[i * m + m - 1] * m;
        }

        return answer;
    }

    static void quickSort(int[] nums, int startIdx, int endIdx) {

        if (startIdx < endIdx) {
            int middleIdx = partition(nums, startIdx, endIdx);
            quickSort(nums, startIdx, middleIdx -1);
            quickSort(nums, middleIdx, endIdx);
            
        }
    }

    static int partition(int[] nums, int startIdx, int endIdx) {
        int middleIdx = (startIdx + endIdx) / 2;
        int pivot = nums[middleIdx];

        while (startIdx <= endIdx) {    // 중복된 값이 존재 하는 경우를 위해 = 를 붙여준다.
            while (nums[startIdx] > pivot) {
                startIdx++;
            }
            while (nums[endIdx] < pivot ) {
                endIdx--;
            }
            if (startIdx <= endIdx) {   //중복값을 위해 = 추가
                swap(nums, startIdx, endIdx);
                startIdx++;
                endIdx--;
            }
        }
        return startIdx;
    }

    static void swap(int[] nums, int startIdx, int endIdx) {
        int temp = nums[startIdx];
        nums[startIdx] = nums[endIdx];
        nums[endIdx] = temp;
    }


    public static void main(String[] args) {
        /*int solution1 = solution(new int[]{1, 2, 3, 1, 2, 3, 1}, 3, 4);
        System.out.println("solution1 = " + solution1);
        System.out.println("예상 결과 : 8");*/

        int solution2 = solution(new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}, 4, 3 );
        System.out.println("solution2 = " + solution2);
        System.out.println("예상 결과 : 33");

    }
}
