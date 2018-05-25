package goorm.subset;

public class Subset {

    public static void main(String[] args) {
        int[] value = {1,2,3,4,5};
        int[] data = getSubset(value);

        for(int v:data) {
            System.out.print(v+" ");
        }

        Integer integer = 7;
    }

    public static int[] getSubset(int[] data) {

        int num = data.length;
        int[] subSetData = new int[1<<num];

        for(int i=0; i<1<<num; i++){
            for(int j=0; j<data.length; j++){
                if((i&(1<<j))==(1<<j)){
                    subSetData[i] += data[j];
                }
            }
        }

        return subSetData;
    }
}
