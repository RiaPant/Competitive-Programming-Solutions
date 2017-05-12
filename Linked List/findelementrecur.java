import java.util.Scanner;

public class findelementrecur  {
	public static node<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the linklist");
		node<Integer> head = null,tail = null ; 
		node<Integer> newnode = new node<>() ;
		int data = s.nextInt() ; 
		while(data!= -1){
			newnode = new node<>() ;
			System.out.println(newnode);
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
	
	public static boolean fun(node<Integer> head , int number){
		if(head==null)
		return false;
		if(head.data==number)
			return true;
		return fun(head.next,number);
		
	}
	
public static void main(String[] args){
	node<Integer> head = takeInput();
	Scanner s = new Scanner(System.in);
	System.out.println("Enter the number to be found");
	int x = s.nextInt();
	System.out.println(fun(head, x));
	
}
	
	
}
