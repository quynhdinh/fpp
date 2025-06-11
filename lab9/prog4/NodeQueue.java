package lab9.prog4;

public class NodeQueue {
	/* stores the element at the front of the queue, if it exists */
	private Node head;

	/* stores the element at the end of the queue, if it exists */
	private Node tail;

	/**
	 * Inserts a new node containing s at end of queue
	 */
	public void enqueue(String s) {
		if (head == null) {
			head = new Node();
			head.data = s;
			head.next = null;
			tail = head;
			return;
		}
		Node new_node = new Node();
		new_node.data = s;
		tail.next = new_node;
		tail = new_node;
	}

	/**
	 * Removes node from the front of the queue and returns its value if
	 * head is n
	 */
	public String dequeue() throws QueueException {
		if (isEmpty())
			throw new QueueException("Queue is empty!");
		String f = head.data;
		if (head == tail) {
			head = null;
			tail = null;
		} else
			head = head.next;
		return f;
	}

	/**
	 * Returns value stored at the front of the queue
	 * 
	 * @return
	 * @throws QueueException
	 */
	public String peek() throws QueueException {
		if (isEmpty())
			throw new QueueException("Queue is empty!");
		return head.data;
	}

	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "<empty queue>";
		return head.toString();
	}
}