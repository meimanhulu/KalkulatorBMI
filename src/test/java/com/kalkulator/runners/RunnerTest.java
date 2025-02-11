package com.kalkulator.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/features/KalkulatorBMI.feature",
        },
        glue = {
                "com.kalkulator.definitions",
        }
)
public class RunnerTest extends AbstractTestNGCucumberTests {
}