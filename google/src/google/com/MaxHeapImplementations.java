package google.com;

import java.util.Arrays;

public class MaxHeapImplementations {
	private int[] Heap;
	private int size;
	private int maxSize;
	
	
	public MaxHeapImplementations(int maxSize) {
		this.maxSize = maxSize;
		this.size =0;
	    Heap = new int[maxSize];
	}
	
	private int position(int pos) {
		return (pos-1)/2;
	}
	
	private int leftChild(int pos) {
		return pos*2;
	}
	
	private int rightChild (int pos) {
		return (pos*2) +1;
	}
	
	private boolean isLeaf(int pos) {
		if(pos>(size/2) && pos<=size) {
			return true;
		}
		
		return false;
	}
	
	private void swap(int fpos ,int spos) {
		int temp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = temp;
	}
	
	 private void maxHeapify(int pos) {
		 if(isLeaf(pos)) return;
		 
		 if(Heap[pos] <Heap[leftChild(pos)] ||
				 Heap[pos] <Heap[rightChild(pos)]) {
			 
			 if(Heap[rightChild(pos)]>Heap[leftChild(pos)]) {
				 swap(pos,rightChild(pos));
				 maxHeapify(rightChild(pos));
			 }else {
				 swap(pos,leftChild(pos));
				 maxHeapify(leftChild(pos));
			 }
		 }
		 
	 }
	 
	 public void insert(int value) {
		 Heap[size] = value;
		 
		 int current =size;
		 
		 while(Heap[current]>Heap[position(current)]) {
			
			 
				 swap(current,position(current));
				 current = position(current);
			 
		 }
		 size++;
	 }
	 
	 public int extractMax() {
		 int popped = Heap[0];
		 Heap[0] =Heap[size--];
		 maxHeapify(0);
		 return popped;
	 }
	
	

	public static void main(String[] args) {
		MaxHeapImplementations maxHeap = new MaxHeapImplementations(15);
		
		maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        System.out.println(Arrays.toString(maxHeap.Heap));
        System.out.println(maxHeap.extractMax());
        

	}

	

}
