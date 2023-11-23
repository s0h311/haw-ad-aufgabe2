package application;

import java.util.Comparator;

public class ShellSort<T> implements ArraySorter<T> {
  private final Comparator<T> comp;

  public ShellSort(Comparator<T> comp) {
    this.comp = comp;
  }

  final int[] stepSize = {
      1, 4, 13, 41, 111,
      271, 815, 1968, 4711, 11969,
      27901, 84801, 213331, 543749, 1355339,
      3501671, 8810089, 21521774, 58548857, 157840433,
      410151271, 1131376761, 2147483647
  };

  @Override
  public void sort(T[] arrayToBeSorted) {
    for (int stepSizeIdx = stepSize.length - 1; stepSizeIdx >= 0; stepSizeIdx--) {
      if (Thread.interrupted()) {
        return;
      }
      final int inc = stepSize[stepSizeIdx];
      for (int idx = inc; idx < arrayToBeSorted.length; idx++) {
        final T currentItemToBePlaced = arrayToBeSorted[idx];
        int currentItemToBePlacedIdx = idx;
        while (currentItemToBePlacedIdx - inc >= 0
            && 0 > comp.compare(currentItemToBePlaced,
            arrayToBeSorted[currentItemToBePlacedIdx - inc])
        ) {
          arrayToBeSorted[currentItemToBePlacedIdx] = arrayToBeSorted[currentItemToBePlacedIdx - inc];
          currentItemToBePlacedIdx -= inc;
        }//while
        arrayToBeSorted[currentItemToBePlacedIdx] = currentItemToBePlaced;
      }//for
    }//for
  }
}
