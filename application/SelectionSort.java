package application;

import java.util.Comparator;

public class SelectionSort<T> implements ArraySorter<T> {

  private Comparator<T> comp;

  public SelectionSort(Comparator<T> comp) {
    this.comp = comp;
  }

  @Override
  public void sort(T[] arrayToBeSorted) {
    for (int targetIdxOfSelectected = 0;
         targetIdxOfSelectected < arrayToBeSorted.length;
         targetIdxOfSelectected++
    ) {
      int candidateIdx = targetIdxOfSelectected;
      for (int searchIdx = targetIdxOfSelectected + 1;
           searchIdx < arrayToBeSorted.length;
           searchIdx++
      ) {
        if (0 > comp.compare(arrayToBeSorted[searchIdx], arrayToBeSorted[candidateIdx])) {
          candidateIdx = searchIdx;
        }//if
      }//for
      final T selectedCandidate = arrayToBeSorted[candidateIdx];
      arrayToBeSorted[candidateIdx] = arrayToBeSorted[targetIdxOfSelectected];
      arrayToBeSorted[targetIdxOfSelectected] = selectedCandidate;
    }//for

  }
}
