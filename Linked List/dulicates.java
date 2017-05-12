import java.util.Scanner;

public class dulicates {

		
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
	public static node<Integer> fun(node<Integer> head){
		node<Integer> temp = head ;
		while(temp!= null && temp.next!=null){
		if(temp.data==temp.next.data ){
			temp.next= temp.next.next;
		}
		print(head);
		temp=temp.next;
		}
		return head;
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
		// TODO Auto-generated method stub
node<Integer> head = takeInput();
head=fun(head);
print( head);	
	}

}
