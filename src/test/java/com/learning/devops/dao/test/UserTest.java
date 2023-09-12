package com.learning.devops.dao.test;

import org.junit.jupiter.api.Test;

import com.learning.devops.entities.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testValidGmailAddress() {
        User user = new User("John Doe", "johndoe@gmail.com", "password123");
        assertTrue(user.isGmailAddress());
    }

    @Test
    public void testInvalidGmailAddress() {
        User user = new User("Jane Smith", "jane.smith@example.com", "password456");
        assertFalse(user.isGmailAddress());
    }

    @Test
    public void testEmptyEmail() {
        User user = new User("Alice Johnson", "", "password789");
        assertFalse(user.isGmailAddress());
    }

    @Test
    public void testNullEmail() {
        User user = new User("Bob Brown", null, "passwordabc");
        assertFalse(user.isGmailAddress());
    }
}

