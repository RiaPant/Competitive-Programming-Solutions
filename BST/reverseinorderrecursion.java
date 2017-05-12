
public class reverseinorderrecursion {
	public static void inorder(Treenode<Integer> root) throws StackEmptyException{
		stackusinglinkedlist<Treenode<Integer>> sf = new stackusinglinkedlist<>();
		stackusinglinkedlist<Treenode<Integer>> sr = new stackusinglinkedlist<>();
		sf.push(root);
		Treenode<Integer> rootr =root;
		sr.push(root);
		while(!sr.isempty()&&!sf.isempty()){
			while(rootr.right!= null){
				sr.push(rootr.right);
				rootr = rootr.right ;
			}
			while(root.left!= null){
				sf.push(root.left);
				root = root.left ;
			}
			while(sr.top().left==null){
				int large = sr.pop().data;
				if(sr.isempty()){
					break ;
				}
			}
			if(!sr.isempty()){
				rootr = sr.top() ;
				System.out.print(sr.pop().data + ", ");
				sr.push(root.left);
				rootr= rootr.left;
			}
			while(sf.top().right==null){
				int small =	sf.pop().data; 
				if(sf.isempty()){
					break ;
				}
			}
			if(!sf.isempty()){
				root = sf.top() ;
				System.out.print(sf.pop().data + ", ");
				sf.push(root.right);
				root= root.right;
			}

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
