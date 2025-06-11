package lab8.prog2;

public class MyStringLinkedList {
	Node header;

	MyStringLinkedList() {
		header = new Node(null);
	}

	// adds to the front of the list
	public void addFirst(String item) {
		Node n = new Node(item);
		// place new node after header and
		// establish links from new node to
		// surrounding nodes
		n.next = header.next;
		n.previous = header;

		// establish links from surrounding
		// nodes to the new node
		if (header.next != null) {
			header.next.previous = n;
		}
		header.next = n;
	}

	// adds to the end of the list
	public void addLast(String item) {
		Node n = new Node(item);
		// find last node
		Node last = header;
		while (last.next != null) {
			last = last.next;
		}
		// now last.next == null
		last.next = n;
		n.previous = last;
	}

	// removes node in last position
	public void removeLast() {
		// if list is empty, return
		if (header.next == null)
			return;

		Node current = header;
		// traverse the list until current.next is
		// null - then remove current
		while (current.next != null) {
			current = current.next;
		}
		// now current.next == null, so remove current
		Node previous = current.previous;
		// previous is not null since current is not header
		previous.next = null;
		current.previous = null;
	}

	// inserts a new Node containing data so that its
	// position in the list is now pos
	void insert(String data, int pos) {
		// pos insert to the first;
		if (pos == 0) {
			addFirst(data);
			return;
		}
		Node cur = header;
		while (pos-- > 0)
			cur = cur.next;
		Node new_node = new Node(data);
		new_node.next = cur.next;
		new_node.previous = cur;
		cur.next = new_node;
	}

	// attempts to remove the first Node that contains //data; if successful,
	// returns true; otherwise, false.
	boolean remove(String data) {
		Node cur = header;
		if (header.next != null && header.next.value.equals(data)) {
			header.next = header.next.next;
			return true;
		}
		while (cur.next != null) {
			if (cur.next.value.equals(data)) {
				if (cur.next.next == null) {
					cur.next = null;
					return true;
				}
				cur.next = cur.next.next;
				cur.next.next.previous = cur;
				return true;
			}
			cur = cur.next;
		}
		return false;
	}

	private void swap(Node n1, Node n2) {
		String temp = n1.value;
		n1.value = n2.value;
		n2.value = temp;
	}

	private Node minNode(Node node) {
		if (node.next == null)
			return node;
		Node res = null;
		Node cur = (node == header ? node.next : node);
		while (cur != null) {
			if (res == null) {
				res = cur;
				continue;
			}
			if (cur.value.compareTo(res.value) < 0) {
				res = cur;
			}
			cur = cur.next;
		}
		return res;
	}

	public boolean search(String s) {
		Node next = header.next;
		while (next != null && !next.value.equals(s)) {
			next = next.next;
		}
		// either next == null or next.value is s
		if (next == null)
			return false;
		else {// next.value.equals(s)
			return true;
		}
	}

	public String toString() {
		var sb = new StringBuffer();
		Node next = header.next;
		while (next != null) {
			sb.append(next.toString() + ", ");
			next = next.next;
		}
		var result = sb.toString().trim();
		if (result.length() == 0)
			return "<empty list>";
		if (result.charAt(result.length() - 1) == ',') {
			return result.substring(0, result.length() - 1);
		}
		return result;
	}

	class Node {
		String value;
		Node next;
		Node previous;

		Node(String value) {
			this.value = value;
		}

		public String toString() {
			return value == null ? "null" : value;
		}
	}

	public static void main(String[] args) {
		var list = new MyStringLinkedList();
		list.addLast("Rich");
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		list.addFirst("Bob");
		list.addFirst("Harry");
		list.addFirst("Steve");
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		System.out.println(list.search("Harry"));
		System.out.println(list.search("Bob"));
		list.addLast("Tom");
		System.out.println(list);
		list.insert("Leonardo", 1);
		System.out.println(list);
		list.remove("Leonardo");
		list.remove("Tom");
		System.out.println(list);
		var list2 = new MyStringLinkedList();
		String[] strs = {
				"big", "small", "tall", "short", "round", "square", "enormous", "tiny", "gargantuan", "lilliputian",
				"numberless", "none", "vast", "miniscule"
		};
		for (String str : strs)
			list2.addLast(str);
		list2.minSort();
		System.out.println(list2);
	}

	Node get(int pos) {
		Node cur = header.next;
		while (pos-- > 0)
			cur = cur.next;
		return cur;
	}

	public void minSort() {
		int sz = 0;
		Node cur = header.next;
		while (cur != null) {
			sz++;
			cur = cur.next;
		}
		for (int i = 0; i < sz - 1; i++) {
			Node mini = minNode(get(i));
			swap(get(i), mini);
		}
	}
}