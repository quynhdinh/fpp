package prog3;

import java.util.Arrays;

public class MyStringList {
    private final int INITIAL_LENGTH = 2;
    private String[] strArray;
    private int size;

    public MyStringList() {
        strArray = new String[INITIAL_LENGTH];
        size = 0;
    }

    public void add(String s) {
        if (size == strArray.length) {
            System.out.println(size + " " + strArray.length);
            resize();
        }
        strArray[size++] = s;
    }

    public String get(int i) {
        return strArray[i];
    }

    public boolean find(String s) {
        for (String string : strArray) {
            if (string.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public void insert(String s, int pos) {
        if (strArray.length == size)
            resize();
    }

    public boolean remove(String s) {
        for (int i = 0; i < size; i++) {
            if (s.equals(strArray[i])) {
                for (int j = i + 1; j < size; j++)
                    strArray[j - 1] = strArray[j];
                size--;
                return true;
            }
        }
        return false;
    }


    private void resize() {
        System.out.println("Resizing...");
        strArray = Arrays.copyOf(strArray, size * 2);
    }

    public String toString() {
        return Arrays.toString(this.strArray);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyStringList l = new MyStringList();
        l.add("Bob");
        l.add("Steve");
        l.add("Susan");
        l.add("Mark");
        l.add("Dave");
        System.out.println("The list of size " + l.size() + " is " + l);
        l.remove("Mark");
        l.remove("Bob");
        System.out.println("The list of size " + l.size() + " is " + l);
        l.insert("Richard", 3);
        System.out.println("The list of size " + l.size() + " after inserting Richard into pos 3 is " + l);
        l.insert("Tonya", 0);
        System.out.println("The list of size " + l.size() + " after inserting Tonya into pos 0 is " + l);
    }

}
