import java.util.Scanner;

public class inorderll {
	public static Treenode<Integer> takeInput() throws QueueEmptyException{
		Scanner s = new Scanner(System.in);
		QueueUsingLL<Treenode<Integer>> pq = new QueueUsingLL<>();
		System.out.println("Enter root");
		int data =  s.nextInt();
		Treenode<Integer> root = new Treenode<Integer>(data);
		pq.enqueue(root);
		while(!pq.isEmpty()){
			Treenode<Integer> node = pq.dequeue();
			System.out.println("Enter leftChild for "+ node.data);
			int leftdata = s.nextInt();
			if(leftdata!=-1 ){
				Treenode<Integer> leftnode = new Treenode<Integer>(leftdata);
				pq.enqueue(leftnode);
				node.left = leftnode;
			}
			System.out.println("Enter rightChild for "+ node.data);
			int rightdata = s.nextInt();
			if(rightdata!=-1 ){
				Treenode<Integer> rightnode = new Treenode<Integer>(rightdata);
				pq.enqueue(rightnode);
				node.right = rightnode;
			}


		}
		return root ;
	}
	public static void print(Treenode<Integer> root){
		if(root == null){
			return ;
		}
		String tobeprinted = root.data+":";
		if(root.left!=null)
			tobeprinted += root.left.data+",";	
		if(root.right!=null)
			tobeprinted += root.right.data;
		System.out.println(tobeprinted);
		print(root.left);
		print(root.right);
	}
	public static void main(String[] args) throws QueueEmptyException {
		Treenode<Integer> root = takeInput();
		Node<Integer> head = func(root);
		while(head!=null){
			System.out.print(head.data+"->");
			head=head.next;

		}


	}
	private static Node<Integer> func(Treenode<Integer> root) {
		if(root==null){
			return null;
		}
		Node<Integer> headleft = func(root.left);  
		Node<Integer> current = new Node<>();
		current.data= root.data;
		current.next = func(root.right);


		if(headleft!=null){
			Node<Integer> temp=headleft;
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=current;
			return headleft;
		}
		else{
			return current;
		}

	}


}
