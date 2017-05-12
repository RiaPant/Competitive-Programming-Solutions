import java.util.Scanner;

public class reversewithnoreversal {
 
	public static node<Integer> takeInput(){
	System.out.println("Enter your linkedlist ");
		node<Integer> head = null ; 
	node<Integer> tail = null ;
	Scanner s = new Scanner(System.in);
	int data = s.nextInt();
	while(data !=-1){
		node<Integer> newnode = new node<>();
		newnode.data = data;
		if(head==null){
			head = newnode;
			tail = newnode;
		}
		else{
			tail.next = newnode;
			tail = tail.next;
		}
		data = s.nextInt();
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
	public static node<Integer> reverse(node<Integer> head){
	node<Integer> prev = null , current= head, Next = null ;
	
	if(head == null||head.next== null){
		return head;
	}
	else{
		while(current != null){
			Next = current.next;
			current.next = prev;
			prev= current;
			current = Next;
		}
	head = prev;
	}
	
	return head ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
node<Integer> head = takeInput();
print(head);
head =reverse(head);
print(head);
	}

}
