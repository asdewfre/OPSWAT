package org.example.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {
    public List<String> getLines(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {

            System.err.println("Hiba a fájl olvasása közben: " + e.getMessage());
            return List.of();
        }
    }
}

