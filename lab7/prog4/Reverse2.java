package prog4;

import java.util.Arrays;

class Reverse2 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 7, 9, 13};
        reverse(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    static void reverse(int[] a, int i, int j) {
        if (i > j) return;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        reverse(a, i + 1, j - 1);
    }
}