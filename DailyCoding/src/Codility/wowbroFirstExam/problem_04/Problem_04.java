package codility.wowbroFirstExam.problem_04;

public class Problem_04 {

    public static int solution(int A, int B, int C, int D) {

        int case1 = new Jum(A,B).getJumMaxValue(new Jum(C,D));
        int case2 = new Jum(A,C).getJumMaxValue(new Jum(B,D));
        int case3 = new Jum(A,D).getJumMaxValue(new Jum(B,C));

        return getMaxCaseValue(case1, case2, case3);
    }

    private static int getMaxCaseValue(int case1, int case2, int case3) {
        return Math.max(case3,Math.max(case1,case2));
    }

}

class Jum {

    private int x;
    private int y;

    public Jum(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getJumMaxValue(Jum otherJum) {
        int tempCase1_1 = Math.max(getPoint(otherJum),getPoint2(otherJum));
        int tempCase1_2 = Math.max(getPoint3(otherJum),getPoint4(otherJum));
        return Math.max(tempCase1_1,tempCase1_2);
    }

    private int getPoint(Jum otherJum) {

        int lineX = Math.abs(x-otherJum.x);
        int lineY = Math.abs(y-otherJum.y);
        return lineX * lineX + lineY * lineY;
    }

    private int getPoint2(Jum otherJum) {
        int lineX = Math.abs(x-otherJum.y);
        int lineY = Math.abs(y-otherJum.x);
        return lineX * lineX + lineY * lineY;
    }

    private int getPoint3(Jum otherJum) {
        int lineX = Math.abs(y-otherJum.x);
        int lineY = Math.abs(x-otherJum.y);
        return lineX * lineX + lineY * lineY;
    }

    private int getPoint4(Jum otherJum) {
        int lineX = Math.abs(y-otherJum.y);
        int lineY = Math.abs(x-otherJum.x);
        return lineX * lineX + lineY * lineY;
    }

}
