package random_question.problem_Dahun_03;

public class Dahun03 {

    public static void main(String[] args){
        System.out.println(lcn(gcd(6,2),6,2));
        String[] data = {"722/148+360/176","978/1212+183/183","358/472+301/417","780/309+684/988","258/840+854/686"};

        solution(data);
    }

    private static void solution(String[] data) {

        long bunza1 = 0;
        long bunmo1 = 0;

        long bunza2 = 0;
        long bunmo2 = 0;

        long resultBunza = 0;
        long resultDivide = 0;
        for(String d:data){
            String[] divide = d.split("\\+");
            String[] divideNum = divide[0].split("/");
            String[] divideNum2 = divide[1].split("/");

            bunza1 = Long.valueOf(divideNum[0]);
            bunmo1 = Long.valueOf(divideNum[1]);

            bunza2 = Long.valueOf(divideNum2[0]);
            bunmo2 = Long.valueOf(divideNum2[1]);

            long commonBunmo = lcn(gcd(bunmo1,bunmo2),bunmo1,bunmo2);
            bunza1 = bunza1 * (commonBunmo / bunmo1);
            bunza2 = bunza2 * (commonBunmo / bunmo2);

            resultBunza = bunza1 + bunza2;
            resultDivide = gcd(commonBunmo,resultBunza);

            System.out.println((resultBunza/resultDivide) + "/" + (commonBunmo/resultDivide));
        }
    }

    public static long gcd(long n1,long n2){
        long temp = 0;

        while(n1%n2!=0){
            temp = n1%n2;
            n1 = n2;
            n2 = temp;
        }

        return n2;
    }

    private static long lcn(long gcd,long n1,long n2){

        long lcn = ((n1 / gcd) * (n2 / gcd)) * gcd;

        return lcn;
    }
}
