import java.util.*;
public class rotationk {
	public static node<Integer> takeInput(){
		Scanner s =new Scanner(System.in);
		System.out.println("Enter linkedlist");
		int data = s.nextInt() ;
		node<Integer> head = null , tail = null ;
		while(data!= -1){
			node<Integer> newnode=new node<>();
			newnode.data = data;
			if(head== null){
			head= newnode;
			tail= head;
			}
			tail.next = newnode;
			tail = tail.next;
			data = s.nextInt();
			
		}
		return head;
	}
	
	public static void print(node<Integer> head){
		while(head!=null){
			if(head.next!=null){
				System.out.print(head.data + "->");
			}
			else
				System.out.print(head.data);
		head = head.next;
		}
	}
	
	public static node<Integer> func(node<Integer> head){
		System.out.println("Enter the value of k");
		Scanner s =new Scanner(System.in);
		int k = s.nextInt();
		node<Integer> ptrb =head , ptre = head ;
		while(k!=0){
			ptre = ptre.next;
			k--;
		}
	while(ptre.next!=null){
		ptrb=ptrb.next;
		ptre=ptre.next;
	}
	ptre.next = head;
	head = ptrb.next ;
	ptrb.next = null;
	return head;
	}
	
public static void main(String args[]){
	node<Integer> head = takeInput();
	print(head);
	head = func(head);
	print(head);
	
}
}
