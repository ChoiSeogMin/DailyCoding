package codility.wowbroFirstExam.problem_01;

import java.util.Stack;

public class Problem_01 {

    private static Stack<Integer> stack = new Stack<>();

    public static int solution(String S) {
        // write your code in Java SE 8
        if (isNullString(S)) {
            return -1;
        }

        try {
            inputStringValue(S.split(" "));
            return getResultValue();
        } catch(Exception ex) {
            return -1;
        }
    }

    private static int getResultValue() {
        int finalResult = stack.pop();
        return finalResult < 0 ? -1 : finalResult;
    }

    private static boolean isNullString(String S) {
        return S == null;
    }

    private static void inputStringValue(String[] strings) throws Exception {

        for (String s : strings) {

            switch (s) {
                case "DUP":
                    operateDup();
                    break;

                case "POP":
                    operatePop();
                    break;

                case "+":
                    opeatePlus();
                    break;

                case "-":
                    operateMinus();
                    break;

                default:
                    opearteNum(s);
            }
        }
    }

    private static void operateDup() {
        int num = stack.pop();
        stack.add(num);
        stack.add(num);
    }

    private static void operatePop() {
        stack.pop();
    }

    private static void opearteNum(String s) throws IllegalArgumentException{
        long value = Long.valueOf(s);
        if(value < 0 || value > ((1<<20)-1))
            throw new IllegalArgumentException();
        stack.push(Integer.valueOf((int)value));
    }

    private static void opeatePlus() throws IllegalArgumentException {
        int k = stack.pop();
        int m = stack.pop();
        long sum = (long)k + (long)m;
        if(sum > ((1<<20)-1))
            throw new IllegalArgumentException();
        stack.add((int)sum);
    }

    private static void operateMinus() throws IllegalArgumentException {
        int i = stack.pop();
        int j = stack.pop();
        long minus = (long)i - (long)j;
        if(minus < 0)
            throw new IllegalArgumentException();
        stack.add((int)minus);
    }
}
