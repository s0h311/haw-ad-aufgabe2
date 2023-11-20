package application;

import java.util.Comparator;

public class ExchangeBasedSortV2<T> implements ArraySorter<T> {

  private Comparator<T> comp;

  public ExchangeBasedSortV2(Comparator<T> comp) {
    this.comp = comp;
  }

  @Override
  public void sort(T[] arrayToBeSorted) {
    int currentEndIdx = 1;
    while (currentEndIdx < arrayToBeSorted.length) {
      int lastIdx = arrayToBeSorted.length;
      for (int idx = arrayToBeSorted.length; --idx >= currentEndIdx; ) {
        if (0 < comp.compare(arrayToBeSorted[idx - 1], arrayToBeSorted[idx])) {
          final T tmp = arrayToBeSorted[idx - 1];
          arrayToBeSorted[idx - 1] = arrayToBeSorted[idx];
          arrayToBeSorted[idx] = tmp;
          lastIdx = idx;
        }//if
      }//for
      currentEndIdx = lastIdx + 1;
    }//while
  }
}
