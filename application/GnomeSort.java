package application;

import java.util.Comparator;

public class GnomeSort<T> implements ArraySorter<T> {

  private final Comparator<T> comp;

  public GnomeSort(Comparator<T> comp) {
    this.comp = comp;
  }

  @Override
  public void sort(T[] arrayToBeSorted) {
    int index = 0;
    while (index < arrayToBeSorted.length) { // Ein Durchgang, allerdings vergleicht die gleichen Elemente mehrmals
      if (index == 0) index++;

      int comparisonResult = comp.compare(arrayToBeSorted[index], arrayToBeSorted[index - 1]);
      if (comparisonResult >= 0) index++;
      else {
        T temp = arrayToBeSorted[index];
        arrayToBeSorted[index] = arrayToBeSorted[index - 1];
        arrayToBeSorted[index - 1] = temp;
        index--;
      }
    }
  }
}
