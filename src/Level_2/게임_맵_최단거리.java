package Level_2;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class 게임_맵_최단거리 {

    static int[] dRow = {-1, 0, 0, 1};
    static int[] dCol = {0, -1, 1, 0};

    static int solution(int[][] maps) {
        int answer = 0;

        int[][] visitied = new int[maps.length][maps[0].length];

        //bfs
        bfs(maps, visitied);

        answer = visitied[maps.length - 1][maps[0].length - 1];

        if (answer == 0) {
            return -1;
        }

        return answer;
    }

    static void bfs(int[][] maps, int[][] visitied) {
        LinkedList<int[]> queue = new LinkedList<>();
        LinkedList<int[]> road = new LinkedList<>();

        int result = 0;
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
                    road.add(new int[]{nRow,nCol});
                    queue.add(new int[]{nRow, nCol});
                }


                if (nRow == maps.length && nCol == maps[0].length) {
                    break;
                }
            }


        }


    }



    public static void main(String[] args) {
        int solution1 = solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}});
        System.out.println(solution1);
        System.out.println("기대값 11");

    }
}
