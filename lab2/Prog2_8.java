public class Prog8 {
    static int min(int[] arrayOfInts) {
        int minNum = arrayOfInts[0];
        for (int i = 1; i < arrayOfInts.length; i++) {
            if (arrayOfInts[i] < minNum) minNum = arrayOfInts[i];
        }
        return minNum;
    }
}