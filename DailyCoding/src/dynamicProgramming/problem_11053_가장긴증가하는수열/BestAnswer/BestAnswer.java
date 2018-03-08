package dynamicProgramming.problem_11053_가장긴증가하는수열.BestAnswer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BestAnswer {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine().trim());
		
		int[][] arr = new int[N][2];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = i;
		}
		
		int[] stack = new int[N];
		stack[0] = arr[0][0];
		int size = 1;
		
		for (int i = 1; i < N; i++) {
			int index = binarySearch(stack, 0, size - 1, arr[i][0]);
			if (index >= 0) {
				continue;
			}
			
			index = -(index + 1);
			stack[index] = arr[i][0];
			if (index == size) {
				size++;
			}
		}
		System.out.println(size);
	}
	
	public static int binarySearch(int[] arr, int start, int end, int key) {
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (arr[mid] < key) {
				start = mid + 1;
			}
			else if (arr[mid] > key) {
				end = mid - 1;
			}
			else {
				return mid;
			}
		}
		return -(start + 1);
	}
}