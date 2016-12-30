
public class BinarySearch {

	public int doBinarySearch(int a[], int key) {

		int start = 0;
		int end = a.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == a[mid]) {
				return mid;
			}
			if (key < a[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public int doBinarySearchRecursive(int a[], int start, int end, int key) {

		if (start < end) {
			int mid = start + (end - start) / 2;
			if (key < a[mid]) {
				return doBinarySearchRecursive(a, start, mid, key);
			} else if (key > a[mid]) {
				return doBinarySearchRecursive(a, mid + 1, end, key);
			} else {
				return mid;
			}
		}

		return -(start + 1);
	}

	public static void main(String[] args) {
		int arr[] = { 12, 13, 15, 16, 13 };
		int key = 13;
		BinarySearch bin = new BinarySearch();
		System.out.println(bin.doBinarySearch(arr, key));
		System.out.println(bin.doBinarySearchRecursive(arr, 0, arr.length - 1, key));

	}

}
