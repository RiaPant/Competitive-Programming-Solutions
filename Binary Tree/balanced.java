import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class balanced {
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
		return(height(root.left)>height(root.right))?height(root.left)+1:height(root.right)+1;
	}
	//	1 2 3 4 5 -1 6 -1 -1 -1 -1 -1 -1
	//	1 2 3 4 5 -1 6 -1 5 -1 -1 -1 -1 -1 6
	public static boolean fun(Treenode<Integer> root){
		if(root==null)
			return true;

		if((height(root.left)-height(root.right))<=1 && (height(root.left)-height(root.right))>=-1)
			return(fun(root.left)&&fun(root.right));
		return false;

	}
	public static isBT fun1(Treenode<Integer> root){
		if(root==null){
			isBT a = new isBT(); 
			a.bst = true;
			a.height = 0 ;
			return a;
		}
		isBT l = new isBT();
		l = fun1(root.left);
		isBT r = new isBT();
		r = fun1(root.right);
		isBT ans = new isBT();
		if(!((l.height-r.height>=-1)&&(l.height-r.height<=1))|| !fun1(root.left).bst||!fun1(root.right).bst){
			ans.bst = false;

		}
		else
		{ans.bst =true;
		ans.height= Math.max(fun1(root.left).height, fun1(root.right).height)+1;}
		return ans; 
	}
	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
		Treenode<Integer> root = takeInput();
		//System.out.println(fun(root));
		System.out.println(fun1(root).bst);
		//System.out.println(height(root));
	}

}
