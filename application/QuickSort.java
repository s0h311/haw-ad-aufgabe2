package application;

import java.util.Comparator;

public class QuickSort<T> implements ArraySorter<T> {

  private final Comparator<T> comp;

  private final int left = 0;
  private final int right = 1;

  public QuickSort(Comparator<T> comp) {
    this.comp = comp;
  }

  @Override
  public void sort(T[] arrayToBeSorted) {
    quickSort(arrayToBeSorted, 0, arrayToBeSorted.length - 1);
  }//method()

  private void quickSort(
      final T[] arrayToBeSorted,
      final int lb, // lb ::= left border
      final int rb // rb ::= right border
  ) {
    if (lb < rb) {
      final int[] mb = partition(arrayToBeSorted, lb, rb); // mb ::= middle border
      quickSort(arrayToBeSorted, lb, mb[left]);
      quickSort(arrayToBeSorted, mb[right], rb);
    }//if
  }//method()

  private int[] partition(T[] arrayToBeSorted, final int lb, final int rb) {
    final int pivotPosition = (lb + rb) / 2; // Pivotelement aus der Mitte
    final T pivot = arrayToBeSorted[pivotPosition];
    int li = lb; // li ::= left index
    int ri = rb; // ri ::= right index
    boolean proceed;
    do {
      while (0 < comp.compare(pivot, arrayToBeSorted[li])) li++;
      while (0 > comp.compare(pivot, arrayToBeSorted[ri])) ri--;
      proceed = (li < ri);
      if (proceed) {
        final T tmp = arrayToBeSorted[li];
        arrayToBeSorted[li++] = arrayToBeSorted[ri];
        arrayToBeSorted[ri--] = tmp;
      }//if
    } while (proceed);
    return new int[]{li - 1, ri + 1};
  }//method()

}
