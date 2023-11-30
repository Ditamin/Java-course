package edu.hw6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    Task1 task1 = new Task1();

    @Test
    void writeTest() throws IOException {
        String fileName = "output.txt";
        HashMap<String, String> map = new HashMap<>();
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        String ans = """
            one:1
            two:2
            three:3""";

        FileWriter writer = new FileWriter(fileName);
        writer.write(ans);
        writer.close();

        Task1.DiskMap disk = task1.new DiskMap(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        disk.write(map);
        Assertions.assertThat(reader.lines().toList()).isEqualTo(ans.lines().toList());
        reader.close();
        disk.delete();
    }

    @Test
    void readTest() throws IOException {
        String fileName = "input.txt";
        String data = """
            one:1
            two:2
            three:3""";

        HashMap<String, String> map = new HashMap<>();
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");

        Task1.DiskMap disk = task1.new DiskMap(fileName);
        FileWriter writer = new FileWriter(fileName);
        writer.write(data);
        writer.close();

        Assertions.assertThat(disk.read()).isEqualTo(map);
        disk.delete();
    }
}
