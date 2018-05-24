package codility.wowbroSecondPracticeSample.sample_problem_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SampleProblem02 {

    private static HashMap<Integer,String> hashMap = new HashMap<>();

    static {

        hashMap.put(10,"a");
        hashMap.put(11,"b");
        hashMap.put(12,"c");
        hashMap.put(13,"d");
        hashMap.put(14,"e");
        hashMap.put(15,"f");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<String> array = getSixTeenNumbers(n);

        for(int i = array.size(); i>0; i--) {
            System.out.print(array.get(i-1));
        }

        System.out.println();

    }

    private static ArrayList<String> getSixTeenNumbers(int n) {

        ArrayList<String> array = new ArrayList<>();

        while(true) {

            int rest = n % 16;
            n = n / 16;
            if(rest >= 10) {
                array.add(hashMap.get(rest));
            } else {
                array.add(String.valueOf(rest));
            }

            if(n < 16) {
                if(n >= 10) {
                    array.add(hashMap.get(n));
                } else {
                    array.add(String.valueOf(n));
                }
                break;
            }
        }

        return array;
    }
}
