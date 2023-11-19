package application;

import java.util.Comparator;

public class InsertionSortBinary<T> implements ArraySorter<T> {

  private Comparator<T> comp;

  public InsertionSortBinary(Comparator<T> comp) {
    this.comp = comp;
  }

  @Override
  public void sort(T[] arrayToBeSorted) {
    for (int currentItemToBePlacedIdx = 1;
         currentItemToBePlacedIdx < arrayToBeSorted.length;
         currentItemToBePlacedIdx++
    ) {
      final T currentItemToBePlaced = arrayToBeSorted[currentItemToBePlacedIdx];
      int lb = 0;
      int rb = currentItemToBePlacedIdx;
      while (lb < rb) {
        final int m = (lb + rb) / 2;
        if (0 > comp.compare(currentItemToBePlaced, arrayToBeSorted[m])) {
          rb = m;
        } else {
          lb = m + 1;
        }//if
      }//while
      for (int idx = currentItemToBePlacedIdx; --idx >= rb; ) {
        arrayToBeSorted[idx + 1] = arrayToBeSorted[idx];
      }//for
      arrayToBeSorted[rb] = currentItemToBePlaced;
    }//for
  }
}
