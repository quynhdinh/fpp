package lab9.prog1;

public class MyStringStack {
	private MyStringLinkedList list;

	public MyStringStack() {
		list = new MyStringLinkedList();
	}

	public String pop() {
		if (list.size() == 0) {
			return null;
		}
		String s = list.get(0);
		list.remove(0);
		return s;
	}

	public String peek() {
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	public void push(String s) {
		list.add(s);
	}

	public static void main(String[] args) {
		MyStringStack stack = new MyStringStack();
		stack.push("Bob");
		stack.push("Harry");
		stack.push("Alice");
		System.out.println("Popping…" + stack.pop());
		System.out.println("Peeking…." + stack.peek());
		System.out.println("Popping…" + stack.pop());
	}
}