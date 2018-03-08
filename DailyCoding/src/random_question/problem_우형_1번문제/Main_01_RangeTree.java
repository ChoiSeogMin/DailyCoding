package random_question.problem_우형_1번문제;

public class Main_01_RangeTree {

        public static void main(String[] args) {
            long time = System.currentTimeMillis();
            int n = 10000000;
            int k = 1;
            int j = 1;
            int d = 1;
            RangeArray ra = new RangeArray(n);
            int startIndex = 0;
            int next = 0;
            int count;
            while (n > 1) {
                next = (startIndex + k) % n;
                ra.deleteIndex(next + 1);
                startIndex = next - 1;
                n--;
                k += j;
            }
            ra.findResultData();
            System.out.println("time:" + (System.currentTimeMillis() - time));
        }

}
