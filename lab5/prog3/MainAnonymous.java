package lab5;

import java.util.Arrays;
import java.util.Comparator;

public class MainAnonymous {
    public static void main(String[] args) {
        String[] strArray = new String[]{"andy", "mike", "joe", "allen", "stephan"};
        boolean ascending = true;
        StringSort ss = new StringSort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ascending ? (o1.length() - o2.length()) :
                        (o2.length() - o1.length());
            }
        });
        System.out.println(Arrays.toString(ss.stringSort(strArray)));
    }
}