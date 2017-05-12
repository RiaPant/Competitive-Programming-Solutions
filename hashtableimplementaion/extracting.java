package hashtableimplementaion;

import java.util.Scanner;

public class extracting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.next();
		map<Character,Boolean> m = new map<>();
		System.out.println(str);
		for(int i = 0 ; i  < str.length() ; i++){
			m.put(str.charAt(i), true);
		}
		for(int i = 0 ; i < str.length() ; i++){
			if(m.find(str.charAt(i))==true){
				System.out.print(str.charAt(i));
				m.put(str.charAt(i), false);
			}
		}
		
	}

}
