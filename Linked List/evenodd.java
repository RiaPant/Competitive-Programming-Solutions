import java.util.Scanner;

public class evenodd {
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
	public static node<Integer> func(node<Integer> head){
		node<Integer> temp =head;
		node<Integer> tail = head;
		while(tail.next!=null){
			tail = tail.next;

		}

		node<Integer> end = tail;
		while(temp.data%2==0){
			tail.next = temp;
			temp=temp.next;
			tail = tail.next;
			tail.next= null;
			if(temp == end)
				break ;
		}
		head = temp;

		while(temp!=end&&temp.next!=end){
			if(temp.next.data%2==0){
				node<Integer> ptr = temp.next;
				temp.next = temp.next.next;
				ptr.next = null ;
				tail.next = ptr;
				tail=tail.next; 

			}
			else
				temp = temp.next;


		}

		return head;
	}
	public static void print(node<Integer> head){
		while(head!=null){
			if(head.next!=null)
				System.out.print(head.data + "->");
			else
				System.out.print(head.data );
			head=head.next;

		}
		System.out.print("\n");
	}
	public static void main(String[] args) {
		node<Integer> head = takeInput();
		print(head);
		head = func(head);
		print(head);
	}

}
