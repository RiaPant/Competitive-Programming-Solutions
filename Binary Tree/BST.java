import java.util.Scanner;

public class BST {
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
	public static Treenode<Integer> fun(Treenode<Integer> root,int x){
		if(root==null)
			return null;
		if(root.data==x)
			return root;
		else if(root.data>x)
			return	fun(root.left,x);
		else
			return	fun(root.right,x);

	}
	public static void print1(int k1 , int k2 , Treenode<Integer> root){
		if(root==null)
			return;
		if(root.data>=k1&&root.data<=k2){
			System.out.print(root.data+" ");
		}

		//		print1(k1,k2,root.left);
		//		if(root.data<k1)				
		//		print1(k1,k2,root.right);
		//		print1(k1,k2,root.right);
		//		if(root.data>k2)
		//			print1(k1,k2,root.left);
		if(root.data>k2)
			print1(k1,k2,root.left);
		else if(root.data<k1)
			print1(k1,k2,root.right);
		else
		{
			print1(k1,k2,root.left);
			print1(k1,k2,root.right);
		}

		//		if(root.data>=k1&&root.data<=k2){
		//			System.out.println(root.data);
		//		}
		//		
		//		 if(root.data<k1)
		//			print1(k1,k2,root.right);
		//		 if(root.data>k2)
		//			print1(k1,k2,root.left);
	}
	public static boolean check(Treenode<Integer> root){
		if(root ==null)
			return true;
		//		if(root.left==null&&root.right==null)
		//			return true;
		if(root.left!=null)
		{
			if(!(root.left.data<root.data))
				return false;
		}
		
		if (root.right!=null){
			if(!(root.right.data>root.data))
				return false;
		}

		if(!(root.data<max(root)))
			return false;
		if(!(root.data>min(root)))
			return false;
			
			
			if( !check(root.left))
				return false;
			return check(root.right);
	}
	public static int max(Treenode<Integer> root){
		
		while(root.right!=null)
			root= root.right;
		return root.data;
	}
	public static int min(Treenode<Integer> root){
		while(root.left!=null)
			root= root.left;
		return root.data;
	}
	public static Node<Integer> linkedList(Treenode<Integer> root){
		if(root==null)
			return null;
		Node<Integer> leftnode = linkedList(root.left);
		Node<Integer> newnode = new Node<>();
		newnode.data = root.data;
		Node<Integer> ptr = leftnode;
		if(!(leftnode==null)){
		while(ptr.next != null)
		ptr =ptr.next;
		ptr.next = newnode;
		}
			
		Node<Integer> rightnode = linkedList(root.right);
		newnode.next =rightnode;
		if(leftnode==null)
			return newnode;
		return leftnode;
	}
	
	public static void print(Node<Integer> head){
		while(head!=null){
			if(head.next!=null)
			System.out.print(head.data+"->");
			else
				System.out.print(head.data);
			head=head.next;
		}
	System.out.println();
	}

	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
		Treenode<Integer> root  = takeInput();
		print(root);
		System.out.println();
		//Treenode<Integer> node = fun(root,4);
		//if(node!=null)
		//System.out.println("Ans is"+node.data);
		//else
		//	System.out.println("not found");
		//	print1(5,12,root);
	//	System.out.println(check(root));
		//8   4 12  2 6  9 14 -1 -1 5 -1 -1 -1 -1 -1 -1 -1
		//10 8 -1 -1 9 -1 -1
		//12 6 20 4 8 15 25 -1 -1 -1 -1 -1 -1 -1 -1
Node<Integer> head = linkedList(root);
//int arr[] = {""}
//root = build();

print(head);

	}

}
