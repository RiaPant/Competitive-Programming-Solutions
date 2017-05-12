import java.util.Scanner;

class IsBSTReturnType{
	Boolean isBst;
	int min ; 
	int max;
	int depth;
	Treenode<Integer> node;
}
public class largestBST {
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
	public static IsBSTReturnType checkBSTBetter(Treenode<Integer> root){
		IsBSTReturnType ans = new IsBSTReturnType();
		if(root == null){
			ans.isBst = true;
			ans.max = Integer.MIN_VALUE;
			ans.min = Integer.MAX_VALUE;
			ans.node = null;
			ans.depth = 0 ;
			
			return ans;
		}
		
		IsBSTReturnType leftAns = checkBSTBetter(root.left);
		IsBSTReturnType rightAns = checkBSTBetter(root.right);
		
		if(root.data < leftAns.max || root.data > rightAns.min || !leftAns.isBst || !rightAns.isBst){
			if(leftAns.depth>rightAns.depth){
				leftAns.isBst = false;
			return leftAns ;}
			else{
				rightAns.isBst = false;
				return rightAns;
		}
			}
	
		ans.isBst = true;
		ans.min = Math.min(root.data, leftAns.min);
		ans.max = Math.max(root.data, rightAns.max);
		ans.node = root;
		ans.depth= Math.max(leftAns.depth, rightAns.depth)+1;
		return ans;
	}
	//27 56 32 15 16 -1 -1 -1 -1 -1 -1
	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
		Treenode<Integer> root =takeInput();
		print(root);
		System.out.println();
		IsBSTReturnType ans = checkBSTBetter( root);
		System.out.println("Ans is" );
		print( ans.node);
		
	}

}
