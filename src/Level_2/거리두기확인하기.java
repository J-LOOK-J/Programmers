package Level_2;

public class 거리두기확인하기 {

    /*방역을 지키지 않는 케이스
     * 조건: 모든 기준은 중심에 P를 두고 판단한다.
     * 상하좌우에 P가 있는경우
     * 상하좌우중 O가 있으며 그 방향으로 한칸 더 전진시 P가 있는경우
     * 대각선 기준으로 P가 있으며 그 P와 이루는 사각형에 O가 있는경우*/

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            int check = checkRoom(places[i]);
            answer[i] = check;
        }

        return answer;
    } /* soltuion */


    // 해당 room 이 방역을 지키고있는지 아닌지 판단 (만족:1 불만족: 0)
    public int checkRoom(String[] place) {

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                // P의 위치를 찾는다.
                if (place[x].charAt(y)=='P') {
                    //방역을 만족하는지 찾는 조건 판단.
                    if (!checkSafe(place, x, y)) {
                        return 0;
                    }
                }
            }
        }

        return 1;
    } /* checkRoom */

    // 해당 P가 방역을 지키는지 아닌지 판단한다.
    public boolean checkSafe(String[] place, int x, int y) {
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < 4; i++) {

            int moveX = x + moves[i][0];
            int moveY = y + moves[i][1];

            // 범위가 5x5이내인지 판단.
            if (checkOut(moveX, moveY)) {
                continue;
            }


            if (place[moveX].charAt(moveY) == 'P') {            // 상하좌우에 P가 존재하면 불만족
                return false;
            } else if (place[moveX].charAt(moveY) == 'O') {     // 상하좌우가 O으로 뚫려있는경우 그 O을 기준으로 상하좌우에 P가 존재하면 불만족

                for (int k = 0; k < 4; k++) {

                    int nearX = moveX + moves[k][0];
                    int nearY = moveY + moves[k][1];

                    if (checkOut(nearX, nearY) || (nearX == x && nearY == y)) {
                        continue;
                    }
                    if (place[nearX].charAt(nearY) == 'P') {
                        return false;
                    }
                }
            }
        }
        return true;
    } /* checkSafe */

    // 범위가 5x5이내인지 판단.
    public boolean checkOut(int x, int y) {
        if (x < 0 || x >= 5 || y < 0 || y >= 5) {
            return true;
        }
        return false;
    }
}
