package de.lks1802;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class InvalidInputTest {

  @Test
  public void testInvalidCategoryShouldRepeatInput() throws Exception {
    String input = "500\nx\nw\ng\n";
    String expectedOutput = "Bestellmenge: Kategorie (w,m,h): Fehlerhafte Eingabe. Nochmal.\n"
        + "Kategorie (w,m,h): Griffbezeichnung (g,n,k): Rabatt von 5% wegen Bestellmenge >= 500\n"
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
  public void testInvalidGripShouldRepeatInput() throws Exception {
    String input = "500\nw\nx\ng\n";
    String expectedOutput = "Bestellmenge: Kategorie (w,m,h): Griffbezeichnung (g,n,k): Fehlerhafte Eingabe. Nochmal.\n"
        + "Griffbezeichnung (g,n,k): Rabatt von 5% wegen Bestellmenge >= 500\n"
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
  public void testInvalidAmountInput() throws Exception {
    String input = "-10\n499\nw\ng\n";
    String expectedOutput = "Bestellmenge: Fehlerhafte Eingabe. Nochmal.\n"
        + "Kategorie (w,m,h): Griffbezeichnung (g,n,k): Rabatt von 1% wegen w und n oder g\n"
        + "Endpreis: 1175.625\n";

    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    Main.main(new String[]{});

    assertEquals(expectedOutput, out.toString().replace("\r", ""));
  }

}
