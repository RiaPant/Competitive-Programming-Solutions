package hashtableimplementaion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class map<K,V> {
	private ArrayList<Node<mappair<K,V>>> bucket ;
	private int size;
	public int size(){
		return size;
	}
	private int getbucketIndex(K key){
		int bucketIndex = key.hashCode();	
		bucketIndex %= bucket.size();

		return bucketIndex;
	}
	map(){
		bucket = new ArrayList<>();
		for(int i = 0 ; i < 10; i++   ){
			bucket.add(null);
		}
	}
	public boolean isEmpty(){
		return size==0;
	}


	public void put(K key, V value){
		int bucketIndex = getbucketIndex(key);
		mappair<K,V> data = new mappair<>();
		data.key = key;
		data.value = value;

		Node<mappair<K, V>> node = new Node<mappair<K,V>>(data);
		Node<mappair<K, V>> prev, current;
		prev = null;
		current = bucket.get(bucketIndex);

		if(bucket.get(bucketIndex)==null){
			bucket.set(bucketIndex, node);
			current = bucket.get(bucketIndex);
			size++;
		}
		else{
			while(current!=null){
				if(current.data.key.equals(key)){
					current.data.value = value;
					break;
				}
				prev = current;
				current= current.next;
			}
			if(current==null){
				prev.next = node;
				size++;
			}

		}

	}
	public void rehash(){
		ArrayList<Node<mappair<K, V>>> temp = bucket;
		bucket =new ArrayList<>();
		for(int i = 0 ; i < temp.size()*2 ; i++){
			bucket.add(null);
		}
		size=0;
		for(Node<mappair<K, V>> head: temp ){
			Node<mappair<K, V>> current = head;
			while(current!=null){
				put(current.data.key, current.data.value );
				current = current.next;
			}
		}
	}
	public V find(K key){
		int bucketIndex = getbucketIndex(key);
		Node<mappair<K, V>> current;
		current = bucket.get(bucketIndex);

		if(bucket.get(bucketIndex)==null){
			return null;
		}
		else{
			while(current!=null){
				if(current.data.key.equals(key)){
					return current.data.value;
				}
				current= current.next;
			}

			return null;
		}
	}

	public V remove(K key){
		int bucketIndex = getbucketIndex(key);
		Node<mappair<K, V>> prev, current;
		prev = null;
		current = bucket.get(bucketIndex);

		if(bucket.get(bucketIndex)==null){
			return null;
		}
		else{
			while(!current.data.key.equals(key)){

				prev = current;
				current= current.next;
			}
			if(prev==null){
				bucket.set(bucketIndex, current.next)	;
				size--;
			}
			else{
				prev = current.next;
				size--;
			}
		}

		return current.data.value;
	}

}
