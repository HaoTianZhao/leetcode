public class Main {
    public static void main(String[] args) {
        int[][] a = new int[4][];
        a[0] = new int[]{1, 2};
        a[1] = new int[]{3,4,5};
        a[2] = new int[]{3};
        a[3] = new int[]{3,4,5};

        System.out.println(a[0].length);
        System.out.println(a[1].length);
        System.out.println(a[2].length);
        System.out.println(a[3].length);
    }
}
