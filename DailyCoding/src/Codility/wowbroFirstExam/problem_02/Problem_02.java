package codility.wowbroFirstExam.problem_02;

import java.util.HashMap;

public class Problem_02 {

    private static HashMap<Character,Integer> deck = new HashMap<Character,Integer>();

    static {
        deck.put('A',14);
        deck.put('K',13);
        deck.put('Q',12);
        deck.put('J',11);
        deck.put('T',10);
        deck.put('9',9);
        deck.put('8',8);
        deck.put('7',7);
        deck.put('6',6);
        deck.put('5',5);
        deck.put('4',4);
        deck.put('3',3);
        deck.put('2',2);
    }

    public static int solution(String A, String B) {
        // write your code in Java SE
        return getWinnerConunt(A, A.toCharArray(), B.toCharArray());
    }

    private static int getWinnerConunt(String A, char[] alecCardList, char[] bobCardList) {

        int winnerConunt = 0;

        for(int i = 0; i <A.length(); i++) {
            if(isAlecWin(alecCardList[i],bobCardList[i])) {
                winnerConunt++;
            }
        }
        return winnerConunt;
    }

    private static boolean isAlecWin(char alecCard, char bobCard) {
        return deck.get(alecCard) > deck.get(bobCard);
    }
}
