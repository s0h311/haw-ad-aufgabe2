package application;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySort<T> implements ArraySorter<T> {

  private final Comparator<T> comp;

  public ArraySort(Comparator<T> comp) {
    this.comp = comp;
  }

  @Override
  public void sort(T[] arrayToBeSorted) {
    Arrays.sort(arrayToBeSorted, comp);
  }
}
