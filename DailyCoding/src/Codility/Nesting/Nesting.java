package codility.Nesting;

import java.util.Stack;

public class Nesting {

    private static final char LEFTNEST = '(';
    private static final char RIGHTNEST = ')';

    private static Stack<Character> nestBasket = new Stack<>();

    public static int solution(String A){

        nestBasket.clear();//test를 위한 초기화

        for (char nest : A.toCharArray()) {
            if (isLeftNest(nest)) {
                putNestBasket(nest);
            } else {
                try {
                    if (!isLeftNest(popNestBasket(nest))) {
                       return 0;
                    }
                } catch (RuntimeException ex) {
                    return 0;
                }
            }
        }
        return isEmptyNestBasket() ? 1 : 0;
    }

    private static boolean isEmptyNestBasket(){

        return nestBasket.size() == 0 ? true : false;
    }

    private static boolean isLeftNest(char nest){

        return nest == LEFTNEST ? true : false;
    }

    private static void putNestBasket(char nest){

        nestBasket.add(nest);
    }

    private static char popNestBasket(char nest){

        return nestBasket.pop();
    }
}
