package codility.EquiLeader;

public class EquiLeader {

    public static int solution(int[] A) {



        return 0;
    }

    private static int getDominatorNum(int[] A,int startIndex,int endIndex) {

        int dominant = 0;
        int size = 0;

        for(int i=startIndex; i<endIndex; i++) {
            if(size==0) {
                dominant = A[i];
            } else {
                if(dominant == A[i]) {
                  size++;
                } else {
                  size--;
                }
            }
        }

        return size > 0 ? dominant : -1;
    }

}

class Dominator{

    public int size;
    public int dominator;

    public Dominator(int size, int dominator) {
        this.size = size;
        this.dominator = dominator;
    }
}



