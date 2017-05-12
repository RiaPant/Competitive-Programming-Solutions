import java.util.Scanner;

public class palindrome {
	public static node<Character> takeInput(){
		System.out.println("Enter your linkedlist ");
			node<Character> head = null ; 
		node<Character> tail = null ;
		Scanner s = new Scanner(System.in);
		char data = s.next().charAt(0);
		while(data !='1'){
			node<Character> newnode = new node<>();
			newnode.data = data;
			if(head==null){
				head = newnode;
				tail = newnode;
			}
			else{
				tail.next = newnode;
				tail = tail.next;
			}
			data = s.next().charAt(0);
		}
		return head;	
		}
		public static void print(node<Character> head){
			while(head!=null){
				if(head.next!=null)
					System.out.print(head.data + "->");
				else
					System.out.print(head.data );
			head=head.next;
			
			}
			System.out.print("\n");
		}
		public static node<Character> reversal(node<Character> head){
			if(head==null||head.next ==null )
				return head;
			node<Character> prev = null , current = head , Next =null;
			while(current!=null){
				Next = current.next;
				current.next = prev ;
				prev = current ;
				current=Next ;
				
			}
			head = prev;
			return head ;
		}
		public static int length(node<Character> head){
		
			return(head==null)?0:length(head.next)+1;
		}
		public static boolean func(node<Character> head){
			if(head == null || head.next ==null)
				return true ;
			boolean flag = true ; 
			node<Character> slow=head,fast = head;
			while(fast.next!=null && fast.next.next!=null){
				slow= slow.next;
				fast=fast.next.next;
			}
			if(fast==slow )
				return false;
			System.out.println(slow.data+""+'3'+fast.data);
			slow.next  = reversal(slow.next);
			print(head);
			node<Character> temp = head,temp1 = slow.next ;
			System.out.println(temp1.data+"" +temp.data+'1');
			while(temp!=slow){
				if(temp.data!=temp1.data){
					flag = false;
					break ;
				}
				System.out.println(temp1.data+""+temp.data+'2');
				temp = temp.next;
				temp1=temp1.next;
			}
			
			return flag;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

node<Character> head = takeInput();
print(head);
System.out.println("Palindrome: " + func(head));
	
	}

}
