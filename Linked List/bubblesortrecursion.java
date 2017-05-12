import java.util.Scanner;

public class bubblesortrecursion {
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
	
	public static int length(node<Integer> head){
		return(head==null)?0:length(head.next)+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
node<Integer> head = takeInput();
print(head);
int l = length(head);
head=sort(head,l);
print(head);	
	}
	private static node<Integer> sort(node<Integer> head, int l) {
		if(l==0){
			return head;
		}
		node<Integer> = temp ;
		for(int i = 0 ; i< l-1 ; i ++ ){
			
		
		
		
		}
		
		return head;
	}

}
