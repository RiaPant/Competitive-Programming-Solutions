import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class sumequal {
	public static ArrayList<Integer> inorder(Treenode<Integer> root) throws StackEmptyException{
		stackusinglinkedlist<Treenode<Integer>> s = new stackusinglinkedlist<>();
		s.push(root);
		ArrayList<Integer> a = new ArrayList<>();
		while(!s.isempty()){
			while(root.left!= null){
				s.push(root.left);
				root = root.left ;
			}

			while(s.top().right==null){
				a.add(s.pop().data);
				if(s.isempty()){
					return a;
				}
			}
			root = s.top() ;
			a.add(s.pop().data);
			//System.out.print(s.pop().data + ", ");
			s.push(root.right);
			root= root.right;

		}
		return a ;	
	}
	public static void modifiedInorder(Treenode<Integer> root,int k) throws StackEmptyException{
		stackusinglinkedlist<Treenode<Integer>> s = new stackusinglinkedlist<>();
		s.push(root);
		HashMap<Integer, Boolean> h = new HashMap<>();
		ArrayList<Integer> a = new ArrayList<>();
		while(!s.isempty()){
			while(root.left!= null){
				s.push(root.left);
				root = root.left ;
			}

			while(s.top().right==null){
				int i = s.pop().data ;
				h.put(i, true);
				
				if(h.containsKey(k-i)&&h.get(i)){
					System.out.println(i+","+ (k-i));
					h.put(i, false);
				}
				if(s.isempty()){
					return ;
				}
			}
			root = s.top() ;
			int i = s.pop().data ;
			h.put(i, true);

			if(h.containsKey(k-i)&&h.get(i)){
				System.out.println(i+","+ (k-i));
				h.put(i, false);
			}
			s.push(root.right);
			root= root.right;

		}

	}
	//6 2 8 1 4 7 -1 -1 -1 3 5 -1 -1 -1 -1 -1 -1
	public static void compare(ArrayList<Integer> a , int k){
		int i = 0 ;
		int  j = a.size()-1;
		while(i<j){
			if(a.get(i)+a.get(j)==k){
				System.out.println(a.get(i)+","+a.get(j));
				i++;j--;	
			}
			else if(a.get(i)+a.get(j)>k)
				j--;
			else i++;

		}
	}

	public static void main(String[] args) throws QueueEmptyException, StackEmptyException {
		largestBST b = new largestBST();
		Treenode<Integer> head =largestBST.takeInput();
		//ArrayList<Integer> a = inorder(head);
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number");
		int k = s.nextInt();
		//compare(a, k);
		modifiedInorder(head, k);
	}

}
