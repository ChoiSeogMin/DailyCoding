package goorm.lcngcd;

public class LCN_GCD {

    public static void main(String[] args) {

        System.out.println(gcd(24,16));

        System.out.println(lcn(gcd(24,16),24,16));
    }

    private static int gcd(int n1,int n2){
        int temp = 0;

        while(n1%n2!=0){
            temp = n1%n2;
            n1 = n2;
            n2 = temp;
        }

        return n2;
    }

    private static int lcn(int gcd,int n1,int n2){

        int lcn = ((n1 / gcd) * (n2 / gcd)) * gcd;

        return lcn;
    }
}
