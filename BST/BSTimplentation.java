
public class BSTimplentation {
	private Treenode<Integer> root = null ; 
	private int size =0;
	
	public int sizeof(Treenode<Integer> root){
		return size;
	}
	public  boolean isEmpty(){
		return(size==0);
	}
	public Treenode<Integer> rootreturn(){
		return this.root;
	}
	public  void insert(Treenode<Integer> node ,int data){
		if(isEmpty()){
			root = new Treenode<Integer>(data);
			size++;
		}
		else{	
			if(node.data>data && node.left==null){
				Treenode<Integer> node1 = new Treenode<Integer>(data);
				node.left =node1;
				size++;}
			else if(node.data<data&&node.right==null){
				Treenode<Integer> node1 = new Treenode<Integer>(data);
				size++;
				node.right = node1;}
			else if(node.data>data)
				insert(node.left,data);
			else if(node.data<data)
				insert(node.right,data);

		}
	}
	public  void print(Treenode<Integer> node){
		if(node == null){
			return ;
		}
		String tobeprinted = node.data+":";
		if(node.left!=null)
			tobeprinted += node.left.data+",";	
		if(node.right!=null)
			tobeprinted += node.right.data;
		System.out.println(tobeprinted);
		print(node.left);
		print(node.right);
	}

//	public static void main(String[] args) {
////	
////BSTimplentation a = new BSTimplentation();
////Treenode<Integer> root = a.rootreturn();
////a.insert(root,5);
////a.insert(root,8);
////a.insert(root,3);
////a.insert(root,2);
////a.insert(root,10);
////a.print(root);
//	
//	
//	}
	}
