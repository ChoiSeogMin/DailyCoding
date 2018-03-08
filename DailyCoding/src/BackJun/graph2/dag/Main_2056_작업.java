package graph2.dag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2056_작업 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputDevice_2056 input = new InputDevice_2056();
		
		JobNode[] jobarr = input.getJobArr();
		int[] preJobCount = input.getJobCount();
		
		System.out.println(solution(jobarr,preJobCount));
		
	}
	
	private static int solution(JobNode[] jobarr,int[] preJobCount){
		int result = 0;
		Queue<JobNode> queue = new LinkedList<JobNode>();
		for(int i=1; i<preJobCount.length; i++){
			if(preJobCount[i]==0){
				queue.add(jobarr[i]);
			}
		}
		
		while(queue.size() != 0){
			JobNode job = queue.poll();//이번에 끝낼잡
			ArrayList<JobNode> arr = job.preFinshJob;
			for(JobNode k:arr){
				if(k.totalEndTime == 0){
					k.totalEndTime = job.jobTime + job.totalEndTime;
				}else{
					k.totalEndTime = Math.max(k.totalEndTime, job.jobTime+job.totalEndTime);
				}
				preJobCount[k.order] -= 1;
				if(preJobCount[k.order]==0){
					queue.add(k);	
				}
			}
			

			result = Math.max(job.totalEndTime + job.jobTime,result);
			
		}
		
		
		return result;
	}
}

class InputDevice_2056 {

	JobNode[] jobarr;
	int[] preJobCount;

	
	public InputDevice_2056() throws NumberFormatException, IOException{
		getInitialData();
	}
	private void getInitialData() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		jobarr = new JobNode[n + 1]; // 1 ~ n
		preJobCount = new int[n + 1];
		
		for(int i=1; i<n+1; i++){
			jobarr[i] = new JobNode(i);
		}
		
		
		String[] data = null;
		for (int i = 1; i < n + 1; i++) {
			data = br.readLine().split(" ");
			jobarr[i].jobTime = Integer.valueOf(data[0]);
			int j = Integer.valueOf(data[1]);
			preJobCount[i] = j;
			for (int k = 0; k < j; k++) {
				int pre = Integer.valueOf(data[2+k]);
				jobarr[pre].addPreFinshJob(jobarr[i]);
			}
		}
	}
	
	public JobNode[] getJobArr(){
		return jobarr;
	}
	
	public int[] getJobCount(){
		return preJobCount;
	}
}

class JobNode {

	public int order;
	public int jobTime;
	public int totalEndTime = 0;
	
	public ArrayList<JobNode> preFinshJob = new ArrayList<>();
	
	public JobNode(){
		
	}
	
	public JobNode(int order) {
		this.order = order;
	}

	public void addPreFinshJob(JobNode jobNode) {
		preFinshJob.add(jobNode);
	}
}
