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
	for(int i = 0; i <arr1.length;i++){
		int count = 0 ;
		if()
	}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr1={1,2,3,4,7,7,5,6,6,6};
		//		int arr2[] = {2,3,6,3};
		//		Intersection(arr1,arr2);
		int arr[]=	remove(arr1);
		for(int elem:arr){
			System.out.print(elem);
		}
	}

}
