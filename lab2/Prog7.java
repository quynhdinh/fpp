class Prog7 {
    private static int[][] a = new int[8][2];

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            int one = RandomNumbers.getRandomInt(1, 99);
            int two = RandomNumbers.getRandomInt(1, 99);
            a[i][0] = one;
            a[i][1] = two;
        }
        draw(0, 4);
        draw(5, 8);
    }

    public static void draw(int from, int to) {
        for (int i = from; i < to; i++) {
            if (a[i][0] < 10) {
                for (int j = 0; j < 2; j++) System.out.print(" ");
            } else
                for (int j = 0; j < 1; j++) System.out.print(" ");
            System.out.print(a[i][0]);
            System.out.print("\t");
        }
        System.out.println();
        for (int i = from; i < to; i++) {
            System.out.print("+");
            if (a[i][1] < 10) {
                System.out.print(" ");
            }
            System.out.print(a[i][1]);
            System.out.print("\t");
        }
        System.out.println();
        for (int i = from; i < to; i++) {
            System.out.print("---");
            System.out.print(" ");
        }
        for (int i = 0; i < 2; i++)
            System.out.println();
    }
}
