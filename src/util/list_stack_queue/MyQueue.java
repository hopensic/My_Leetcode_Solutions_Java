package util.list_stack_queue;

public class MyQueue<T> extends MyLinkedList<T> {
	public MyQueue() {
		super();
	}

	public void enqueue(T x) {
		this.addLast(x);
	}

	public void dequeue() {
		this.removeNode(0);
	}

	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		q.print();
	}

}
