package google.com;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {

	Map<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>();
	int capacity;
	int leastKey;
	

	public LRUCache(int capacity) {
		this.capacity = capacity;

	}

	public int get(int key) {
		Integer temp = cache.get(key);
		if (temp == null) {
			return -1;
		} else {
			int value =  cache.get(key);
			cache.remove(key);
			cache.put(key,value);
			return temp;
		}

	}

	public void put(int key, int value) {
		if(cache.containsKey(key)) {
			cache.remove(key);
			cache.put(key,value);
		}else if (cache.size() < capacity) {
			cache.put(key, value);
		} else {
			
			 List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(cache.entrySet());
				if(!list.isEmpty()) {
					leastKey = list.get(0).getKey();
					cache.remove(leastKey);
				}
			cache.put(key, value);

		}

	}

	public static void main(String[] args) {
		/*LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(lRUCache.get(1));    // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		System.out.println(lRUCache.get(2));    // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		System.out.println(lRUCache.get(1));    // return -1 (not found)
		System.out.println(lRUCache.get(3));    // return 3
		System.out.println(lRUCache.get(4)); */   // return 4

		
		  /*LRUCache lRUCache = new LRUCache(2); 
		  lRUCache.put(2, 1); 
		  lRUCache.put(2, 2);
		  System.out.println(lRUCache.get(2)); //2 
		  lRUCache.put(1, 1); 
		  lRUCache.put(4, 1);
		  System.out.println(lRUCache.get(2)); */  //-1
		
		LRUCache lRUCache = new LRUCache(2); 
		  lRUCache.put(2, 1); 
		  lRUCache.put(1, 1);
		  lRUCache.put(2, 3); 
		  lRUCache.put(4, 1); 
		  System.out.println(lRUCache.get(1)); //1
		  System.out.println(lRUCache.get(2)); //3
		 

	}

}
