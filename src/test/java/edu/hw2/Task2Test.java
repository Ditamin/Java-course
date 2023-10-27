package edu.hw2;

import edu.hw2.Task2.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Rectangle()),
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        rect.setWidth(20);
        rect.setHeight(10);

        assertThat(rect.area()).isEqualTo(0);
        assertThat(rect.setHeight(10).setWidth(20).area()).isEqualTo(200);
    }

    @Test
    void squareTest() {
        var square = new Square(2);
        assertThat(square.area()).isEqualTo(4);
        assertThat(square.setWidth(5).area()).isEqualTo(10);
        assertThat(square.setHeight(5).area()).isEqualTo(10);
    }

    @Test
    void rectangleTest() {
        var rect = new Rectangle(2, 3);
        assertThat(rect.area()).isEqualTo(6);
        assertThat(rect.setWidth(5).area()).isEqualTo(15);
        assertThat(rect.setHeight(5).area()).isEqualTo(10);
    }
}
