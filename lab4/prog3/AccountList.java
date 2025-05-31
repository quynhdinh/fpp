package prog3;

import employeeinfo.Account;

public class AccountList {
    private final int INITIAL_LENGTH = 2;
    private Account[] strArray;
    private int size;

    public AccountList() {
        strArray = new Account[INITIAL_LENGTH];
        size = 0;
    }

    public void add(Account s) {
        if (size == strArray.length) {
            resize();
        }
        strArray[size++] = s;
    }

    public Account get(int i) {
        return strArray[i];
    }

    public boolean find(String s) {
        for (int i = 0; i < size; i++)
            if (strArray[i].equals(s))
                return true;
        return false;
    }

    public void insert(Account s, int pos) {
        if (strArray.length == size)
            resize();
        for (int i = size; i >= pos + 1; i--)
            strArray[i] = strArray[i - 1];
        strArray[pos] = s;
        size++;
    }

    public boolean remove(Account s) {
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
        Account[] new_array = new Account[size * 2];
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

}