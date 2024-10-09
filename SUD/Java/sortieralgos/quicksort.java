import java.util.Random;

/**
 * This class provides a method to perform quick sort on an array.
 *
 * @author Lukas Leufen
 */
public class quicksort {

  public static void main(String[] args) {
    int[] arr = new int[10];
    Random rand = new Random();

    System.out.println("Original Array:");
    for (int i = 0; i < arr.length; i++) {
      arr[i] = rand.nextInt(100);
      System.out.print(arr[i] + " ");
    }

    long startTime = System.nanoTime();
    quickSort(arr, 0, arr.length - 1);
    long endTime = System.nanoTime();
    double durationInMillis = (double) (endTime - startTime) / 1_000_000;

    System.out.println("\nSorted Array:");
    for (int j : arr) {
      System.out.print(j + " ");
    }

    System.out.println("\nTime taken: " + durationInMillis + " milliseconds");
  }

  public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int pi = partition(arr, low, high);

      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }
  }

  public static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);

    for (int j = low; j < high; j++) {
      if (arr[j] <= pivot) {
        i++;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
  }
}
