import java.util.Scanner;

public final class bubblesort {
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
	public static void bubblesort(node<Integer> head){
		node<Integer> ptr1= null;
		node<Integer> ptr2= head.next;
		while(ptr2!= null){
			if(ptr2.data>ptr2.next.data){
				ptr1.next = ptr2.next;
				ptr2.next = ptr1; 
				ptr2= ptr1.next;
				
			}
			else{
				ptr1=ptr1.next;
				ptr2=ptr2.next;
			}
		}
		
	}
	public static void main(String[] args) {
		node<Integer> head = takeInput();
		print(head);
		bubblesort(head);
		print(head);
	}

}
