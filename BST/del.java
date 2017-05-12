package Trees;

public class BinarySearchTreeUse {

	
	public static BinaryTreeNode<Integer> findNode(BinaryTreeNode<Integer> root, int data){
		if(root == null){
			return null;
		}
		
		if(root.data == data){
			return root;
		}
		if(root.data > data){
			return findNode(root.left, data);
		}
		else{
			return findNode(root.right, data);
		}
	}
	
	
	public static int max(BinaryTreeNode<Integer> root){
		if(root == null){
			return Integer.MIN_VALUE;
		}
		
		int leftMax = max(root.left);
		int rightMax = max(root.right);
		return Math.max(root.data,Math.max(leftMax, rightMax));
	}
	
	public static int min(BinaryTreeNode<Integer> root){
		if(root == null){
			return Integer.MAX_VALUE;
		}
		int leftMin = min(root.left);
		int rightMin = min(root.right);
		return Math.min(root.data,Math.min(leftMin, rightMin));
	}
	
	
	public static boolean checkBST(BinaryTreeNode<Integer> root){
		if(root == null){
			return true;
		}
		
		int leftMax = max(root.left);
		if(root.data < leftMax){
			return false;
		}
		int rightMin = min(root.right);
		if(root.data > rightMin){
			return false;
		}
		
		return checkBST(root.left) && checkBST(root.right);
	}
	
	
	public static IsBSTReturnType checkBSTBetter(BinaryTreeNode<Integer> root){
		IsBSTReturnType ans = new IsBSTReturnType();
		if(root == null){
			ans.isBst = true;
			ans.max = Integer.MIN_VALUE;
			ans.min = Integer.MAX_VALUE;
			return ans;
		}
		
		IsBSTReturnType leftAns = checkBSTBetter(root.left);
		IsBSTReturnType rightAns = checkBSTBetter(root.right);
		
		if(root.data < leftAns.max || root.data > rightAns.min || !leftAns.isBst || !rightAns.isBst){
			ans.isBst = false;
			ans.min = Math.min(root.data,Math.min(leftAns.min,rightAns.min));
			ans.max = Math.max(root.data, Math.max(leftAns.max,rightAns.max));
			return ans;
		}
	
		ans.isBst = true;
		ans.min = Math.min(root.data, leftAns.min);
		ans.max = Math.max(root.data, rightAns.max);
		return ans;
	}
	
	
	public static boolean checkBST3(BinaryTreeNode<Integer> root, int minValue, int maxValue){
		
		if(root == null){
			return true;
		}
		
		if(root.data < minValue || root.data > maxValue){
			return false;
		}
		
		return checkBST3(root.left, minValue, root.data) && checkBST3(root.right, root.data, maxValue);
	}
	
	
	// 10 8 -1 -1 14 -1 -1
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		System.out.println(checkBST(root));
		System.out.println(checkBST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
	}

}
