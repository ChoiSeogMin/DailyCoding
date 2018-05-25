package goorm.binarySearch;

public class BinarySearch {

    public static boolean binarySearchTree(int[] array, int startIndex, int endIndex, int findValue) {

        boolean isFind = false;

        while(startIndex <= endIndex) {

            int mid = (startIndex + endIndex) / 2;

            if(array[mid] == findValue) {
                isFind = true;
                break;
            }

            if(array[mid]>findValue) {
                endIndex = mid -1;
            } else {
                startIndex = mid + 1;
            }

        }
        return isFind;
    }
}
