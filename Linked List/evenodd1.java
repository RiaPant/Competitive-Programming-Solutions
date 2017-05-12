import java.util.Scanner;

public class evenodd1 {
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
	public static node<Integer> fun(node<Integer> head){
		node<Integer> evenhead= null;
		node<Integer> eventail= null;
		node<Integer> oddhead= null;
		node<Integer> oddtail= null;
		node<Integer> ptr= head;
		while(ptr!=null){
			if(ptr.data %2==0){
				if(evenhead==null){
					evenhead = ptr;
					eventail = evenhead;

				}
				else{
					eventail.next=ptr;
					eventail = eventail.next;

				}

			}
			else{
				if(oddhead==null){
					oddhead = ptr;
					oddtail = oddhead;

				}
				else{
					oddtail.next = ptr;
					oddtail=oddtail.next;

				}

			}
			ptr=ptr.next;
		}
		eventail.next = null;
		head = oddhead;
		oddtail.next = evenhead;
		return head;
	}
	public static void main(String[] args) {
	node<Integer> head = takeInput();
	print(head);
head = fun(head);
print(head);

	}

}
