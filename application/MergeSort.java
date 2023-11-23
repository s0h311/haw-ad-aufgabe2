package application;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort<T> implements ArraySorter<T> {

  private final Comparator<T> comp;

  private T[] array;
  private T[] copya;

  public MergeSort(Comparator<T> comp) {
    this.comp = comp;
  }

  @Override
  public void sort(T[] arrayToBeSorted) {
    this.array = arrayToBeSorted;
    copya = Arrays.copyOf(arrayToBeSorted, arrayToBeSorted.length);
    mergeSort(0, arrayToBeSorted.length - 1);
  }//method()

  private void mergeSort(
      final int lb, // lb ::= left border
      final int rb // rb ::= right border
  ) {
    if (lb < rb) {
      final int m = (lb + rb) / 2;
      mergeSort(lb, m);
      mergeSort(m + 1, rb);
      merge(lb, m + 1, rb);
    }//if
  }

  private void merge(
      final int lslib, // lslib ::= left side left including border
      final int rslib, // rslib ::= right side left including border
      final int rsrib // rsrib ::= right side right including border
  ) {
    int lsi = lslib; // lsi ::= left side index
    int rsi = rslib; // rsi ::= right side index
    int ci = lslib; // ci ::= current/work index
    while ((lsi < rslib) && (rsi <= rsrib)) {
      final int c = comp.compare(array[lsi], array[rsi]);
      if (c < 0) {
        copya[ci++] = array[lsi++];
      } else if (c > 0) {
        copya[ci++] = array[rsi++];
      } else {
        copya[ci++] = array[lsi++];
        copya[ci++] = array[rsi++];
      }//if
    }//while
    if (rsi > rsrib) {
      while (lsi < rslib) copya[ci++] = array[lsi++];
    } else {
      while (rsi <= rsrib) copya[ci++] = array[rsi++];
    }//if
    for (int i = lslib; i <= rsrib; i++) array[i] = copya[i];
  }//method()
}
