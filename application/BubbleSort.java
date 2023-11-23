package application;

import java.util.Comparator;

public class BubbleSort<T> implements ArraySorter<T> {

  private final Comparator<T> comp;

  public BubbleSort(Comparator<T> comp) {
    this.comp = comp;
  }

  @Override
  public void sort(T[] arrayToBeSorted) {
    for (int currentEndIdx = arrayToBeSorted.length; --currentEndIdx > 0; ) {
      // Nach jeder Iteration ist das Listenende sortiert.
      // currentEndIdx damit wir nicht unnötig das sortierte Ende noch durchgehen
      for (int idx = 1; idx <= currentEndIdx; idx++) {
        if (comp.compare(arrayToBeSorted[idx - 1], arrayToBeSorted[idx]) > 0) { // Wenn das voherige Element größer ist als das jetzige, dann Swap
          final T tmp = arrayToBeSorted[idx - 1];
          arrayToBeSorted[idx - 1] = arrayToBeSorted[idx];
          arrayToBeSorted[idx] = tmp;
        }//if
      }//for
    }//for
  }
}
