import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Prog6 {
    public static String[] removeDups(String[] input) {
        List<String> result = new ArrayList<>();
        for (String str : input) {
            boolean exists = false;
            for (String re : result)
                if (re.equals(str)) {
                    exists = true;
                    break;
                }
            if (!exists) result.add(str);
        }
        String[] res = new String[result.size()];
        for (int i = 0; i < result.size(); i++)
            res[i] = result.get(i);
        return res;
    }

    @Test
    public void testRemoveDups() {
        String[] testData = {"horse", "dog", "cat", "horse", "dog"};
        String[] strings = removeDups(testData);
        String[] correct = {"horse", "dog", "cat"};
        boolean ok = true;
        for (int i = 0; i < correct.length; i++) {
            if (!correct[i].equals(strings[i])) ok = false;
        }
        assertTrue(ok);
    }
}