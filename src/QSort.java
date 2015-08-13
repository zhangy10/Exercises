
public class QSort {

	public static void main(String[] args) {

		QSort sort = new QSort();
		int[] arr = { 10, 3, 15, 1, 5, 4, 6, 2 , 12344, 22, 0, 212};
		printArr(arr);
		printArr(sort.quickSort(arr, 0, arr.length - 1));
	}

	public static void printArr(int[] arr) {
		for (int i = 0; i <= arr.length - 1; i++) {
			if (i == 0)
				System.out.print(arr[i]);
			else
				System.out.print(" " + arr[i]);
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
