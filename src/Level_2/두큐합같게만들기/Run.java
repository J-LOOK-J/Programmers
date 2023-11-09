package Level_2.두큐합같게만들기;

public class Run {

    public static void main(String[] args) {


        Solution ss = new Solution();

//        int[] queue1 = {3, 2, 7, 2};
//        int[] queue2 = {4, 6, 5, 1};

//        int[] queue1 = {1, 2, 1, 2};
//        int[] queue2 = {1, 10, 1, 2};

//        int[] queue1 = {1, 1};
//        int[] queue2 = {1, 5};

        int[] queue1 = {1, 4};
        int[] queue2 = {4, 8};


        int result = ss.solution(queue1, queue2);

        System.out.println(result);

    }

}
