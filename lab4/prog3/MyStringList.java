package prog3;

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
            resize();
        }
        strArray[size++] = s;
    }

    public String get(int i) {
        return strArray[i];
    }

    public boolean find(String s) {
        for (int i = 0; i < size; i++)
            if (strArray[i].equals(s))
                return true;
        return false;
    }

    public void insert(String s, int pos) {
        if (strArray.length == size)
            resize();
        for (int i = size; i >= pos + 1; i--)
            strArray[i] = strArray[i - 1];
        strArray[pos] = s;
        size++;
    }

    public boolean remove(String s) {
        for (int i = 0; i < size; i++)
            if (s.equals(strArray[i])) {
                for (int j = i + 1; j < size; j++)
                    strArray[j - 1] = strArray[j];
                size--;
                strArray[size] = null;
                return true;
            }
        return false;
    }


    private void resize() {
//        System.out.println("Resizing...");
        String[] new_array = new String[size * 2];
        if (size >= 0) System.arraycopy(strArray, 0, new_array, 0, size);
        strArray = new_array;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(strArray[i]);
            if (i != size - 1) res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyStringList l = new MyStringList();
        l.add("Bob");
        System.out.println("The list of size " + l.size() + " is " + l);
        l.add("Steve");
        System.out.println("The list of size " + l.size() + " is " + l);
        l.add("Susan");
        System.out.println("The list of size " + l.size() + " is " + l);
        l.add("Mark");
        System.out.println("The list of size " + l.size() + " is " + l);
        l.add("Dave");
        System.out.println("The list of size " + l.size() + " is " + l);
        l.remove("Mark");
        System.out.println("The list of size " + l.size() + " is " + l);
        l.remove("Bob");
        System.out.println("The list of size " + l.size() + " is " + l);
    }
}
