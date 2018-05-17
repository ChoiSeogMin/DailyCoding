package codility.Sorting.NumberOfDisIntersections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class NumberOfDisIntersections {

        public static int solution(int[] A) {
            int l = A.length;

            long[] A1 = new long[l];
            long[] A2 = new long[l];

            for(int i = 0; i < l; i++){
                A1[i] = (long)A[i] + i;
                A2[i] = -((long)A[i]-i);
            }

            Arrays.sort(A1);
            Arrays.sort(A2);

            long cnt = 0;

            //여기부터
            for(int i = A.length - 1; i >= 0; i--) {
                int pos = Arrays.binarySearch(A2, A1[i]);
                if(pos >= 0) {
                    while(pos < A.length && A2[pos] == A1[i]) {
                        pos++;
                    }
                    cnt += pos;
                } else { // element not there
                    int insertionPoint = -(pos+1);
                    cnt += insertionPoint;
                }
            }

            long sub = (long)l*((long)l+1)/2;
            cnt = cnt - sub;

            if(cnt > 1e7) return -1;

            return (int)cnt;
        }
}

