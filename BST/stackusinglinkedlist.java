

public class stackusinglinkedlist<T> {
	private Node<T> top;
	private int size;
	
	
	public int size(){
		return size;
	}
	
	public boolean isempty(){
	return	(size==0);
	
	}
	
	public T top() throws StackEmptyException{
		if(isempty()){
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		return top.data;
	}
	
	public void push(T data){
	Node<T> newnode = new Node<>();
	newnode.data =  data;
	newnode.next= top;
	top = newnode;
	size++;
	}
	public T pop() throws StackEmptyException {
		if(isempty()){
			StackEmptyException e = new StackEmptyException();
			throw e ;
		}
		Node<T> temp = top;
		top= top.next;
		size--;
		return temp.data;
	}



}
