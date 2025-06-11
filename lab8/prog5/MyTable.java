package lab8.prog5;

public class MyTable {
	private Entry[] entries;

	public MyTable() {
		entries = new Entry[26];
	}

	// returns the String that is matched with char c in the table
	public String get(char c) {
		for (MyTable.Entry entry : entries) {
			if (entry.ch == c) {
				return entry.str;
			}
		}
		return null;
	}

	// adds to the table a pair (c, s) so that s can be looked up using c
	public void add(char c, String s) {
		if (entries[c - 'a'] == null) {
			entries[c - 'a'] = new Entry(c, s);
		} else {
			entries[c - 'a'].str = s;
		}
	}

	// returns a String consisting of nicely formatted display
	// of the contents of the table
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (MyTable.Entry entry : entries)
			if (entry != null) {
				sb.append(entry);
				sb.append("\n");
			}
		return sb.toString();
	}

	public static void main(String[] args) {
		MyTable t = new MyTable();
		t.add('a', "Andrew");
		t.add('b', "Billy");
		t.add('w', "Willie");
		System.out.println(t);
	}

	private class Entry {
		char ch;
		String str;

		Entry(char ch, String str) {
			this.str = str;
			this.ch = ch;
		}

		public String toString() {
			return ch + "->" + str;
		}
	}
}