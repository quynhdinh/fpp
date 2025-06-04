package lab7.prog3;

import java.util.LinkedList;

public class Merge {
    public LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> list3 = new LinkedList<>();

        if (list1.isEmpty()) {
            list3.addAll(list2);
            return list3;
        }

        if (list2.isEmpty()) {
            list3.addAll(list1);
            return list3;
        }
        int first1 = list1.getFirst();
        int first2 = list2.getFirst();

        if (first1 < first2) {
            list1.removeFirst();
            list3.add(first1);
        } else {
            list2.removeFirst();
            list3.add(first2);
        }

        // Recursive call and combine
        list3.addAll(merge(list1, list2));
        return list3;
    }

    public static void main(String[] args) {
        Merge merger = new Merge();

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(2);
        list1.add(5);
        list1.add(8);
        list1.add(11);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(3);
        list2.add(6);

        LinkedList<Integer> merged = merger.merge(list1, list2);
        System.out.println("Merged list: " + merged);
    }
}