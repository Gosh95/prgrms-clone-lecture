package org.prgrms.gccoffee.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Email("asdf"));
    }

    @Test
    void testValidEmail() {
        var email = new Email("test@gmail.com");

        assertTrue(email.getAddress().equals("test@gmail.com"));
    }
}