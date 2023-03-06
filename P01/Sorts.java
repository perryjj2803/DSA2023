/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts
{
  public static void bubbleSort(int[] A)
    {
      boolean sorted = false;
      int temp;
      int pass=0;
      do
      {
        sorted = true;
        for (int ii = 0; ii < (A.length-1 -pass); ii++)
        {
          if (A[ii] > A[ii+1])
          {
            temp = A[ii];
            A[ii] = A[ii+1];
            A[ii+1] = temp;
            sorted = false;
          }
        }
        pass = pass+1; 
      } while (sorted != true);
    }//bubbleSort()

    // selection sort
    public static void selectionSort(int[] A)
    {
      int minIdx, nn, jj, temp;
      for (nn = 0; nn < A.length-1; nn++)
      {
        minIdx = nn;
        for (jj = nn+1; jj < A.length; jj++)
        {
          if (A[jj] < A[minIdx])
          {
            minIdx = jj;
          }
        }
        temp = A[minIdx];
        A[minIdx] = A[nn];
        A[nn] = temp;
      }
    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {
      int nn, ii, temp;
      for (nn = 1; nn < (A.length); nn++)
      {
        ii = nn;
        temp = A[ii];

        while ((ii > 0) && (A[ii-1] > temp));
        {
          A[ii] = A[ii-1];
          ii--;
        }
        A[ii] = temp;
      }
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
    }//mergeSort()
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
		return 0;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning


}//end Sorts calss
