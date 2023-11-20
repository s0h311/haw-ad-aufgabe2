package application;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayParallelSort<T> implements ArraySorter<T> {

  private final Comparator<T> comp;

  public ArrayParallelSort(Comparator<T> comp) {
    this.comp = comp;
  }

  @Override
  public void sort(T[] arrayToBeSorted) {
    Arrays.parallelSort(arrayToBeSorted, comp);
  }
}
