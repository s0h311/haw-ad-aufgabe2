package application;

import java.util.Comparator;

public class InsertionSortClassic<T> implements ArraySorter<T> {
  private Comparator<T> comp;

  public InsertionSortClassic(final Comparator<T> comp) {
    this.comp = comp;
  }

  @Override
  public void sort(final T[] ai) {
    for (int currentItemToBePlacedIdx = 1;
         currentItemToBePlacedIdx < ai.length;
         currentItemToBePlacedIdx++
    ) {
      final T currentItemToBePlaced = ai[currentItemToBePlacedIdx];
      int wrkIdx = currentItemToBePlacedIdx - 1;
      while ((0 <= wrkIdx)
          && (0 > comp.compare(currentItemToBePlaced, ai[wrkIdx]))
      ) {
        ai[wrkIdx + 1] = ai[wrkIdx];
        wrkIdx--;
      }//while
      ai[wrkIdx + 1] = currentItemToBePlaced;
    }//for
  }//method()
}
