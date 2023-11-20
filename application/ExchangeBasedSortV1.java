package application;

import java.util.Comparator;

public class ExchangeBasedSortV1<T> implements ArraySorter<T> {

  private Comparator<T> comp;

  public ExchangeBasedSortV1(Comparator<T> comp) {
    this.comp = comp;
  }

  @Override
  public void sort(T[] arrayToBeSorted) {
    boolean exchangesHappened = true;
    int currentEndIdx = 1;
    while ((currentEndIdx < arrayToBeSorted.length) && exchangesHappened) {
      exchangesHappened = false;
      for (int idx = arrayToBeSorted.length; --idx >= currentEndIdx; ) {
        if (0 < comp.compare(arrayToBeSorted[idx - 1], arrayToBeSorted[idx])) {
          final T tmp = arrayToBeSorted[idx - 1];
          arrayToBeSorted[idx - 1] = arrayToBeSorted[idx];
          arrayToBeSorted[idx] = tmp;
          exchangesHappened = true;
        }//if
      }//for
      currentEndIdx++;
    }//while
  }
}

