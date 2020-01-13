package me.lirui.algo.sort;

/** Created by RichardLee on 2017/4/2. */
public abstract class BaseSort {

  public abstract int[] onPrepareInputData();

  public abstract void onDoSort(int[] inputData);

  public abstract void onPostSort(String outPut, int[] resultData);

  public void doSort() {
    int[] inputData = onPrepareInputData();

    long startTime = System.nanoTime();
    onDoSort(inputData);
    long endTime = System.nanoTime();

    long timeElapsedInNanoSecs = endTime - startTime;
    String result = String.format("execution time: %d", timeElapsedInNanoSecs);

    System.out.print("============== >");
    System.out.print(getClass().getName());
    System.out.print("< ============== ");
    System.out.println(result + "\n");

    onPostSort(result, inputData);
  }
}
