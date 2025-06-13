package lab11.prog2;

import java.util.HashMap;
import java.util.List;

public class Schur {
    boolean checkForSum(List<Integer> list, Integer z) {
        if (list == null || list.size() < 2) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Integer x = list.get(i);
            int y = z - x;
            if (map.containsKey(y)) {
                return true;
            }
            map.put(x, i);
        }
        return false;
    }

    public static void main(String[] args) {
        Schur schur = new Schur();
        List<Integer> list = List.of(9, 8, 20, 8, 2, 5);
        int z = 7;
        boolean result = schur.checkForSum(list, z);
        System.out.printf("Does the list %s contain two numbers that sum up to " + z + "? \n" + result, list);
    }
}