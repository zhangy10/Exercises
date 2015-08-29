
/**
 * 
 * @author zhangy10 671205
 *
 *         Aug 29, 2015
 *
 *         QSort.java
 * 
 * 1. Implement for QuickSort
 * 2. Redesign for x + y = target in a sorted array
 * 
 */
public class QSort {

	private int[] theArray;
	private int arraySize;

	public int[] getArray() {
		return theArray;
	}

	public int getSize() {
		return arraySize;
	}

	public QSort(int arraySize) {
		this.arraySize = arraySize;
		theArray = new int[this.arraySize];
		generateRandomArray();
	}

	public static void main(String[] args) {

		QSort sort = new QSort(10);
		// int[] arr = { 10, 3, 15, 1, 5, 4, 6, 2, 12344, 22, 0, 212 };

		printArr(sort.getArray());
		printArr(sort.quickSort(sort.getArray(), 0, sort.getSize() - 1));
		Pair pair = sort.findNumber(50);
		System.out.println(pair != null ? pair.toString() : -1);
	}

	class Pair {
		int x;
		int y;

		public String toString() {
			return x + " " + y;
		}
	}

	public Pair findNumber(int target) {
		for (int i = 0; i < arraySize; i++) {
			int subTarget = target - theArray[i];
			if (subTarget >= 0) {
				int result = binarySearch(subTarget, 0, arraySize - 1);
				if (result != -1) {
					Pair pair = new Pair();
					pair.x = theArray[i];
					pair.y = theArray[result];
					return pair;
				}
			}
			else {
				break;
			}
		}

		return null;
	}

	private int binarySearch(int target, int lo, int lh) {
		if (lo > lh)
			return -1;
		int mid = (lo + lh) / 2;
		if (theArray[mid] == target)
			return mid;
		else if (theArray[mid] < target)
			return binarySearch(target, mid + 1, lh);
		else
			return binarySearch(target, lo, mid - 1);
	}

	public void generateRandomArray() {

		for (int i = 0; i < arraySize; i++) {

			// Generate a random array with values between
			// 10 and 59

			theArray[i] = (int) (Math.random() * 50) + 10;

		}

	}

	public static void printArr(int[] theArray) {
		for (int i = 0; i <= theArray.length - 1; i++) {
			if (i == 0)
				System.out.print(theArray[i]);
			else
				System.out.print(" " + theArray[i]);
		}
		System.out.println();
	}

	private int partition(int arr[], int left, int right) {
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];

		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		;

		return i;
	}

	public int[] quickSort(int arr[], int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1)
			quickSort(arr, left, index - 1);
		if (index < right)
			quickSort(arr, index, right);
		return arr;
	}

}
