package codility.wowbroSecondPracticeSample.sample_problem_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class SampleProblem01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        HashSet<Integer> resultDataSet = getYakSoo(n);
        ArrayList<Integer> array = new ArrayList<>(resultDataSet);
        Collections.sort(array);

        for(int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i)+" ");
        }
        System.out.println();
    }


    private static HashSet<Integer> getYakSoo(int n) {

        HashSet<Integer> hashSet = new HashSet<>();
        int result = 0;

        for(int i = 1; i < n/2 + 1; i++) {
            if(n % i == 0) {
                hashSet.add(i);
                hashSet.add(n/i);
            }
        }

        return hashSet;
    }
}
