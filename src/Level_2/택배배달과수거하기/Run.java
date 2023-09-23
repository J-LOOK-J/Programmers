package Level_2.택배배달과수거하기;

public class Run {

    public static void main(String[] args) {
        Solution ss = new Solution();

//        int cap = 4;
//        int n = 5;
//        int[] deliveries = {1, 0, 3, 1, 2};
//        int[] pickups = {0, 3, 0, 4, 0};
//        result = 16

//        int cap = 2;
//        int n = 7;
//        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
//        int[] pickups = {0, 2, 0, 1, 0, 2, 0};
//        result = 30

//        int cap = 2;
//        int n = 2;
//        int[] deliveries = { 0, 0};
//        int[] pickups = {0, 4};
//        result = 8

//        int cap = 4;
//        int n = 4;
//        int[] deliveries = {25, 24, 51, 0};
//        int[] pickups = {51, 0, 0, 49};
//        result = 140

//        int cap = 4;
//        int n = 5;
//        int[] deliveries = {8, 0, 8, 0, 4};
//        int[] pickups = {0, 0, 0, 0, 20};
//        result = 50

//        int cap = 4;
//        int n = 5;
//        int[] deliveries = {1, 1, 1, 1, 1};
//        int[] pickups = {1, 1, 1, 1, 1};
//        result = 12


//        int cap = 2;
//        int n = 3;
//        int[] deliveries = {4,2,1};
//        int[] pickups = {0,4,1};
//        result = 16

        int cap = 2;
        int n = 3;
        int[] deliveries = {0, 6, 13};
        int[] pickups = {19, 0, 1};
//        result = 54



        long results = ss.solution(cap, n, deliveries, pickups);
        System.out.println("results = " + results);


    }
}
