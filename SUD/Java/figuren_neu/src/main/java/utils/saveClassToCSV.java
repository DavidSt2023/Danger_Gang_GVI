package utils;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import de.figuren.figuren3D.Figur3D;


public class saveClassToCSV {
    public static void writeAll(List<? extends Figur3D> figs, Path p) {
        try (BufferedWriter bw = Files.newBufferedWriter(p, StandardOpenOption.CREATE)) {
            for (Figur3D f : figs) {
                bw.write(f.toString());
                bw.write("\n"); //Zeilenumbruch nach jeder Figur
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}