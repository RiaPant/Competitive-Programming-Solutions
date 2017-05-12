import java.util.Scanner;

public class levelOrder {
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
	//1 2 3 4 5 -1 6 -1 -1 -1 -1 -1 -1
	//1 -1 2 3 4 -1 -1 -1 5 6 -1 -1 -1
	public static void fun(Treenode<Integer> root) throws QueueEmptyException{
		QueueUsingLL<Treenode<Integer>> pq = new QueueUsingLL<>();
		pq.enqueue(root);
		pq.enqueue(null);
		System.out.println(root.data);
		while(!pq.isEmpty()){
			while(pq.front()!=null){
				Treenode<Integer> node=	pq.dequeue();
				if(node.left!=null){
					System.out.print(node.left.data+", ");
					pq.enqueue(node.left);
				}
				if(node.right!=null){
					System.out.print(node.right.data+", ");
					pq.enqueue(node.right);
				}
			}
			System.out.println();
			pq.dequeue();
			if(pq.size()>0)
				pq.enqueue(null);
		}
	}
	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
Treenode<Integer> root = takeInput();
print(root);
System.out.println();
fun(root);
	}

}
