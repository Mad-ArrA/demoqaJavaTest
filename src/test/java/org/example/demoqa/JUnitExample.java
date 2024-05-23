package org.example.demoqa;

import org.junit.jupiter.api.*;

public class JUnitExample {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Test before all");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Test before each");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Test after all");
    }

    @AfterEach
    void afterEach(){
        System.out.println("Test after each");
    }

    @Test
    void firstTest(){
        System.out.println("Test 1");
    }

    @Test
    void secondTest(){
        System.out.println("Test 2");
    }
}
