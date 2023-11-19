package edu.hw6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    void cloneFile() throws IOException {
        Path path = Path.of("./test.txt");
        Path pathClone1 = Path.of("./test - копия.txt");
        Path pathClone2 = Path.of("./test - копия (2).txt");
        Path pathClone3 = Path.of("./test - копия (3).txt");
        Path pathCloneClone = Path.of("./test - копия - копия.txt");

        Task2.cloneFile(path);
        Assertions.assertThat(path.toFile().exists()).isEqualTo(true);
        Task2.cloneFile(path);
        Assertions.assertThat(pathClone1.toFile().exists()).isEqualTo(true);
        Task2.cloneFile(path);
        Assertions.assertThat(pathClone2.toFile().exists()).isEqualTo(true);
        Task2.cloneFile(path);
        Assertions.assertThat(pathClone3.toFile().exists()).isEqualTo(true);
        Task2.cloneFile(pathClone1);
        Assertions.assertThat(pathCloneClone.toFile().exists()).isEqualTo(true);

        Files.delete(path);
        Files.delete(pathClone1);
        Files.delete(pathClone2);
        Files.delete(pathClone3);
        Files.delete(pathCloneClone);
    }
}
