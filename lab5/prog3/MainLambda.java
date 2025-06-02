package lab5;

import java.util.Arrays;

public class MainLambda {
    public static void main(String[] args) {
        String[] testStrings = {"andy", "mike", "joe", "allen", "stephan"};
        boolean ascending = true;
        StringSort ss = new StringSort((o1, o2) -> (ascending ? (o1.length() - o2.length()) :
                (o2.length() - o1.length())));
        System.out.println(Arrays.toString(ss.stringSort(testStrings)));
    }
}