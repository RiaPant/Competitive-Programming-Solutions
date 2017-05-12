import java.util.Scanner;

public class insertion {
	public static node<Integer> takeInput(){
		Scanner s = new Scanner(System.in); 
		System.out.println("Enter the link list");
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
	node<Integer> head = takeInput();
	Scanner s = new Scanner(System.in);
	int pos = s.nextInt();
	int data = s.nextInt();
	head = func(head,pos,data );
	print(head);
			

	}
	private static node<Integer> func(node<Integer> head, int pos, int data) {
		if(pos==0){
			node<Integer> newnode= new node<>();
			newnode.data=data;
			newnode.next=head;
			head=newnode;
		return head;
		}
	head.next=func(head.next,pos-1,data);
	return head;
		
		
	}
}
