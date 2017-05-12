import java.util.Scanner;

public class reverserecursion {
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
	public static void main(String[] args) {
		node<Integer> head= takeInput();
		print(head);
		head = fun(head);
		print(head);
	}

	public static node<Integer> fun(node<Integer> head) {
		if(head.next==null)
		{
			return head;
		}
		node<Integer> smallhead=fun(head.next);
	
		node<Integer> temp = smallhead;
		
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next = head;
		head.next=null;

		return smallhead;
	}

}
