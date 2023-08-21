package Level_2;

import java.util.LinkedList;

public class 게임_맵_최단거리 {

    static int[] dRow = {-1, 0, 0, 1};
    static int[] dCol = {0, -1, 1, 0};

    static int solution(int[][] maps) {
        int answer = 0;

        int[][] visitied = new int[maps.length][maps[0].length];

        //bfs
        bfs(maps, visitied);

        // 도착 지점의 최단거리 값 가져오기
        answer = visitied[maps.length - 1][maps[0].length - 1];

        // 도착 지점의 값이 0 이면 도달 하는 방법이 없는 경우이므로 return -1
        if (answer == 0) {
            return -1;
        }

        return answer;
    }

    static void bfs(int[][] maps, int[][] visitied) {
        LinkedList<int[]> queue = new LinkedList<>();

        // 시작 위치 셋팅
        queue.add(new int[]{0, 0});
        visitied[0][0] = 1;

        while (!queue.isEmpty()) {

            int[] peek = queue.pop();

            int row = peek[0];
            int col = peek[1];

            for (int i = 0; i < 4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if (nRow < 0 || nCol < 0 || nRow >= maps.length || nCol >= maps[0].length) {
                    continue;
                }
                if (maps[nRow][nCol] == 1 && visitied[nRow][nCol] == 0) {
                    visitied[nRow][nCol] = visitied[row][col] + 1;
                    queue.add(new int[]{nRow, nCol});
                }

                // 도착 지점에 도달하면 while 문 빠져나오기
                if (nRow == maps.length && nCol == maps[0].length) {
                    break;
                }
            }   // for
        }   // while
    }



    public static void main(String[] args) {
        int solution1 = solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}});
        System.out.println(solution1);
        System.out.println("기대값 11");

    }
}
