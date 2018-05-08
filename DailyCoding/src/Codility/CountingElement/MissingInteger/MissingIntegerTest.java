package codility.CountingElement.MissingInteger;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


class MissingIntegerTest {


    @Test
    public void 예제테스트() {
        int[] A = {1, 3, 6, 4, 1, 2};
        assertThat(MissingInteger.solution(A),is(5));
    }

    @Test
    public void 예제테스트2() {
        int[] A = {1, 2, 3};
        assertThat(MissingInteger.solution(A),is(4));

    }

    @Test
    public void 예제테스트3() {
        int[] A = {-1, -3};
        assertThat(MissingInteger.solution(A),is(1));
    }

    @Test
    public void 예제테스트4() {
        int[] A = {1, 2, 3, 4, 5, 6};
        assertThat(MissingInteger.solution(A),is(7));
    }


    @Test
    public void 예제테스트5() {
        int[] A = {1, 2, 3, 5, -2};
        assertThat(MissingInteger.solution(A),is(4));
    }
}