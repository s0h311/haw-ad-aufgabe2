package test;


import application.ArraySorter;
import application.InsertionSortClassic;
import utilityStuff.*;


public class MicroBenchmarkStarter {


  @SuppressWarnings("unchecked")
  private static final ArraySorter<Item>[] sorter =
      (ArraySorter<Item>[]) (new ArraySorter[]{
          new InsertionSortClassic(new ItemComparatorAscendingNaturalOrder()),
          new InsertionSortClassic(new ItemComparatorDescendingNaturalOrder())
          //new QuickSortRG<Item>( new ItemComparatorAscendingNaturalOrder() ),
          //new QuickSortRG2<Item>( new ItemComparatorAscendingNaturalOrder() ),
      }
      );


  public static void main(final String... unused) {
    final OptimizationBlocker ob = new OptimizationBlocker();

    //configure test parameters
    final int runCnt = 10;
    final int[] numberOfItemsToBeSorted = {10, 100, 1_000, 10_000, 100_000}; //TODO 1_000_000

    System.out.printf("Start measurement at : %s\n", Beautician.getPimpedTime());
    System.out.printf("\n");
    // actual measurement
    for (final ArraySorter<Item> currentSorter : sorter) {
      for (final int amountOfItems : numberOfItemsToBeSorted) {
        final int excludingMaximum = amountOfItems * 999 / 1000;
        final UnsortedItemArrayGenerator uiag = new UnsortedItemArrayGenerator(amountOfItems, excludingMaximum);
        long duration = 0;
        for (int rc = runCnt; --rc >= 0; ) {
          final Item[] arrayToBeSorted = uiag.createUnsortedItemArray();
          final long startTime = System.nanoTime();
          //
          currentSorter.sort(arrayToBeSorted);
          //
          final long endTime = System.nanoTime();
          duration += (endTime - startTime);
          ob.bo(arrayToBeSorted);
        }//for
        System.out.printf(
            "%s   %12d ~ %-12d : %40s\n",
            currentSorter.getClass().getSimpleName(),
            amountOfItems,
            excludingMaximum,
            Beautician.nanoSecondBasedTimeToString(duration / runCnt)
        );
      }//for
      System.out.printf("\n");
    }//for

    System.out.printf(">>>>>>>>>>>>>>>>>>>>----\n");
    System.out.printf("don't care about :  %x", ob.getSignature());
  }//method()

}//class
