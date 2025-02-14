package com.kalkulator.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "",
        features = {"src/test/resources/features/KalkulatorBMI.feature"

        },
        glue = {"com.kalkulator.definitions",

        },
        plugin = {"pretty", "html:target/cucumber-reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        }
)
public class RunnerTest extends AbstractTestNGCucumberTests {
}