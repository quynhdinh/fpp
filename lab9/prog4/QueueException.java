package lab9.prog4;

@SuppressWarnings("serial")
public class QueueException extends Exception {
	public QueueException() {
		super();
	}
	public QueueException(String msg) {
		super(msg);
	}
	public QueueException(Throwable t) { 
		super(t);
	}
}