package application;

import java.util.Comparator;

public class ShakeSort<T> implements ArraySorter<T> {

  private Comparator<T> comp;

  public ShakeSort(Comparator<T> comp) {
    this.comp = comp;
  }

  @Override
  public void sort(T[] arrayToBeSorted) {
    int lastIdx;
    int lbi = 0;
    int rbi = arrayToBeSorted.length - 1;
    while (lbi < rbi) {
      lastIdx = lbi;
      for (int idx = lbi + 1; idx <= rbi; idx++) {
        if (comp.compare(arrayToBeSorted[idx - 1], arrayToBeSorted[idx]) > 0) {
          final T tmp = arrayToBeSorted[idx - 1];
          arrayToBeSorted[idx - 1] = arrayToBeSorted[idx];
          arrayToBeSorted[idx] = tmp;
          lastIdx = idx;
        }//if
      }//for
      rbi = lastIdx - 1;
      lastIdx = rbi;
      for (int idx = rbi - 1; idx >= lbi; idx--) {
        if (comp.compare(arrayToBeSorted[idx + 1], arrayToBeSorted[idx]) < 0) {
          final T tmp = arrayToBeSorted[idx + 1];
          arrayToBeSorted[idx + 1] = arrayToBeSorted[idx];
          arrayToBeSorted[idx] = tmp;
          lastIdx = idx;
        }//if
      }//for
      lbi = lastIdx + 1;
    }//while
  }
}
