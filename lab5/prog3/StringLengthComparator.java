package lab5;

import java.util.Arrays;
import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {

    boolean ascending;

    StringLengthComparator(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(String o1, String o2) {
        return ascending ? (o1.length() - o2.length()) :
                (o2.length() - o1.length());
    }

    public static void main(String[] args) {
        String[] strArray = new String[]{"andy", "mike", "joe", "allen", "stephan"};
        StringSort ss = new StringSort(new StringLengthComparator(true));
        String[] strings = ss.stringSort(strArray);
        System.out.println(Arrays.toString(strings));
    }
}