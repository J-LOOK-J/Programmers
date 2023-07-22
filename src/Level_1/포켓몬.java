package Level_1;

import java.util.HashSet;

public class 포켓몬 {

    static int solution(int[] nums) {
        int max = nums.length / 2;
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
            if (hashSet.size() >= max) {
                return max;
            }
        }

        return hashSet.size();

    }

    public static void main(String[] args) {
        int solution1 = solution(new int[]{3, 1, 2, 3});
        System.out.println("solution1 = " + solution1);
        System.out.println("예상 기대값 = 2");

        int solution2 = solution(new int[]{3,3,3,2,2,4});
        System.out.println("solution2 = " + solution2);
        System.out.println("예상 기대값 = 3");

        int solution3 = solution(new int[]{3,3,3,2,2,2});
        System.out.println("solution3 = " + solution3);
        System.out.println("예상 기대값 = 2");

    }
}
