package Level_1;

import java.util.Stack;

public class 크레인_인형뽑기_게임{

    static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {

                // 뽑을 값이 없으면 for문 반복
                if (board[i][move-1] == 0) {
                    continue;
                }

                // stack 이 비어있지 않고 이전 값과 동일한경우
                if(!stack.isEmpty() && stack.lastElement() == board[i][move-1]){
                    stack.pop();
                    board[i][move-1] = 0;
                    answer += 2;
                }else{
                    stack.push(board[i][move-1]);
                    board[i][move-1] = 0;
                }

                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
//        {0, 0, 0, 0, 0},
//        {0, 0, 1, 0, 3},
//        {0, 2, 5, 0, 1},
//        {4, 2, 4, 4, 2},
//        {3, 5, 1, 3, 1}
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int solution1 = solution(board, moves);
        System.out.println("solution1 = " + solution1);
        System.out.println("기대값: 4");

        int[][] board3 = {{3, 3, 3, 3, 3}, {3, 3, 3, 3, 3}, {3, 3, 3, 3, 3}, {3, 3, 3, 3, 3}, {3, 3, 3, 3, 3}};
        int[] moves3 = {1, 5, 3, 5, 1, 2, 1, 4};
        int solution3 = solution(board3, moves3);
        System.out.println("solution3 = " + solution3);
        System.out.println("기대값: 8");

        int[][] board4 = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int[] moves4 = {1, 5, 3, 5, 1, 2, 1, 4};
        int solution4 = solution(board4, moves4);
        System.out.println("solution4 = " + solution4);
        System.out.println("기대값: 0");

    }
}
