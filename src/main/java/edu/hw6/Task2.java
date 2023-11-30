package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task2 {
    private Task2() {}

    public static void cloneFile(Path path) throws IOException {
        int idxOfPoint = path.getFileName().toString().indexOf('.');
        String fileName = path.getFileName().toString().substring(0, idxOfPoint);
        String extension = path.getFileName().toString().substring(idxOfPoint);

        if (path.toFile().exists()) {
            Path clonePath = path.resolveSibling(fileName + " - копия" + extension);

            if (clonePath.toFile().exists()) {
                int i = 2;

                while (clonePath.toFile().exists()) {
                    clonePath = path.resolveSibling(fileName + " - копия (" + i + ")" + extension);
                    ++i;
                }
            }

            Files.createFile(clonePath);
        } else {
            Files.createFile(path);
        }
    }
}
