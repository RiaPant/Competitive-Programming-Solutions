import java.util.Scanner;

public class reversenodes {
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
	
	public static void main(String[] args) {
	node<Integer> head = takeInput();
	reverse(head);
	System.out.println("null");
	
	}
	public static void reverse(node<Integer> head) {
		if(head==null)
			return ;
		reverse(head.next);
		System.out.print(head.data+"->");
	}

}
