import java.util.*;

public class BTLL {
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
	public static ArrayList<Node<Integer>> fun(Treenode<Integer> root) throws QueueEmptyException{
		ArrayList<Node<Integer>> a = new ArrayList<>();
		QueueUsingLL<Treenode<Integer>> pq = new QueueUsingLL<>();
		pq.enqueue(root);
		pq.enqueue(null);
		
		Node<Integer> nodeLL = new Node<>();
		nodeLL.data = root.data;
		a.add(nodeLL);
		//i++;
		while(!pq.isEmpty()){
			Node<Integer> tail = null;
			boolean flag =false;
			while(pq.front()!=null){
				Treenode<Integer> node=	pq.dequeue();

				Node<Integer> nodeL=new Node<>();
				Node<Integer> nodeR=new Node<>();

				if(node.left!=null){
					nodeL.data = node.left.data;
					pq.enqueue(node.left);
				}
				if(node.right!=null){
					nodeR.data = node.right.data;
					pq.enqueue(node.right);

				}
				if(flag==false){
					if(nodeL.data!=null &&nodeR.data!=null ){
						nodeL.next= nodeR;
						a.add(nodeL);
						tail = nodeR;
					}
					else if(nodeL.data!=null &&nodeR.data ==null){
						a.add(nodeL);
						tail =nodeL;
					} 
					else if(nodeR.data!=null){
						a.add(nodeR);
						tail= nodeR;
					}
					flag = true;
				}
				else{
					if(nodeL.data!=null &&nodeR.data!=null ){
						tail.next = nodeL;
						nodeL.next= nodeR;
						tail = nodeR;
					}
					else if(nodeL.data!=null &&nodeR.data ==null){
						tail.next=nodeL;
						tail =nodeL;
					} 
					else if(nodeR.data!=null){
						tail.next=nodeR;
						tail= nodeR;
					}
				}
				
				
			}
			pq.dequeue();
			if(pq.size()>0)
			pq.enqueue(null);
		}

		return a;
	}
//	1 2 3 4 5 -1 6 -1 -1 -1 -1 -1 -1
	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
		Treenode<Integer> root = takeInput();
		System.out.println("Ans");
		ArrayList<Node<Integer>> a = fun(root);
		for(int i =0 ; i<a.size();i++){
			Node<Integer> head = a.get(i);
			while(head!=null){
				if(head.next!=null)
					System.out.print(head.data + "->");
				else
					System.out.print(head.data );
				head=head.next;

			}
			System.out.println();
		}
	}

}

