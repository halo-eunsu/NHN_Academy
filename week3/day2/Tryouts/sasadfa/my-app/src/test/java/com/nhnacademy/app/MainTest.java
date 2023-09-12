package com.nhnacademy.app;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(Lifecycle.PER_CLASS)
class MainTest {
    private static Stream<Arguments> testcases() {
        return Stream.of(Arguments.of(1, 10, 4), Arguments.of(1, 50, 15),
                Arguments.of(1, 1000, 168), Arguments.of(1, 100000, 9592), Arguments.of(5, 20, 6),
                Arguments.of(11, 123, 26), Arguments.of(55, 5555, 716),
                Arguments.of(1000, 100000, 9424));
    }

    @ParameterizedTest(name = "{0}, {1} --> {2}")
    @MethodSource("testcases")
    @DisplayName("[5] 소수")
    void test(int start, int end, int answer) {
        assertEquals(Main.solution(start, end), answer);
    }
}

