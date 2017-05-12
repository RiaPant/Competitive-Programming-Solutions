import java.util.Scanner;

public class merge {

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
	public static node<Integer> fun(node<Integer> head1,node<Integer> head2){
		node<Integer> temp = null;
		node<Integer> head=null;
		while(head1!=null && head2!=null){
			if(head1.data<head2.data){
				if(head==null){
					head = head1 ;
					temp = head;
					head1=head1.next;
				}
				else{
				temp.next=head1;
				head1=head1.next;
				temp=temp.next;
			}
			}
			else{
				if(head==null){
					head = head2 ;
					temp = head;
					head2=head2.next;
				}
				else{
				temp.next=head2;
				head2=head2.next;
				temp=temp.next;
				}
			}
		}
	if(head2==null)
		temp.next = head1;
	if(head1==null)
		temp.next = head2 ;
		return head;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node<Integer> head1= takeInput();
		node<Integer> head2= takeInput();

		node<Integer> head=fun(head1,head2);
		print(head);
	}

}
