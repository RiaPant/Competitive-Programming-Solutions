
public class LCABT {
	public static returnLCA func(Treenode<Integer> root , int i , int k ){
		if(root==null){
			returnLCA a = new returnLCA();
			a.a1 = false;
			a.a2 = false;
			a.lca = Integer.MAX_VALUE;
			return a;
		}
		returnLCA sl = func(root.left, i ,k) ;
		returnLCA sr = func(root.right, i ,k ) ;
		returnLCA ans =  new returnLCA();
		if((sl.a1 ==true&&sr.a2==true)||(sr.a1 ==true&&sl.a2==true)){
			ans.lca = root.data;
			ans.a1 = true;
			ans.a2 =true;
		}
		else if(root.data==i){
			ans.a1 = true ;
			ans.a2 = sl.a2 || sr.a2;
			if(ans.a2==true)
				ans.lca = root.data;
			else
				ans.lca = Integer.MAX_VALUE;
		}
		else if(root.data==k){
			ans.a2 = true ;
			ans.a1 = sl.a1 || sr.a1;
			if(ans.a1==true)
				ans.lca = root.data;
			else
				ans.lca = Integer.MAX_VALUE;
		}
		else{
			ans.a1 = sl.a1||sr.a1;
			ans.a2 = sl.a2 || sr.a2;
			if(sl.lca!= Integer.MAX_VALUE)
				ans.lca = sl.lca;
			else
				ans.lca = sr.lca;
		}


		return ans;
	}
	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
		largestBST b = new largestBST();
		Treenode<Integer> head =largestBST.takeInput();
		System.out.println(func(head, 1,5).lca);

	}

}
