import java.util.Scanner;

public class swapelements {
	public static node<Integer> takeInput(){
		Scanner s = new Scanner(System.in); 
		System.out.println("Enter linked list");
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
	//	public static int length(node<Integer> head){
	//		return (head==null)?0:length(head.next)+1;
	//	}
	public static node<Integer> func(node<Integer> head){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the position for nodes to be swapped");
		node<Integer> ptr1=head;
		node<Integer> ptr2=head;
		node<Integer> prev1=head;
		node<Integer> prev2=head;
		node<Integer> Next1=null;
		node<Integer> Next2=null;
		int x =s.nextInt();
		int y = s.nextInt();
		if(x>y){
			int	temp = x ;
			x = y;
			y = temp ; 
		}

		if(x==0&& y-x != 1){
			while(y!=1){
				ptr2=ptr2.next;
				prev2=prev2.next;
				y--;
			}
			ptr2=ptr2.next;
			Next2 = ptr2.next;
			Next1 = ptr1.next; 
			prev2.next =ptr1;
			ptr1.next = Next2;
			ptr2.next = Next1;
			head = ptr2;
		}
		else if(x==0 && y-x == 1){
			ptr2= ptr1.next;
			Next2 = ptr2.next;
			ptr2.next =ptr1;
			ptr1.next = Next2;
			head = ptr2;
		}
		else if(y-x == 1){
			while(x!=1){
				prev1=prev1.next;
				x--;
			}
			ptr1= prev1.next;
			ptr2= ptr1.next;
			Next2= ptr2.next;
			prev1.next= ptr2;
			ptr1.next=Next2;
			ptr2.next=ptr1;
		}
		else{
			while(x!=1){
				prev1=prev1.next;
				x--;
			}
			while(y!=1){
				prev2=prev2.next;
				y--;
			}
			ptr1=prev1.next;
			ptr2=prev2.next;
			Next1=ptr1.next;
			Next2=ptr2.next;
			prev1.next = ptr2;
			ptr2.next = Next1;
			prev2.next=ptr1;
			ptr1.next = Next2;

		}



		return head;
	}
	public static void main(String[] args){
		node<Integer> head = takeInput();
		print(head);
		head = func(head);
		print(head);

	}

}
