import java.util.ArrayList;
import java.util.Scanner;

public class path {
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
	
	public static ArrayList<Treenode<Integer>> findPath(Treenode<Integer> root, int  data){

		if(root == null){
			return null;
		}
		
		if(root.data == data){
			ArrayList<Treenode<Integer>> output = new ArrayList<>();
			output.add(root);
			return output;
		}
		ArrayList<Treenode<Integer>> leftAns = findPath(root.left, data);
		if(leftAns != null){
			leftAns.add(0,root);
			return leftAns;
		}
		ArrayList<Treenode<Integer>> rightAns = findPath(root.right, data);
		if(rightAns != null){
			rightAns.add(0,root);
			return rightAns;
		}
		return null;
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
	public static void main(String[] args) throws QueueEmptyException {
		Treenode<Integer> root = takeInput();
		ArrayList<Treenode<Integer>> arr = findPath(root, 5);
		for(Treenode<Integer> child : arr)
		{
			System.out.println(child.data+" ");
		}
	}

}
