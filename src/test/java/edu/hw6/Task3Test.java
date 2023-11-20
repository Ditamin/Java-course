package edu.hw6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import static edu.hw6.Task3.IS_EXECUTABLE;
import static edu.hw6.Task3.globMatches;
import static edu.hw6.Task3.hasExtension;
import static edu.hw6.Task3.largeThan;
import static edu.hw6.Task3.lessThan;
import static edu.hw6.Task3.magicNumber;
import static edu.hw6.Task3.IS_READABLE;
import static edu.hw6.Task3.regexContains;
import static edu.hw6.Task3.IS_REGULAR_FILE;
import static edu.hw6.Task3.IS_WRITABLE;

class Task3Test {
    @Test
    void sizeFilterTest() throws IOException {
        Path path = Path.of("src/test/java/edu/hw6/filesForTests");
        ArrayList<Path> ans = new ArrayList<>(List.of(Path.of("HelloWorld.java")));
        ArrayList<Path> res = new ArrayList<>();
        DirectoryStream.Filter<Path> filter = largeThan(100).and(lessThan(200));

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(path, filter)) {
            entries.forEach(entry -> res.add(entry.getFileName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertThat(res).isEqualTo(ans);
    }

    @Test
    void attributeFilterTest() throws IOException {
        Path path = Path.of("src/test/java/edu/hw6/filesForTests");
        ArrayList<Path> ans = new ArrayList<>(List.of(Path.of("HelloWorld.java"), Path.of("photo.PNG")));
        ArrayList<Path> res = new ArrayList<>();
        DirectoryStream.Filter<Path> filter = IS_READABLE.and(IS_WRITABLE).and(IS_EXECUTABLE);

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(path, filter)) {
            entries.forEach(entry -> res.add(entry.getFileName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertThat(res).isEqualTo(ans);
    }

    @Test
    void extensionFilterTest() throws IOException {
        Path path = Path.of("src/test/java/edu/hw6/filesForTests");
        ArrayList<Path> ans = new ArrayList<>(List.of(Path.of("text.txt")));
        ArrayList<Path> res = new ArrayList<>();
        DirectoryStream.Filter<Path> filter = hasExtension("txt");

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(path, filter)) {
            entries.forEach(entry -> res.add(entry.getFileName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertThat(res).isEqualTo(ans);
    }

    @Test
    void regexFilterTest() throws IOException {
        Path path = Path.of("src/test/java/edu/hw6/filesForTests");
        HashSet<Path> ans = new HashSet<>(List.of(
            Path.of("photo.PNG"),
            Path.of("text.txt")
        ));

        HashSet<Path> res = new HashSet<>();
        DirectoryStream.Filter<Path> filter = regexContains("[t]");

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(path, filter)) {
            entries.forEach(entry -> res.add(entry.getFileName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertThat(res).isEqualTo(ans);
    }

    @Test
    void globFilterTest() throws IOException {
        Path path = Path.of("src/test/java/edu/hw6/filesForTests");
        ArrayList<Path> ans = new ArrayList<>(List.of(Path.of("HelloWorld.java")));
        ArrayList<Path> res = new ArrayList<>();
        DirectoryStream.Filter<Path> filter = globMatches("*.java");

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(path, filter)) {
            entries.forEach(entry -> res.add(entry.getFileName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertThat(res).isEqualTo(ans);
    }

    @Test
    void magicNumbersFilterTest() throws IOException {
        Path path = Path.of("src/test/java/edu/hw6/filesForTests");
        ArrayList<Path> ans = new ArrayList<>(List.of(Path.of("photo.PNG")));
        ArrayList<Path> res = new ArrayList<>();
        DirectoryStream.Filter<Path> filter = magicNumber(0x89, 'P', 'N', 'G');

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(path, filter)) {
            entries.forEach(entry -> res.add(entry.getFileName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertThat(res).isEqualTo(ans);
    }
}
