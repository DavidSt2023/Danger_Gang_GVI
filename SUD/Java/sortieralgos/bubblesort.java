import java.util.Random;

/**
 * This class provides a method to perform bubble sort on an array.
 *
 * @author Lukas Leufen
 */
public class bubblesort {

  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      boolean swapped = false;
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swapped = true;
        }
      }
      if (!swapped) {
        break;
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
    bubbleSort(arr);
    long endTime = System.nanoTime();
    double durationInMillis = (double) (endTime - startTime) / 1_000_000;

    System.out.println("\nSorted Array:");
    for (int j : arr) {
      System.out.print(j + " ");
    }

    System.out.println("\nTime taken: " + durationInMillis + " milliseconds");
  }
}
