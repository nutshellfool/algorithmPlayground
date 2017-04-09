package test.me.lirui.algo.sort; 

import junit.framework.Assert;
import me.lirui.algo.sort.BaseSort;
import me.lirui.algo.sort.BubbleSort;
import me.lirui.algo.sort.InsertionSort;
import me.lirui.algo.sort.MergeSort;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* MergeSort Tester. 
* 
* @author <Authors name> 
* @since <pre>四月 9, 2017</pre> 
* @version 1.0 
*/ 
public class SortTest {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 



@Test
public void testBubbleSort() throws Exception {
    BubbleSort bubbleSort = new BubbleSort(){
        @Override
        public void onPostSort(String outPut, int[] resultData) {
            Assert.assertEquals(true, _isInAscendOrder(resultData));
        }
    };
    bubbleSort.doSort();
}

@Test
public void testInsertionSort() throws Exception {
    InsertionSort insertionSort = new InsertionSort(){
        @Override
        public void onPostSort(String outPut, int[] result) {
            Assert.assertEquals(true, _isInAscendOrder(result));
        }
    };
    insertionSort.doSort();
}

/** 
* 
* Method: onDoSort(int[] inputData) 
* 
*/ 
@Test
public void testMergeSort() throws Exception {
    MergeSort mergeSort = new MergeSort(){
        @Override
        public void onPostSort(String outPut, int[] result) {
            Assert.assertEquals(true, _isInAscendOrder(result));
        }
    };

    int[][][] array;
    mergeSort.doSort();
}

//@Test
//public void testSortRank() throws Exception {
//    BubbleSort bubbleSort = new BubbleSort();
//    long bubbleTime = bubbleSort.doSort();
//
//    InsertionSort insertionSort = new InsertionSort();
//    long insertionTime = insertionSort.doSort();
//
//    MergeSort mergeSort = new MergeSort();
//    long mergeTime = mergeSort.doSort();
//
////    Assert.assertEquals(true, mergeTime <= insertionTime);
////    Assert.assertEquals(true, mergeTime <= bubbleTime);
////    Assert.assertEquals(insertionTime, bubbleTime);
//}


private boolean _isInAscendOrder(int[] array) {
    if (array == null || array.length == 0) return true;

    for (int i = 0; i < array.length - 1; i++) {
        if (array[i+1] < array[i]) return false;
    }

    return true;
}

} 
