package prog4;

import java.util.Arrays;

class Reverse {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[4];
        reverse(b, a, 0, a.length - 1);
        System.out.println(Arrays.toString(b));
    }

    public static void reverse(int[] res, int[] a, int i, int j) {
        if (i >= a.length || j < 0) return;
        res[i] = a[j];
        reverse(res, a, i + 1, j - 1);
    }
}