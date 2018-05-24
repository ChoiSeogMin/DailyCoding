package codility.wowbroSecondPracticeSample.sample_problem_03;

import java.util.Scanner;

public class SampleProblem03 {

    private static final String LEAPYEAR = "Leap Year";
    private static final String NOTLEAPYEAR = "Not Leap Year";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if(isLeapYear(n)) {
          System.out.print(LEAPYEAR);
          return;
        }
        System.out.print(NOTLEAPYEAR);
    }

    private static boolean isLeapYear(int n) {

        if(n % 4 == 0) {

            if(n % 100 == 0) {

                if(n % 400 == 0) {
                    return true;
                }
                return false;
            }

            return true;
        }

        return false;
    }
}
