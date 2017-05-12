

public class stackuse {

	public static void main(String[] args) throws StackEmptyException {
		stackusinglinkedlist<Integer> s = new stackusinglinkedlist<Integer>() ;
	for(int i = 0 ; i < 5 ; i++){
			s.push(i);
		}
	for(int i = 0 ; i< 7 ;i++)
	{
		try {
			System.out.print(s.pop());
		}
		catch (StackEmptyException e) {
	}
		System.out.print(s.pop());
	
	}

	}
	}
