package com.example.rbac;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "name\nother", "two|columns"})
    void rejectsInvalidNames(String name) {
        assertThrows(IllegalArgumentException.class, () -> new User(name, Role.USER));
    }

    @Test
    void acceptsKazakhLetters() {
        assertEquals("Әнел", new User("Әнел", Role.USER).getUsername());
    }

    @Test
    void requiresARole() {
        assertThrows(NullPointerException.class, () -> new User("tester", null));
    }
}
