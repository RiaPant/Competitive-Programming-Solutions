import java.util.Scanner;

public class reversekelements {
	public static node<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the linklist");
		node<Integer> head = null,tail = null ; 
		node<Integer> newnode = new node<>() ;
		int data = s.nextInt() ; 
		while(data!= -1){
			newnode = new node<>() ;
			newnode.data = data ;
			if(head == null){
				head = newnode ;
				tail = newnode ;
			}
			else{
				tail.next = newnode ;

				tail = tail.next ;
			}
			data = s.nextInt() ;
		}
		return head ; 
	}
	public static void print(node<Integer> head){
		while(head!=null){
			if(head.next!=null)
				System.out.print(head.data+"->");
			else
				System.out.print(head.data);
			head=head.next;
		}
		System.out.println();
	}
	
	public static node<Integer> fun(node<Integer> head){
	System.out.println("Enter the value of k");
	Scanner s = new Scanner(System.in);
	int n = s.nextInt();
	node<Integer> ptr2 = head;
	boolean flag = true;
	node<Integer> ptr1 = null;
	while(ptr2!=null){

		node<Integer> temp = ptr1 ; 
		ptr1 = ptr2;
		int k=n;
		while(k!=0){
			ptr2=ptr2.next;
			k--;
			if(ptr2==null){
				break;
			}
		}

		node<Integer>prev = ptr2, current =ptr1, Next =null;
		while(current!=ptr2){
			Next = current.next;
			current.next = prev ;
			prev = current;
			current = Next;

		}

		if(flag == true){
			head =prev;
			flag = false;
		}
		else{
			temp.next = prev;
		}
		


	}
	return head;	
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node<Integer> head =takeInput();
		print(head);
		head =fun(head);
		print(head);
	}

}
