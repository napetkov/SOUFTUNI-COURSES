package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {
    @Test
    public void testBubbleSort(){
        int[] numbers = {3,2,5,-2,8,9,13};
        int[] sortedArr = {-2,2,3,5,8,9,13};
        Bubble.sort(numbers);

        Assert.assertArrayEquals(sortedArr,numbers);

    }

}