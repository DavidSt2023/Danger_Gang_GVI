package materialpreise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class MaterialChooser {

  private final Map<String, Double> fuellungMaterials;
  private final Map<String, Double> oberflaechenMaterials;

  public MaterialChooser(String fuellungFile, String oberflaechenFile) throws IOException {
    this.fuellungMaterials = readCSV(fuellungFile);
    this.oberflaechenMaterials = readCSV(oberflaechenFile);
  }

  private Map<String, Double> readCSV(String filePath) throws IOException {
    Map<String, Double> materials = new HashMap<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] parts = line.split(";");
        if (parts.length == 2) {
          String material = parts[0].trim();
          try {
            double price = Double.parseDouble(parts[1].trim().replace(",", "."));
            materials.put(material, price);
          } catch (NumberFormatException e) {
            System.out.println("Invalid price format: " + parts[1] + ". Ensure that the price is a double value with a comma as decimal separator.");
          }
        }
      }
    }
    return materials;
  }

  public void displayMenu() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Choose a material type:");
    System.out.println("1. Fuellung");
    System.out.println("2. Oberflaechen");
    int choice = scanner.nextInt();

    Map<String, Double> chosenMaterials;
    switch (choice) {
      case 1:
        chosenMaterials = fuellungMaterials;
        break;
      case 2:
        chosenMaterials = oberflaechenMaterials;
        break;
      default:
        System.out.println("Invalid choice.");
        return;
    }

    displayMaterials(chosenMaterials);
  }

  private void displayMaterials(Map<String, Double> materials) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Available materials:");
    int index = 1;
    for (String material : materials.keySet()) {
      System.out.println(index + ". " + material + " - " + materials.get(material));
      index++;
    }
    System.out.println("Choose a material:");
    int materialChoice = scanner.nextInt();
    if (materialChoice > 0 && materialChoice <= materials.size()) {
      String chosenMaterial = (String) materials.keySet().toArray()[materialChoice - 1];
      System.out.println("You chose: " + chosenMaterial);
      calculatePrice(chosenMaterial, materials.get(chosenMaterial));
    } else {
      System.out.println("Invalid choice.");
    }
  }

  private void calculatePrice(String material, double price) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the size of the material (e.g., volume for Fuellung or area for Oberflaeche) as a double:");
    try {
      double size = scanner.nextDouble();
      double totalPrice = price * size;
      System.out.println("The total price for " + size + " units of " + material + " is: " + totalPrice);
    } catch (InputMismatchException e) {
      System.out.println("Invalid size format. Please enter a double value with a comma as decimal separator.");
    }
  }

  public static void main(String[] args) {
    try {
      MaterialChooser chooser = new MaterialChooser("Materialpreise Fuellung.csv", "Materialpreise Oberflaechen.csv");
      chooser.displayMenu();
    } catch (IOException e) {
      System.out.println("Error reading CSV files: " + e.getMessage());
    }
  }
}