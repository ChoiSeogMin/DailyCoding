package codility.Brackets;

import java.util.HashMap;
import java.util.Stack;

public class Brackets {

    private static char[] leftBrackets = {'{','[','('};
    private static Stack<Character> stack;
    private static HashMap<Character,Character> hashMap;

    static {
        hashMap = new HashMap<>();
        hashMap.put('}','{');
        hashMap.put(']','[');
        hashMap.put(')','(');
    }

    public static int solution(String S){
        stack = new Stack<>();
        for(char c: S.toCharArray()){
            if(isLeftBrakets(c)){
                stack.push(c);
            }else{//rightBrackets
                if(stack.size()==0)
                    return 0;
                if(hashMap.get(c) == stack.pop()){
                    continue;
                }else{
                    return 0;
                }
            }
        }
        if(stack.size() == 0)
            return 1;
        else
            return 0;
    }

    private static boolean isLeftBrakets(char c){
        for(char k : leftBrackets){
            if(k == c){
                return true;
            }
        }
        return false;
    }
}
