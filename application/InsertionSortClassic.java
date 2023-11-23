package application;

import java.util.Comparator;

public class InsertionSortClassic<T> implements ArraySorter<T> {
  private final Comparator<T> comp;

  public InsertionSortClassic(final Comparator<T> comp) {
    this.comp = comp;
  }

  @Override
  public void sort(T[] arrayToBeSorted) {
    for (int currentItemToBePlacedIdx = 1;
         currentItemToBePlacedIdx < arrayToBeSorted.length;
         currentItemToBePlacedIdx++
    ) {
      T currentItemToBePlaced = arrayToBeSorted[currentItemToBePlacedIdx];
      int wrkIdx = currentItemToBePlacedIdx - 1;
      while (wrkIdx >= 0
          && (comp.compare(currentItemToBePlaced, arrayToBeSorted[wrkIdx]) < 0)
      ) {
        arrayToBeSorted[wrkIdx + 1] = arrayToBeSorted[wrkIdx];
        wrkIdx--;
      }//while
      arrayToBeSorted[wrkIdx + 1] = currentItemToBePlaced;
    }//for
  }//method()
}
