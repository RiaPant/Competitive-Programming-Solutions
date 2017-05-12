
public class CreateBST {
	public static Treenode<Integer> func(int[] arr, int SI,int EI){
		if(SI>EI)
			return null;
		int mid = (SI+EI)/2;
		Treenode<Integer> root = new Treenode<Integer>(arr[mid]);
		root.left = func(arr, SI, mid-1);
		root.right = func(arr, mid+1,EI);

		return root;	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5,6,};
		Treenode<Integer> root= func(arr,0 , arr.length-1);
		print(root);
	}

}
