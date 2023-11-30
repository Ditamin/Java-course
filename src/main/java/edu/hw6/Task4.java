package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Path;

public class Task4 {
    private Task4() {}

    private static final String INITIAL_STRING = "Programming is learned by writing programs. ― Brian Kernighan";

    public static PrintWriter outputStreamComposition(Path path) throws FileNotFoundException {
        try (PrintWriter outputStream =
            new PrintWriter(
                new OutputStreamWriter(
                    new BufferedOutputStream(
                        new FileOutputStream(path.toFile())
                    )
                )
            )
        ) {
            outputStream.println(INITIAL_STRING);
            return outputStream;
        }
    }
}
