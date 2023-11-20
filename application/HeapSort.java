package application;

import java.util.Comparator;

public class HeapSort<T> implements ArraySorter<T> {

  private final Comparator<T> comp;

  public HeapSort(Comparator<T> comp) {
    this.comp = comp;
  }

  @Override
  public void sort(T[] arrayToBeSorted) {
    // (Start-)Heap (ab Position) sicherstellen
    final int lastIdxWithLeaves = (arrayToBeSorted.length - 2) / 2;
    // array.length/2 reicht als Konsequenz von Heap und sift()
    for (int i = lastIdxWithLeaves; i >= 0; i--) {
      sift(arrayToBeSorted, i, arrayToBeSorted.length);
    }//for
    // Größten entfernen und wieder Heap sicherstellen
    for (int i = arrayToBeSorted.length - 1; i > 0; i--) {
      final T max = arrayToBeSorted[0];
      arrayToBeSorted[0] = arrayToBeSorted[i];
      arrayToBeSorted[i] = max;

      sift(arrayToBeSorted, 0, i);
    }//for
  }

  private void sift(
      final T[] array,
      int pi, // "parent" index
      final int reb // right excluding border
  ) {
    int ci; // current index or left child index
    int rci = (pi + 1) * 2; // right child index
    siftLoop:
    while (reb >= rci) {
      ci = rci - 1;
      if (reb > rci) {
        if (0 > comp.compare(array[ci], array[rci])) {
          // ci ::= correct index of max( a[lci], a[rci] )
          ci = rci;
        }//if
      }//if
      if (0 > comp.compare(array[pi], array[ci])) {
        final T tmp = array[pi];
        array[pi] = array[ci];
        array[ci] = tmp;
        pi = ci; // pi für nächsten Durchlauf setzen
        rci = (ci + 1) * 2; // rci für nächsten Durchlauf setzen
      } else {
        break siftLoop;
      }//if
    }//while
  }//method()
}
