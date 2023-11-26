package edu.hw7;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Stream;

class Task3Test {
    Task3 task3 = new Task3();

    @Test
    void findMethodsTest() {
        var database = task3.new PersonDatabaseSynchronized();
        Task3.Person person = new Task3.Person(1, "Tom", "Tomsk", "01");
        database.add(person);

        var idFromName = database.findByName(person.name());
        var idFromAddress = database.findByAddress(person.address());
        var idFromPhone = database.findByPhone(person.phoneNumber());

        Assertions.assertThat(idFromName)
            .isEqualTo(idFromAddress)
            .isEqualTo(idFromPhone)
            .isEqualTo(List.of(person));
    }

    @Test
    void deleteTest() {
        var database = task3.new PersonDatabaseSynchronized();
        Task3.Person person = new Task3.Person(1, "Tom", "Tomsk", "01");
        database.add(person);
        database.delete(person.id());

        var idFromName = database.findByName(person.name());
        var idFromAddress = database.findByAddress(person.address());
        var idFromPhone = database.findByPhone(person.phoneNumber());

        Assertions.assertThat(idFromName)
            .isEqualTo(idFromAddress)
            .isEqualTo(idFromPhone)
            .isEqualTo(List.of());
    }

    @Test
    void multiReading() throws InterruptedException {
        var database = task3.new PersonDatabaseSynchronized();
        database.add(new Task3.Person(1, "2", "3", "4"));

        Runnable reading = () -> {
            var idByName = database.findByName("2");
            var idByAddress = database.findByAddress("3");
            var idByPhone = database.findByPhone("4");
            Assertions.assertThat(idByName).isEqualTo(idByAddress).isEqualTo(idByPhone);
        };

        var readTasks = Stream.generate(() -> new Thread(reading))
            .limit(100)
            .toList();

        var writeTask = new Thread(() -> {
            database.add(new Task3.Person(1, "2", "3", "4"));
        });

        for (var task : readTasks) {
            task.start();
        }

        writeTask.start();

        for (var task : readTasks) {
            task.join();
        }

        writeTask.join();
    }
}
