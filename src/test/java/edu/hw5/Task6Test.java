package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {
    @ParameterizedTest
    @ValueSource(strings = {"abc", "123", "!", "h f", "ach fdbaabgabcaabg123! "})
    void stringContainedTest(String find) {
        String in = "ach fdbaabgabcaabg123! ";
        Assertions.assertThat(Task6.isSubStr(find, in)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"e", "32", "abcd 1234 !@#$ ", " @"})
    void stringNotContainedTest(String find) {
        String in = "abcd 1234 !@#$";
        Assertions.assertThat(Task6.isSubStr(find, in)).isEqualTo(false);
    }
}
