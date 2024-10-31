package de.lks1802;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuantityEquals500Test {

  @Test
  public void testForAndCategoryWAndGripG() throws Exception {
    String input = "500\nw\ng\n";
    String expectedOutput = "Bestellmenge: Kategorie (w,m,h): Griffbezeichnung (g,n,k): Rabatt von 5% wegen Bestellmenge >= 500\n"
        + "Rabatt von 1% wegen w und n oder g\n"
        + "Endpreis: 1175.625\n";

    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    Main.main(new String[]{});

    assertEquals(expectedOutput, out.toString().replace("\r", ""));
  }

  @Test
  public void testForAndCategoryWAndGripN() throws Exception {
    String input = "500\nw\nn\n";
    String expectedOutput = "Bestellmenge: Kategorie (w,m,h): Griffbezeichnung (g,n,k): Rabatt von 5% wegen Bestellmenge >= 500\n"
        + "Rabatt von 1% wegen w und n oder g\n"
        + "Endpreis: 1175.625\n";

    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    Main.main(new String[]{});

    assertEquals(expectedOutput, out.toString().replace("\r", ""));
  }

  @Test
  public void testForAndCategoryWAndGripK() throws Exception {
    String input = "500\nw\nk\n";
    String expectedOutput = "Bestellmenge: Kategorie (w,m,h): Griffbezeichnung (g,n,k): Rabatt von 5% wegen Bestellmenge >= 500\n"
        + "Rabatt von 5% wegen w und k\n"
        + "Endpreis: 1128.125\n";

    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    Main.main(new String[]{});

    assertEquals(expectedOutput, out.toString().replace("\r", ""));
  }

  @Test
  public void testForAndCategoryMAndGripG() throws Exception {
    String input = "500\nm\ng\n";
    String expectedOutput = "Bestellmenge: Kategorie (w,m,h): Griffbezeichnung (g,n,k): Rabatt von 5% wegen Bestellmenge >= 500\n"
        + "Endpreis: 1187.5\n";

    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    Main.main(new String[]{});

    assertEquals(expectedOutput, out.toString().replace("\r", ""));
  }

  @Test
  public void testForAndCategoryMAndGripN() throws Exception {
    String input = "500\nm\nn\n";
    String expectedOutput = "Bestellmenge: Kategorie (w,m,h): Griffbezeichnung (g,n,k): Rabatt von 5% wegen Bestellmenge >= 500\n"
        + "Endpreis: 1187.5\n";

    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    Main.main(new String[]{});

    assertEquals(expectedOutput, out.toString().replace("\r", ""));
  }

  @Test
  public void testForAndCategoryMAndGripK() throws Exception {
    String input = "500\nm\nk\n";
    String expectedOutput = "Bestellmenge: Kategorie (w,m,h): Griffbezeichnung (g,n,k): Rabatt von 5% wegen Bestellmenge >= 500\n"
        + "Rabatt von 2% wegen m oder h und k\n"
        + "Endpreis: 1163.75\n";

    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    Main.main(new String[]{});

    assertEquals(expectedOutput, out.toString().replace("\r", ""));
  }

  @Test
  public void testForAndCategoryHAndGripG() throws Exception {
    String input = "500\nh\ng\n";
    String expectedOutput = "Bestellmenge: Kategorie (w,m,h): Griffbezeichnung (g,n,k): Rabatt von 5% wegen Bestellmenge >= 500\n"
        + "Aufschlag von 5% wegen h und g\n"
        + "Endpreis: 1246.875\n";

    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    Main.main(new String[]{});

    assertEquals(expectedOutput, out.toString().replace("\r", ""));
  }

  @Test
  public void testForAndCategoryHAndGripN() throws Exception {
    String input = "500\nh\nn\n";
    String expectedOutput = "Bestellmenge: Kategorie (w,m,h): Griffbezeichnung (g,n,k): Rabatt von 5% wegen Bestellmenge >= 500\n"
        + "Aufschlag von 2,5% wegen h und n\n"
        + "Endpreis: 1217.1875\n";

    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    Main.main(new String[]{});

    assertEquals(expectedOutput, out.toString().replace("\r", ""));
  }

  @Test
  public void testForAndCategoryHAndGripK() throws Exception {
    String input = "500\nh\nk\n";
    String expectedOutput = "Bestellmenge: Kategorie (w,m,h): Griffbezeichnung (g,n,k): Rabatt von 5% wegen Bestellmenge >= 500\n"
        + "Rabatt von 2% wegen m oder h und k\n"
        + "Endpreis: 1163.75\n";

    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    Main.main(new String[]{});

    assertEquals(expectedOutput, out.toString().replace("\r", ""));
  }
}