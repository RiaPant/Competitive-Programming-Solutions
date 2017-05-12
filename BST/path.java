import java.lang.reflect.Array;
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
		// TODO Auto-generated method stub
		Treenode<Integer> node = takeInput();
		ArrayList<Treenode<Integer>> arr = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		System.out.println("Value of k");
		int k= s.nextInt();
		System.out.println();
		arr = func(node,k);
		if(arr!=null)
		for(Treenode<Integer> elem: arr){

			System.out.print(elem.data+",");
		}
		else{
			System.out.println("notfound");
		}

	}

	//6 2 8 1 4 7 -1 -1 -1 3 5 -1 -1 -1 -1 -1 -1
	private static ArrayList<Treenode<Integer>> func(Treenode<Integer> root,int k) {
		if(root==null){
			return null;
		}
		
		
		if(root.data==k){
			ArrayList<Treenode<Integer>> arr = new ArrayList<>();
			arr.add(root);
			return arr;
		}

		ArrayList<Treenode<Integer>> arr;
		if(root.data>k){
			arr = func(root.left,k);
			if(arr!=null)
			arr.add(0,root);
		}
		else{
			arr = func(root.right,k);
			if(arr!=null)
			arr.add(0,root);
		}

		return arr;	

	}

}
