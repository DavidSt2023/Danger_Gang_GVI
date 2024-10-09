import java.util.Random;

/**
 * This class provides a method to perform selection sort on an array.
 *
 * @author Lukas Leufen
 */
public class selectionsort {

  public static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      int min = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[min]) {
          min = j;
        }
      }
      if (min != i) {
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[10];
    Random rand = new Random();

    System.out.println("Original Array:");
    for (int i = 0; i < arr.length; i++) {
      arr[i] = rand.nextInt(100);
      System.out.print(arr[i] + " ");
    }

    long startTime = System.nanoTime();
    selectionSort(arr);
    long endTime = System.nanoTime();
    double durationInMillis = (double) (endTime - startTime) / 1_000_000;

    System.out.println("\nSorted Array:");
    for (int j : arr) {
      System.out.print(j + " ");
    }

    System.out.println("\nTime taken: " + durationInMillis + " milliseconds");
  }
}
