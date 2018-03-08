package dataStruckture.problem_3015_오아시스재결합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_3015 {
	
	private static Stack<Person> stack = new Stack<Person>();
	
    public static void main(String args[]) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.valueOf(br.readLine());
    	long[] data = new long[n];
    	
    	for(int i=0; i<n; i++){
    		data[i] = Integer.valueOf(br.readLine());
    	}
    	
    	System.out.println(getSolution(data));
    }
    
    private static long getSolution(long[] data){
    	long result = 0;
    	long count = 1;
    	for(int i=0; i<data.length; i++){
    		while(true){
	    		if(stack.isEmpty()){
	    			stack.add(new Person(data[i],count));
	    			count = 1;
	    			break;
	    		}else{
    				Person top = stack.peek();
        			if(top.height>data[i]){
        				result += 1;
        				stack.add(new Person(data[i],count));
        				count = 1;
        				break;
        			}else if(top.height==data[i]){
        				long k = stack.pop().count;
        				result += k;
        				count += k;
        			}else{//top.height < data[i]
        				result += stack.pop().count;
        			}
	    		}
    			
    		}
    	}
    	return result;
    }
}

class Person{
	
	public long height;
	public long count;
	
	public Person(long height, long count){
		this.height = height;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Person [height=" + height + ", count=" + count + "]";
	}
}
