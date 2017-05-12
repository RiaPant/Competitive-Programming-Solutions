import java.util.Scanner;

public class inputOutput {
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
	public static int height(Treenode<Integer> root){
		if(root==null)
			return 0;
		if(height(root.left)>height(root.right))
			return height(root.left)+1;
		else
			return height(root.right)+1;

	}
	public static Treenode<Integer> find(Treenode<Integer> root,int x){
		if(root==null)
			return root;
		if(root.data==x)
			return root;
		Treenode<Integer> ln =find(root.left, x);
		if(ln!=null)
			return ln;
		else return find(root.right,x);

	}

	public static void mirror(Treenode<Integer> root){
		if(root==null)
			return;
		Treenode<Integer> temp = root.left;
		root.left = root.right;
		root.right=temp;
		mirror(root.left);
		mirror(root.right);
			
		
	}
	public static void diameter(Treenode<Integer> root){
		if(root == )
	}
	//1 2 3 4 5 -1 6 -1 -1 -1 -1 -1 -1
	//
	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
		Treenode<Integer> root = takeInput();
		print(root);
		System.out.println();
	//	System.out.println(height(root));

		Treenode node = find(root, 7);
		if(node==null)
			System.out.println("Not found");
		else	System.out.println(node.data);
	//	mirror(root);
	//	print(root);
	}

}
