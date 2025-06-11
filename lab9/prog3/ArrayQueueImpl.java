package lab9.prog3;

public class ArrayQueueImpl {
	private int[] arr = new int[10];
	private int size = 0;
	private int front = -1;
	private int rear = 0;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	private void resize() {
		int newSize = size * 2;
		int[] newArr = new int[newSize];
		System.arraycopy(arr, 0, newArr, 0, size);
		arr = newArr;
		front = 0;
		rear = size;
	}

	// add last
	public void enqueue(int item) {
		if (size == arr.length) {
			resize();
		}
		arr[rear] = item;
		rear++;
		if (front == -1) {
			front = 0;
		}
		size++;
	}

	// remove first
	public int dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Cannot dequeue because Queue is empty");
		}
		int item = arr[front];
		front++;
		size--;
		if (isEmpty()) {
			front = -1;
			rear = 0;
		}
		return item;
	}

	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Cannot peak because Queue is empty");
		}
		return arr[front];
	}


	public static void main(String[] args) {
		ArrayQueueImpl q = new ArrayQueueImpl();

//		uncomment when ready
		for(int i = 0; i < 15; i ++)
			q.enqueue(i);
		for(int i = 0; i < 14; i ++)
			q.dequeue();
		System.out.println(q.size());
		System.out.println(q.peek());
	}
}