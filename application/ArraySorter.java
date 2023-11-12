package application;

public interface ArraySorter<T> {
  /*
  * requested constructor()
  * =======================
  public ArraySorter( final Comparator<T> comp );
  */
  void sort( final T[] arrayToBeSorted );
}//interface
