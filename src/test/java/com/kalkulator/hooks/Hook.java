package com.kalkulator.hooks;

import io.cucumber.java.*;

public class Hook {
    @BeforeAll
    public static void initialize() {
        System.out.println("INTIALIZE TEST");
    }

    @Before
    public void setup() {
        System.out.println("setup");
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println("Before Step: Persiapan sebelum menjalankan langkah...");
    }

    @AfterStep
    public void afterStep() {
        System.out.println("After Step: Pembersihan setelah langkah selesai...");
    }

    @After
    public void teardown() {
        System.out.println("teardown");
    }

    @AfterAll
    public static void finalTerdown() {
        System.out.println("FINAL TEST");
    }
}