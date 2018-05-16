package codility.Sorting.NumberOfDisIntersections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class NumberOfDisIntersections {

    public static int solution(int[] data) {

        Arrays.sort(data); //오름차순
        Line[] lineArray = new Line[data.length];

        for(int i = 0; i < data.length; i++) {//i는 인덱스 data[i] 는 길이
            lineArray[i] = new Line(i-data[i],i+data[i]);
        }

        Arrays.sort(lineArray, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.leftLine - o2.leftLine;
            }
        });

        return -1;
    }
}

class Line{

    public int leftLine;
    public int rightLine;

    public Line(int leftLine, int rightLine) {
        this.leftLine = leftLine;
        this.rightLine = rightLine;
    }
}
