
public class BSTLCA {
public static void func(Treenode<Integer> root, int i  , int k){
	if(root==null)
		return ;
	if(root.data <= i && root.data>= k ){
		System.out.println(root.data);
	return ;
	}
	else if(root.data>i &&root.data> k)
		func(root.left, i , k);
	else
		func(root.right , i , k);
}
//6 2 8 1 4 7 -1 -1 -1 3 5 -1 -1 -1 -1 -1 -1
	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
		//largestBST b = new largestBST();
		Treenode<Integer> head =largestBST.takeInput();
		func(head, 2,1 );
	}

}
