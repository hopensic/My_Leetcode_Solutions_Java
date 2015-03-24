package util.list_stack_queue;

public class MyStack<T> extends MyLinkedList<T> {
	public MyStack() {
		super();
	}

	public void push(T x) {
		this.addFirst(x);
	}

	public T pop() {
		if (size() == 0)
			throw new IllegalStateException();
		T x = this.getNode(0).getData();
		this.removeNode(0);
		return x;
	}

	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
		stack.print();
		
	}

}
