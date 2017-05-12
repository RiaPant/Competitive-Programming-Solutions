
public class PreorderInorder { 
	public static Treenode<Integer> fun(int[] PO  ,int[] IO){
	if (IO.length==0||PO.length==0){
	return null;}
	Treenode<Integer> root = new Treenode<Integer>(PO[0]);
	int i = 0 ;
	while(IO[i]!=PO[0]){
		i++;
	}
	int[] childPOL = new int[i];
	int[] childPOR =new int[PO.length-i-1];
	int[] childIOL = new int[i];
	int[] childIOR =new int[PO.length-i-1];
	for(int j = 0 ; j < i ; j++){
		childPOL[j] = PO[j+1];
		childIOL[j] = IO[j];
	}
	for(int j = 0 ; j < PO.length-i-1 ; j++){
		childPOR[j] = PO[j+i+1];
		childIOR[j] = IO[j+i+1];
	}
	root.left= fun(childPOL,  childIOL);
	root.right= fun(childPOR, childIOR);
	return root;
	}
	public static Treenode<Integer> fun1(int[] PO, int[] IO, int BIp,int EIp, int BIi, int EIi){
	if(BIp>EIp||BIi>EIi){
		return null;
	}
	Treenode<Integer> root = new Treenode<Integer>(PO[BIp]);
	int i = BIi ; 
	 while(IO[i]!=PO[BIp]){
		 i++;
	 }
	// int length = i - BIi ;
	root.left =fun1(PO,IO,BIp+1, BIp+i,BIi,i-1);
	root.right = fun1(PO,IO,BIp+i+1,EIp,i+1,EIi);		
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
int [] arr1={1,2,3,6,4,5};
int arr2[] ={3,2,6,1,4,5};
Treenode<Integer> root = fun(arr1, arr2);
print(root);
root = fun1(arr1, arr2, 0,arr1.length-1,0,arr2.length-1);
print(root);
	}

}
