

import java.util.Stack;


public class Solution {

	
	
	public static void sortStack(Stack<Integer> stack){
		
	    sort(stack, new Stack<Integer>());	
	

	}
    public static void sort(Stack<Integer> stack,Stack<Integer> helper){
       if(stack.isEmpty())
    	   return;
    	int top = stack.pop();
        
        sort(stack,helper);
        
        while(!stack.isEmpty()&&stack.peek()>top){
            helper.push(stack.pop());
        
        }
        stack.push(top);
        while(!helper.isEmpty()){
            stack.push(helper.pop());
        
        }
        
    }
	
public static void main(String[] args) {
	Stack<Integer> s = new Stack<>();
	s.push(1);
	s.push(5);
	System.out.println(s.peek());
	s.push(3);
	s.push(4);
	System.out.println(s);
	sortStack(s);
	System.out.println(s);
	
}
}

