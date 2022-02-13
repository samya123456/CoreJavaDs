import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertUpdateDeleteo1TimeComplexity {

	static List<Integer> list = new ArrayList<Integer>();
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	static int count = 0;

	static void insert(int item) {
		list.add(item);
		map.put(item, count++);

	}

	static int search(int item) {
		int index = map.get(item);
		return list.get(index);
	}

	static void update(int item, int updated) {
		int index = map.get(item);
		list.remove(index);
		list.add(index, updated);
		map.remove(item);
		map.put(updated, index);

	}

	static void remove(int item) {
		
		int lastItem = list.get(list.size()-1);
		int index = map.get(item);
		map.remove(item);
		Collections.swap(list, index, list.size()-1);
		list.remove(list.size()-1);
		map.put(lastItem, index);

	}

	public static void main(String[] args) {

		insert(5);
		insert(7);
		insert(9);
		update(9, 8);
		remove(7);

	}

}
