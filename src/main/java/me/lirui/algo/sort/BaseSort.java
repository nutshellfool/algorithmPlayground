package me.lirui.algo.sort;

/** Created by RichardLee on 2017/4/2. */
public abstract class BaseSort {

  public abstract int[] onPrepareInputData();

  public abstract void onDoSort(int[] inputData);

  public abstract void onPostSort(String outPut, int[] resultData);

  public long doSort() {
    int[] inputData = onPrepareInputData();

    long startTime = System.nanoTime();
    onDoSort(inputData);
    long endTime = System.nanoTime();

    long excuteRunningTime = endTime - startTime;
    String result = String.format("execution time: %d", excuteRunningTime);
    System.out.println(result);
    onPostSort(result, inputData);
    return excuteRunningTime;
  }
}
