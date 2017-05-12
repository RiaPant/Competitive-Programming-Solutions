import java.util.Scanner;

public class middlement {

	public static node<Integer> takeInput(){
		Scanner s = new Scanner(System.in); 
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

public static void fun(node<Integer> head){
	node<Integer> temp = head;
	if(head==null||head.next==null){
		return ;
	}
	while(temp!=null && temp.next != null){
		head = head.next;
		temp = temp.next.next;
	}
System.out.println(head.data);
}
	
	public static void main(String[] args) {
node<Integer> head= takeInput();
fun(head);
	}

}
