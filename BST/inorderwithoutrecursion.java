 
public class inorderwithoutrecursion {

	public static void inorder(Treenode<Integer> root) throws StackEmptyException{
	stackusinglinkedlist<Treenode<Integer>> s = new stackusinglinkedlist<>();
	s.push(root);
	while(!s.isempty()){
		while(root.left!= null){
			s.push(root.left);
			root = root.left ;
		}
		
		while(s.top().right==null){
			System.out.print(s.pop().data + ", ");
			if(s.isempty()){
				return ;
			}
		}
		root = s.top() ;
		System.out.print(s.pop().data + ", ");
		s.push(root.right);
		root= root.right;
			
	}
		
	}
	//6 2 8 1 4 7 -1 -1 -1 3 5 -1 -1 -1 -1 -1 -1
	
	public static void main(String[] args) throws QueueEmptyException, StackEmptyException {
		
		largestBST b = new largestBST();
		Treenode<Integer> head =largestBST.takeInput();
		//largestBST.print(head);
	inorder(head);
	
	
	}

}
