import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class a {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		int i = Integer.parseInt(line);

		int[] a = new int[i];
		for(int k = 0 ; k < i ; k++){
			String line1 = br.readLine();
			a[k]= Integer.parseInt(line1);
		}
		for(int k = 0 ; k < a.length ; k++){
			for(int j = 1 ; j <=a[k] ; j++){
				if(j%3 ==0 && j%5!=0)
					System.out.println("Fizz");
				else if(j%5==0 &&j%3!=0)
					System.out.println("BUzz");
				else if(j%3==0)
					System.out.println("FizzBUzz");
				else
					System.out.println(j);
			}	

		}
	}

}
