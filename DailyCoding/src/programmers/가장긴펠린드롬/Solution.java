package programmers.가장긴펠린드롬;

public class Solution {

    public static int solution(String s) {
        int answer = 0;
        int maxAnswer = 0;
        char[] arrays = s.toCharArray();

        int preIndex = 0;
        int postIndex = 0;
        int j = 1;

        for(int i = 0; i < arrays.length; i++) {
            answer = 1;
            answer = getAnswer(answer, arrays, i - 1, i + 1);
            maxAnswer = Math.max(maxAnswer,answer);
        }

        return maxAnswer;
    }

    private static int getAnswer(int answer, char[] arrays, int preIndex, int postIndex) {
        while(preIndex >= 0 && postIndex < arrays.length) {
            if(arrays[preIndex] == arrays[postIndex]) {
                answer+=2;
                preIndex--;
                postIndex++;
                continue;
            }
            break;
        }
        return answer;
    }
}
