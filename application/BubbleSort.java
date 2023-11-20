package application;

import java.util.Comparator;

public class BubbleSort<T> implements ArraySorter<T> {

  private Comparator<T> comp;

  public BubbleSort(Comparator<T> comp) {
    this.comp = comp;
  }

  @Override
  public void sort(T[] arrayToBeSorted) {
    for (int currentEndIdx = arrayToBeSorted.length; --currentEndIdx > 0; ) {
      for (int idx = 1; idx <= currentEndIdx; idx++) {
        if (0 < comp.compare(arrayToBeSorted[idx - 1], arrayToBeSorted[idx])) {
          final T tmp = arrayToBeSorted[idx - 1];
          arrayToBeSorted[idx - 1] = arrayToBeSorted[idx];
          arrayToBeSorted[idx] = tmp;
        }//if
      }//for
    }//for
  }
}
