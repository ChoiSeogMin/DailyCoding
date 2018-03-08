package dataStruckture.heap.problem_11279_최대힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11279 {

	public static void main(String[] args) throws Exception{
		StringBuilder sb= new StringBuilder();
		int[] data = new InputDevice().getInitialData();
		MaxHeapFactory mf = new MaxHeapFactory(data.length);
		for(int i=0; i<data.length; i++){
			if(data[i]==0){
				//pop
				sb.append(mf.popHeapData()+"\n");
			}else{//push
				mf.addHeapData(data[i]);
			}
		}
		
		System.out.println(sb.toString());
	}
	
}

class MaxHeapFactory{
	int[] heap;
	int remain;
	
	public MaxHeapFactory(int leng){
		heap = new int[leng];
		remain = 0;
	}
	
	public int popHeapData(){
		if(remain==0)
			return 0;
		int result = heap[0];
		heap[0] = heap[remain - 1];//마지막꺼
		heap[remain - 1] = 0;
		int sIndex = 0;
		while(sIndex<heap.length){
			int nIndex = (sIndex+1)*2-1;
			
			if(nIndex < heap.length){
				if(nIndex+1 < heap.length){
					if(heap[nIndex]<heap[nIndex+1]){
						if(heap[nIndex+1]>heap[sIndex])
							swap(nIndex+1,sIndex);
						sIndex = nIndex + 1;
					}else{
						if(heap[nIndex]>heap[sIndex])
							swap(nIndex,sIndex);
						sIndex = nIndex;
					}
				}else{
					if(heap[nIndex]>heap[sIndex]){
						swap(nIndex,sIndex);
					}
					sIndex = nIndex;
				}
			}else{
				break;
			}
		}
		
		remain--;
		return result;
	}
	
	private void swap(int sIndex,int eIndex){
		int temp = heap[sIndex];
		heap[sIndex] = heap[eIndex];
		heap[eIndex] = temp;
	}
	
	public void addHeapData(int num){
		heap[remain++] = num;
		int index = remain-1; 
		while(index!=0){
			int nIndex = (index - 1)/2;
			if(heap[nIndex]<heap[index]){
				int temp = heap[nIndex];
				heap[nIndex] = heap[index];
				heap[index] = temp;
			}
			index = (index - 1)/2;
		}
	}
}

class InputDevice{
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int[] getInitialData() throws NumberFormatException, IOException{
		int[] data = new int[Integer.valueOf(br.readLine())];
		
		for(int i=0; i<data.length; i++){
			data[i] = Integer.valueOf(br.readLine());
		}
		
		return data;
	};
}
