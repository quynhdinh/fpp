package prog1;

public class Prog1 {

    private String[] strArray;
    final static int DEFAULT_SIZE = 2;
    private int size;

    public Prog1() {
        strArray = new String[DEFAULT_SIZE];
        size = 0;
    }

    /******* sorting methods ********/
    public void minSort() {
        if (strArray == null || size <= 1)
            return;
        for (int i = 0; i < size; ++i) {
            int nextMinPos = minpos(i, size - 1);
            swap(i, nextMinPos);
        }
    }

    void swap(int i, int j) {

        String temp = strArray[i];
        strArray[i] = strArray[j];
        strArray[j] = temp;

    }

    // find minimum of arr between the indices bottom and top
    public int minpos(int bottom, int top) {
        int minIndex = bottom;
        String minValue = strArray[bottom];
        for (int i = bottom; i <= top; ++i) {
            if (strArray[i].compareTo(minValue) < 0) {
                minIndex = i;
                minValue = strArray[i];
            }
        }
        return minIndex;
    }

    // search a sorted array
    boolean binSearchIt(String val) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = strArray[mid].compareTo(val);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    void add(String s) {
        if (size == strArray.length) {
            resize();
        }
        strArray[size++] = s;
    }

    void resize() {
        String[] temp = new String[strArray.length * 2];
        System.arraycopy(strArray, 0, temp, 0, strArray.length);
        strArray = temp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; ++i) {
            sb.append(strArray[i] + ", ");
        }
        sb.append(strArray[size - 1] + "]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Prog1 prog1 = new Prog1();
        String[] testArr = { "big", "small", "tall", "short", "round", "square", "enormous", "tiny", "gargantuan",
                "lilliputian", "numberless", "none", "vast", "miniscule" };
        for (int i = 0; i < testArr.length; i++) {
            prog1.add(testArr[i]);
        }
        prog1.minSort();
        System.out.println("The list in sorted order:");
        System.out.println(prog1.toString());
        System.out.println();
        System.out.println("\"number\" is in the list? " + prog1.binSearchIt("number"));
        System.out.println("\"tiny\" is in the list? " + prog1.binSearchIt("tiny"));
    }

}
