package com.kalkulator.definitions;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class KalkulatorBMI {
    private float weight;
    private float height;
    private float bmi;
    private String category;

    @Given("saya mengisi field berat badan dengan {float} kg")
    public void haveBerat(float weight) {
        this.weight = weight;
    }

    @And("saya mengisi field tinggi badan dengan {float} m")
    public void haveTinggi(float height) {
        this.height = height;
    }

    @When("saya menekan tombol Hitung BMI")
    public void calculateBMI() {
        this.bmi = this.weight/(this.height*this.height);

        DecimalFormat decfor = new DecimalFormat("0.00");
        decfor.setRoundingMode(RoundingMode.HALF_EVEN);
        this.bmi= Float.parseFloat(decfor.format(this.bmi));

        if (this.bmi<18.5){
            this.category="Underweight";
        } else if (this.bmi>=18.5 && this.bmi<=24.9) {
            this.category="Normal";
        } else if (this.bmi>=25 && this.bmi<=29.9) {
            this.category="Overweight";
        } else if (this.bmi>=30 && this.bmi<=34.9) {
            this.category="Obesity Class 1";
        } else if (this.bmi>=35 && this.bmi<=39.9) {
            this.category="Obesity Class 2";
        } else {
            this.category="Obesity Class 3";
        }
    }

    @Then("saya mendapatkan hasil BMI {float}")
    public void resultBMI(float expectedBMI) {
        Assert.assertEquals(bmi, expectedBMI);
    }

    @ParameterType(".*")
    public String stringValue(String arg) {
        return arg.substring(1, arg.length() - 1);
    }


    @And("saya mendapatkan kategori {stringValue}")
    public void resultCategory(String expectedCategory) {
        Assert.assertEquals(category, expectedCategory);
    }
}