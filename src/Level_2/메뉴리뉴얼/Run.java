package Level_2.메뉴리뉴얼;

public class Run {

    public static void main(String[] args) {

        String[] sample1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] sample2 = {2,3,4};
//        ["AC", "ACDE", "BCFG", "CDE"]

//        String[] sample1 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        int[] sample2 = {2,3,5};
//        ["ACD", "AD", "ADE", "CD", "XYZ"]

//        String[] sample1 = {"XYZ", "XWY", "WXA"};
//        int[] sample2 = {2,3,4};
//        ["WX", "XY"]

        Solution ss = new Solution();

        String[] solution = ss.solution(sample1, sample2);
        System.out.println("solution = " + solution);
        for (String s : solution) {
            System.out.println("s = " + s);
        }

    }
}
