package application;

import java.util.Comparator;

public class InsertionSortV1<T> implements ArraySorter<T> {

  private final Comparator<T> comp;

  public InsertionSortV1(Comparator<T> comp) {
    this.comp = comp;
  }

  @Override
  public void sort(T[] arrayToBeSorted) {
    final T formerFirst = arrayToBeSorted[0];
    for (int currentItemToBePlacedIdx = 2;
         currentItemToBePlacedIdx < arrayToBeSorted.length;
         currentItemToBePlacedIdx++
    ) {
      if (Thread.interrupted()) {
        return;
      }
      final T currentItemToBePlaced = arrayToBeSorted[currentItemToBePlacedIdx];
      arrayToBeSorted[0] = currentItemToBePlaced; // (Ende-)Marke setzen
      int wrkIdx = currentItemToBePlacedIdx - 1;
      while (0 > comp.compare(currentItemToBePlaced, arrayToBeSorted[wrkIdx])) {
        arrayToBeSorted[wrkIdx + 1] = arrayToBeSorted[wrkIdx];
        wrkIdx--;
      }//while
      arrayToBeSorted[wrkIdx + 1] = currentItemToBePlaced;
    }//for
    if (0 < comp.compare(formerFirst, arrayToBeSorted[arrayToBeSorted.length - 1])) {
      for (int idx = 1; idx < arrayToBeSorted.length; idx++) {
        arrayToBeSorted[idx - 1] = arrayToBeSorted[idx];
      }//for
      arrayToBeSorted[arrayToBeSorted.length - 1] = formerFirst;
    } else {
      int wrkIdx = 1;
      while (0 < comp.compare(formerFirst, arrayToBeSorted[wrkIdx])) {
        arrayToBeSorted[wrkIdx - 1] = arrayToBeSorted[wrkIdx];
        wrkIdx++;
      }//while
      arrayToBeSorted[wrkIdx - 1] = formerFirst;
    }//if
  }//method()
}
