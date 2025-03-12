package utils;

import de.figuren.figuren3D.*;
import de.figuren.figuren2D.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class readClassFromCSV {

    public static List<Figur3D> readAll(Path p) {
        List<Figur3D> figuren = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(p)) {
            String line;
            while ((line = br.readLine()) != null) {
                figuren.add(parseFigur3D(line));
            }
            System.out.println(figuren.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return figuren;
    }

    private static Figur3D parseFigur3D(String line) {
        JSONObject jsonObject = new JSONObject(line);
        String type = jsonObject.keys().next(); // Get the first key which is the type

        switch (type) {
            case "Kugel":
                return Kugel.fromString(jsonObject.getJSONObject(type).toString());
            case "Zylinder":
                return Zylinder.fromString(jsonObject.getJSONObject(type).toString());
            case "Dreiecksprisma":
                return Dreiecksprisma.fromString(jsonObject.getJSONObject(type).toString());
            case "Prisma":
                return Prisma.fromString(jsonObject.getJSONObject(type).toString());
            case "RegelmaessigePyramide":
                return RegelmaessigePyramide.fromString(jsonObject.getJSONObject(type).toString());
            case "Tetraeder":
                return Tetraeder.fromString(jsonObject.getJSONObject(type).toString());
            default:
                throw new IllegalArgumentException("Unknown Figur3D type: " + type);
        }

    }
}