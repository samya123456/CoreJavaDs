package google.com;

import java.util.Arrays;

public class MinHeapImpl {

	private int[] Heap;
	private int size;
	private int maxSize;

	public MinHeapImpl(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		Heap = new int[maxSize];
	}

	private boolean isLeaf(int pos) {
		if (pos > (size - 1) / 2 && pos <= size) {
			return true;
		}
		return false;
	}

	private int leftChild(int pos) {
		return 2 * pos;
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	private int parent(int pos) {
		return (pos - 1) / 2;
	}

	private void swap(int fpos, int spos) {
		int temp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = temp;
	}

	public void minHeapify(int pos) {
		if (isLeaf(pos)) {
			return;
		}

		if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {

			if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
				swap(pos, rightChild(pos));
				minHeapify(rightChild(pos));
			} else {
				swap(pos, leftChild(pos));
				minHeapify(leftChild(pos));
			}

		}
	}
	
	public void insert(int element) {
		Heap[size] = element;
		int current =size;
		while(Heap[current]<Heap[parent(current)]) {
			
				swap(current,parent(current));
				current =parent(current);
			
		}
		size++;
	}
	
	public int extractMin() {
		int popped = Heap[0];
		Heap[0] = Heap[size--];
		minHeapify(0);
		return popped;
	}

	public static void main(String[] args) {
		
		MinHeapImpl minHeap = new MinHeapImpl(15);
		
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(17);
		minHeap.insert(10);
		minHeap.insert(84);
		minHeap.insert(19);
		minHeap.insert(6);
		minHeap.insert(22);
		minHeap.insert(9);
        System.out.println(Arrays.toString(minHeap.Heap));
        
        

	}

}
