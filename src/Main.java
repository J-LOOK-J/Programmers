public class Main {
    public static void main(String[] args) {

        int[] test = new int[3];

        for (int i : test) {
            System.out.println("i = " + i);
        }

        System.out.println("************");
        System.out.println(test);

        test[0] = 0;
        int i = ++test[1];
        System.out.println(i);
        System.out.println("Hello world!");
    }
}
