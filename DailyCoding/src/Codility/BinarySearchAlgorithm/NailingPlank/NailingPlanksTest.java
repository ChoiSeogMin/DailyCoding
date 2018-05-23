package codility.BinarySearchAlgorithm.NailingPlank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NailingPlanksTest {

    @Test
    public void howUseBiinarySearchTree() {
        int[] A = {1,4,5,8};
        int[] B = {4,5,9,10};
        int[] C = {4,6,7,10,2};
        assertEquals(4, NailingPlanks.solution(A,B,C));
    }


    @Test
    public void binarySearchTreeFindTest() {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
        boolean isFind = NailingPlanks.binarySearchTree(data,0,2,3);
        assertTrue(isFind);
    }
}