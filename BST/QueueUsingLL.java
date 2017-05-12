
public class QueueUsingLL<T> {

	private Node<T> front;
	private Node<T> rear;
	private int size;

	public QueueUsingLL() {
		front = null;
		rear = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public  T front() throws QueueEmptyException {
		if (size == 0) {
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}

		return  front.data;

	}

	public void enqueue(T data) {
		Node<T> newNode = new Node<>();
		newNode.data = data;
		newNode.next = null;
		if (front == null) {
			front = (Node<T>) newNode;
			rear = (Node<T>) newNode;
			size++;

		} else {
			rear.next = (Node<T>) newNode;
			rear = (Node<T>) newNode;
			size++;
		}
	}

	public T dequeue() throws QueueEmptyException {
		if (size == 0) {
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		T t = front.data;
		if (size == 1) {

			front = null;
			rear = null;

		} else
			front = front.next;

		size--;
		return t;
	}
	
}