package edu.hw2;

import edu.hw2.Task3.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    Task3 task3 = new Task3();
    @Test
    @DisplayName("Проверка FaultyConnectionManager")
    void faultyConnectionManagerTest() {
        int maxAttempts = 1;
        var manager = task3.new FaultyConnectionManager();
        var executor = task3.new PopularCommandExecutor(manager, maxAttempts);

        // Будет дано FaultyConnection с ошибкой
        Assertions.assertThatThrownBy(executor::updatePackages).isInstanceOf(ConnectionException.class);

        // Будет дано FaultyConnection успешно выполняющее команду
        Assertions.assertThatNoException().isThrownBy(executor::updatePackages);
    }

    @Test
    @DisplayName("Проверка DefaultConnectionManager")
    void defaultConnectionManagerTest() {
        int maxAttempts = 1;
        var manager = task3.new DefaultConnectionManager();
        var executor = task3.new PopularCommandExecutor(manager, maxAttempts);

        // Будет дано FaultyConnection с ошибкой
        Assertions.assertThatThrownBy(executor::updatePackages).isInstanceOf(ConnectionException.class);

        // Будет дано StableConnection
        Assertions.assertThatNoException().isThrownBy(executor::updatePackages);

        // Будет дано FaultyConnection успешно выполняющее команду
        Assertions.assertThatNoException().isThrownBy(executor::updatePackages);

        // Будет дано StableConnection
        Assertions.assertThatNoException().isThrownBy(executor::updatePackages);
    }
}
