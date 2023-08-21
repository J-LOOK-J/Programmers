package Level_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class 소수만들기_응용 {

    public static void main(String[] args) {

        소수만들기Solution solution = new 소수만들기Solution();
//        int[] val1 = {1, 2, 3, 4};
        int[] val1 = {1, 2, 3, 10 };
        int solution1 = solution.solution(val1);
        System.out.println("solution = " + solution1);
        System.out.println("기대값: 1");


/*        소수만들기Solution solution2 = new 소수만들기Solution();
        int[] val2 = {1, 2, 7, 6, 4};
        int solution3 = solution2.solution(val2);
        System.out.println("solution2 = " + solution3);
        System.out.println("기대값: 4");*/


    }
}

class 소수만들기Solution {
    private int answer = 0;
    private boolean[] alreadyCheck;
    private HashMap<Integer, Boolean> hashMap;

    public int solution(int[] nums) {

        boolean[] visited = new boolean[nums.length];

        hashMap = new HashMap<>();


        dfs(nums, 1, visited, 0);

        return answer/6;
    }

    public void dfs(int[] nums, int depth, boolean[] visited, int checkNum) {

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i] && depth <= 3) {
                checkNum += nums[i];
                visited[i] = true;
                dfs(nums, depth + 1, visited, checkNum);
                visited[i] = false;
                checkNum -= nums[i];
            }

        }

        if (depth == 4 ) {

            System.out.println(checkNum);
            if (isPrimeNum(checkNum)) {
                answer++;

            }
        }
    }

    public boolean isPrimeNum(int num) {

        if(hashMap.get(num) != null){

            if (hashMap.get(num) == false) {
                return false;
            } else if (hashMap.get(num) == true) {
                return true;
            }
        }


        if (num % 2 == 0) {
            hashMap.put(num, false);
            return false;
        }

        int sqrt = (int) Math.sqrt(num) + 1;

        for (int i = 3; i < sqrt; i = i + 2) {
            if (num % i == 0) {
                hashMap.put(num, false);
                return false;
            }
        }
        hashMap.put(num, true);
//        System.out.println("소수 = "+num);
        return true;

    }
}