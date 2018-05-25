package goorm.rangeTree;


public class RangeArray{

    int data[];
    int question[];
    int n;
    int m;

    public RangeArray(int n){
        this.n =n;
        int m = 1;
        int arrNum = 1;
        while(m<n) {
            m *=2;
            arrNum += m;
        }

        this.m = m;
        data = new int[arrNum];
        question = new int[m];
        setIntialRangeData();
        setIntialQuestionData();
    }

    private void setIntialRangeData(){
        int temp = data.length;
        data[0] = n;
        int nextIndex = 0;
        for(int i=0; i<data.length; i++) {
            nextIndex = (i+1) * 2;
            if(nextIndex<data.length) {
                data[nextIndex-1] = data[i] / 2;
                data[nextIndex] = data[i]-data[nextIndex-1];
            }
        }
    }

    private void setIntialQuestionData() {
        int j = 0;
        int k =1;
        for(int i=data.length-m; i<data.length; i++) {
            if(data[i]==1) {
                question[j++] = k++;
            }else {
                question[j++] = data[i];
            }
        }
    }

    public void findResultData() {

        int j = data.length-1;
        int i = question.length-1;
        while(true) {
            if(data[j]==1) {
                System.out.println("result:"+question[i]);
                break;
            }
            j--;
            i--;
        }
    }

    public int getIndex(int count){
        int temp = count;
        int nextInt = 0;
        int nInt = 0;
        while(true){
            nInt = (nextInt+1) * 2;
            if(nInt>=data.length)
                break;

            if(data[nInt-1]>=temp) {
                nextInt = nInt-1;
            }else {
                nextInt = nInt;
                temp -= data[nInt-1];
            }
        }
        return nextInt;
    }

    public void deleteIndex(int count) {
        int c = getIndex(count);
        while(c!=0) {
            data[c]--;
            c= (c-1)/2;
        }
        data[0]--;
    }

    public void printArrData() {
        for(int i=0; i<data.length; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    public void printQuestionArrData() {
        for(int i=0; i<question.length; i++) {
            System.out.print(question[i]+" ");
        }
        System.out.println();
    }
}
