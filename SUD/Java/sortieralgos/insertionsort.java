import java.util.Random;

/**
 * This class provides a method to perform insertion sort on an array.
 *
 * @author Lukas Leufen
 */
public class insertionsort {

  public static void insertionSort(int[] arr) {
    int j;
    for (int i = 1; i < arr.length; i++) {
      j = i;
      while (j > 0 && arr[j - 1] > arr[j]) {
        int temp = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = temp;
        j--;
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
    insertionSort(arr);
    long endTime = System.nanoTime();
    double durationInMillis = (double) (endTime - startTime) / 1_000_000;

    System.out.println("\nSorted Array:");
    for (int j : arr) {
      System.out.print(j + " ");
    }

    System.out.println("\nTime taken: " + durationInMillis + " milliseconds");
  }
}
