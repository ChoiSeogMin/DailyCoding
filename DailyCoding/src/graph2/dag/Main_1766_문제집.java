package graph2.dag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main_1766_문제집 {

	private static StringBuilder sb = new StringBuilder();
	/***
	 * ArrayList는 1000000(백만개) 까지는 겁나 빠르다.
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		InputDevice2 input = new InputDevice2();
		input.initData();
		
		int[] lineData = input.getLineData();
		Student[] students = input.getStudents();
		
		solution(lineData,students);
		System.out.println(sb.toString());
	}
	
	private static void solution(int[] lineData, Student[] students){
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i=1; i<lineData.length; i++){
			if(lineData[i]==0){
					queue.add(i);
			}
		}
		
		while(queue.size()!=0){
			int k = queue.poll();
			
			if(students[k]==null){
				sb.append(k+" ");
			}else{
				sb.append(k+" ");
				ArrayList<Student> arr = students[k].getStudentNodeList();
				for(int m=0; m<arr.size(); m++){
					int j = arr.get(m).n;
					lineData[j] -= 1;
					if(lineData[j] == 0){
						queue.add(j);
					}
				}
			}
		}
	}
}

class InputDevice2{
	int[] lineData;
	Student[] students;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void initData() throws NumberFormatException, IOException{
		String[] initialData = br.readLine().split(" ");
		int n = Integer.valueOf(initialData[0]);
		lineData = new int[n+1]; //0은안쓴다.
		students = new Student[n+1]; //0은 안쓴다.
		
		int m = Integer.valueOf(initialData[1]);
		int from = 0;
		int to = 0;
		for(int i=1; i<m+1; i++){
			String[] line = br.readLine().split(" ");
			from = Integer.valueOf(line[0]);
			to = Integer.valueOf(line[1]);
			
			if(students[from]!=null){
				students[from].addStudent(to);
				lineData[to] += 1;
			}else{
				students[from] = new Student(from);
				students[from].addStudent(to);
				lineData[to] += 1;
			}
		}
	}
	
	public int[] getLineData(){
		return lineData;
	}
	
	public Student[] getStudents(){
		return students;
	}
}

class Student{
	public int n;
	ArrayList<Student> array = new ArrayList<>();
	
	public Student(int n){
		this.n = n;
	}
	
	public void addStudent(int k){
		array.add(new Student(k));
	}
	
	public ArrayList<Student> getStudentNodeList(){
		return this.array;
	}
}

