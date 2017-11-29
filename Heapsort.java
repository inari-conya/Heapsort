package algorithms;

public class Heapsort {
	int[] A = {5, 3, 17, 10, 84, 19, 6, 22, 9};
	
	public static void Hstest() {
		Heapsort tt = new Heapsort();
		//Heapsort.HeapSort(tt.A);
		Heapsort.BuildMinHeap(tt.A, tt.A.length-1);
		
		for(int i=0; i < tt.A.length; i++) {
			System.out.printf("%d ", tt.A[i]);
		}
	}
	
	private static void MaxHeapify(int[] A, int i, int hsize) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = i;
		
		if(l <= hsize && A[l] > A[i]) {
			largest = l;
		}
			
		if(r <= hsize && A[r] > A[largest]) {
			largest = r;
		}
		
		if(largest != i) {
			int tmp = A[i];
			A[i] = A[largest];
			A[largest] = tmp;
			Heapsort.MaxHeapify(A, largest, hsize);
		}
	}
	
	private static void BuildMaxHeap(int[] A, int hsize) {
		for(int i = A.length/2; i >= 0; i--) {
			Heapsort.MaxHeapify(A, i, hsize);
		}
	}
	
	private static void HeapSort(int A[]) {
		int hsize = A.length-1;
		int tmp = 0;
		Heapsort.BuildMaxHeap(A, hsize);
		for(int i=A.length-1; i >= 0; i--) {
			tmp = A[0];
			A[0] = A[i];
			A[i] = tmp;
			hsize--;
			Heapsort.MaxHeapify(A, 0, hsize);
		}
	}
	
	private static void BuildMinHeap(int[] A, int hsize) {
		for(int i = A.length/2; i >= 0; i--) {
			Heapsort.MinHeapify(A, i, hsize);
		}
	}
	
	private static void MinHeapify(int[] A, int i, int hsize) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int minist = i;
		
		if(l <= hsize && A[l] < A[i]) {
			minist = l;
		}
			
		if(r <= hsize && A[r] < A[minist]) {
			minist = r;
		}
		
		if(minist != i) {
			int tmp = A[i];
			A[i] = A[minist];
			A[minist] = tmp;
			Heapsort.MinHeapify(A, minist, hsize);
		}
	}
}
