import java.util.Scanner;

public class removeLeaf {
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
	public static void fun(Treenode<Integer> root){
if(root==null)
	return;
		if(root.left!=null){
		if(root.left.left==null&&root.left.right==null){
			root.left=null;
		}}
if(root.right!=null){
		if(root.right.left==null&&root.right.right==null){
			root.right=null;
		}}
		
		fun(root.left);
		fun(root.right);
		return;
	}
	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
Treenode<Integer> root =takeInput();
print(root);
fun(root);
System.out.println("Ans");
print(root);
	}

}
