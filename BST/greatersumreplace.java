import java.util.Scanner;

public class greatersumreplace {
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
	//	public static int sum(Treenode<Integer> root){
	//		if(root==null)
	//			return 0;
	//		return(sum(root.left)+sum(root.right)+root.data);
	//	}
	public static int fun(Treenode<Integer> root,int sumsofar){
		if(root==null)
			return sumsofar;
		int sumr = fun(root.right, sumsofar);
		root.data = root.data+sumr;
		sumsofar= root.data;
		int suml =fun(root.left,sumsofar );
//		sumsofar+=suml;
		return sumsofar;
	}
	//8 6 10 -1 -1 -1 -1
	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
		Treenode<Integer> root =takeInput();
		print(root);
		fun(root,0);
		print(root);
	}

}
