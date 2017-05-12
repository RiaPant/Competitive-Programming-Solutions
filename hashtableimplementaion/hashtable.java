package hashtableimplementaion;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
public class hashtable {

	public static void Intersection(int[] arr1,int[] arr2){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int elem: arr1){
			if(map.containsKey(elem))
				map.put(elem,map.get(elem)+1);
			else
				map.put(elem,1);
		}
		for(int elem:arr2){
			if(map.containsKey(elem)&&map.get(elem)!=0){
				System.out.println(elem);
				map.put(elem, map.get(elem)-1);
			}
		}


	}
	public static int[] remove(int[]arr1){
		HashMap<Integer, Boolean> map = new HashMap<>();
		for(int i = 0 ;i < arr1.length ;i++){

			map.put(arr1[i],true);
		}

		int arr2[] = new int[map.size()];
		int j = 0;
		for(int i = 0 ; i  <arr1.length; i++){
			if(map.get(arr1[i])){
				arr2[j++]= arr1[i];
				map.put(arr1[i], false);
			}
		}

		return arr2;
	}
	public static void printpairsum(int[] arr1){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int elem: arr1){
			if(map.containsKey(elem))
				map.put(elem,map.get(elem)+1);
			else
				map.put(elem,1);
		}
		int count = 0 ;

		for(int i = 0; i <arr1.length;i++){
			if(map.containsKey(-arr1[i])&& map.containsKey(arr1[i])){
				int j = map.get(arr1[i])*map.get(-arr1[i]);
				System.out.println(j+ " pairs of " +arr1[i]+","+ -arr1[i]);
				map.put(arr1[i], 0);
				map.put(-arr1[i], 0);
				count+= j;
			}


		}
		System.out.println(count + " pairs found");	
	}

	//	public static ArrayList<Integer> consecutive(int arr[]){
	//		HashMap<Integer, Boolean> map = new HashMap<>();
	//		for(int elem: arr){
	//			if(map.containsKey(elem))
	//				map.put(elem,true);
	//			//			else
	//			//				map.put(elem,1);
	//		}
	//		ArrayList<Integer> arr1 = new ArrayList<>();
	//		int i = 0 ;
	//		while(i<arr.length){
	//			if(map.containsKey(arr[i]+1)){
	//				arr1.add(arr[i]);
	//			}
	//
	//		}
	//		return arr1;
	//	}
	public static int maxunsorted(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxelem =0;
		int maxfreq = Integer.MIN_VALUE;
		for(int elem: arr){
			if(map.containsKey(elem))
				map.put(elem,map.get(elem)+1);
			else
				map.put(elem,1);
			if(maxfreq<map.get(elem)){
				maxelem = elem;
				maxfreq = map.get(elem);
			}

		}
return maxelem;

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		int [] arr1={1,2,3,4,7,7,5,6,6,6};
		//		int arr2[] = {2,3,6,3};
		//		Intersection(arr1,arr2);
		//		int arr[]=	remove(arr1);
		//		for(int elem:arr){
		//			System.out.print(elem);
		//		}
		int arr1[] = {2,-2,-2,2,3,-3};
		printpairsum(arr1);
		//		int arr1[] = {1,2,3,4,5,6,6,7,8,8,9,23,25};
		//		ArrayList<Integer> arr	= consecutive(arr1); 
		//int arr1[] = {2,2,2,5,6,9,9,9,9,9,9,9,9,7,8,9,2,2,2};
		//int i = maxunsorted(arr1);
		//System.out.println("Most occuring "+ i);
	
	}

}
