package codility.Triangle;

//미해결
public class Triangle {

    private static boolean isPossibleTriangle = false;

    public static int solution(int[] arr) {
        combination(new int[arr.length], 0, arr.length, 3, 0,arr);
        if(isPossibleTriangle){
            return 1;
        }else{
            return 0;
        }
    }

    public static boolean isTriangle(int[] arr,int[] data) {

        if(data[arr[0]] + data[arr[1]] < data[arr[2]]){
            return false;
        }
        if(data[arr[0]] + data[arr[2]] < data[arr[1]]){
           return false;
        }
        if(data[arr[1]] + data[arr[2]] < data[arr[0]]){
            return false;
        }

        return true;
    }

    public static void combination(int[] arr, int index, int n, int r, int target,int[] data) {
        if (r == 0){
            if(isTriangle(arr,data)){
                isPossibleTriangle = true;
            }
        }
        else if (target == n) return;
        else { arr[index] = target;
            combination(arr, index + 1, n, r - 1, target + 1, data);
            combination(arr, index, n, r, target + 1, data);
        }
    }
}
