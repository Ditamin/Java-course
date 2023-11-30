package edu.hw6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

class Task4Test {

    @Test
    void outputStreamComposition() throws IOException {
        Path path = Path.of("src/test/java/edu/hw6/filesForTests/test.txt");
        PrintWriter a = Task4.outputStreamComposition(path);
        a.close();
        String initialString = "Programming is learned by writing programs. ― Brian Kernighan";

        try (FileReader reader = new FileReader(path.toFile())) {
            Assertions.assertThat(path.toFile().exists()).isEqualTo(true);

            char[] buf = new char[61];
            reader.read(buf);

            Assertions.assertThat(buf).isEqualTo(initialString.toCharArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Files.delete(path);
    }
}
