import java.util.Scanner;

public class identical {
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
//	1 2 3 4 5 -1 6 -1 -1 -1 -1 -1 -1
//	1 2 3 4 5 -1 6 -1 5 -1 -1 -1 -1 -1 -1
	public static boolean identical1(Treenode<Integer> root1,Treenode<Integer> root2){
		if(root2 ==null &&root1==null )
			return true;
		if((root1==null&&root2!=null)||(root2==null&&root1!=null))
			return false;
		if(root1.data == root2.data)
			return(identical1(root1.left,root2.left)&&identical1(root1.right, root2.right));
		return false;
	}
	
	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
		Treenode<Integer> root = takeInput();
		Treenode<Integer> root1 = takeInput();
		System.out.println("Identical: "+ identical1(root,root1) );
		
	}

}
