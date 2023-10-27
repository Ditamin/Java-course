package edu.hw2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class Task4Test {
    @Test
    void callingInfoTest() {
        Task4.CallingInfo caller = Task4.callingInfo();
        Assertions.assertThat(caller.className()).isEqualTo("edu.hw2.Task4Test");
        Assertions.assertThat(caller.methodName()).isEqualTo("callingInfoTest");
    }
}
