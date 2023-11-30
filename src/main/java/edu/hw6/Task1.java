package edu.hw6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class Task1 {
    public class DiskMap {
        private final static String COLON = ":";
        File disk;

        public DiskMap() {
            disk = new File("DiskMapData.txt");
        }

        public DiskMap(String diskName) {
            disk = new File(diskName);
        }

        public void write(Map<String, String> data) {
            try (FileWriter writer = new FileWriter(disk)) {
                for (var entry : data.entrySet()) {
                    writer.write(entry.getKey() + COLON + entry.getValue() + '\n');
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public Map<String, String> read() {
            try (BufferedReader reader = new BufferedReader(new FileReader(disk))) {
                return reader.lines().collect(Collectors.toMap(
                    (String entry) -> {
                        return entry.split(COLON)[0]; },
                    (String entry) -> {
                        return entry.split(COLON)[1]; })
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean delete() {
            return disk.delete();
        }
    }
}
