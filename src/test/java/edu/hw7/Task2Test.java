package edu.hw7;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void nullFactorialTest() {
        int num = 0;
        int res = Task2.factorial(num);
        Assertions.assertThat(res).isEqualTo(1);
    }

    @Test
    void oneFactorialTest() {
        int num = 2;
        int res = Task2.factorial(num);
        Assertions.assertThat(res).isEqualTo(2);
    }

    @Test
    void tenFactorialTest() {
        int num = 10;
        int res = Task2.factorial(num);
        Assertions.assertThat(res).isEqualTo(3_628_800);
    }
}
