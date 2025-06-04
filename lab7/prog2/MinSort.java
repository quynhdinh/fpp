package prog2;

public class MinSort {
    public static void main(String[] args) {
        MinSort ms = new MinSort();
        String s = "zwxuabfkafutbbbb";
        String res = ms.sort(s);
        System.out.println(res);
    }

    public String sort(String _s) {
        if (_s.isEmpty())
            return _s;
        StringBuilder s = new StringBuilder(_s);
        int smallest_index = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) < s.charAt(smallest_index))
                smallest_index = i;
        char firstChar = s.charAt(0);
        s.setCharAt(0, s.charAt(smallest_index));
        s.setCharAt(smallest_index, firstChar);
        return s.charAt(0) + sort(s.substring(1));
    }
}