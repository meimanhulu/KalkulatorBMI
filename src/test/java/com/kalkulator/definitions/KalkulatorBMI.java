package com.kalkulator.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class KalkulatorBMI {

    private double beratBadan;
    private double tinggiBadan;
    private double hasilBmi;
    private String kategoriBmi;

    @Given("saya mengisi field berat badan dengan {double} kg")
    public void sayaMengisiFieldBeratBadan(double berat) {
        this.beratBadan = berat;
    }

    @And("saya mengisi field tinggi badan dengan {double} m")
    public void sayaMengisiFieldTinggiBadan(double tinggi) {
        this.tinggiBadan = tinggi;
    }

    @When("saya menekan tombol Hitung BMI")
    public void sayaMenekanTombolHitungBmi() {
        hasilBmi = beratBadan / (tinggiBadan * tinggiBadan);
        kategoriBmi = tentukanKategoriBmi(hasilBmi);
    }

    @Then("saya mendapatkan hasil BMI {double}")
    public void sayaMendapatkanHasilBmi(double expectedBmi) {
        System.out.println(hasilBmi);
        Assert.assertEquals(hasilBmi, expectedBmi, 0.01, "Hasil BMI tidak sesuai!");
    }

    @And("saya mendapatkan kategori {string}")
    public void sayaMendapatkanKategori(String expectedKategori) {
        Assert.assertEquals(kategoriBmi, expectedKategori, "Kategori BMI tidak sesuai!");
    }

    private String tentukanKategoriBmi(double bmi) {
        if (bmi < 18.5) {
            return "Kurus";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Gemuk";
        } else {
            return "Obesitas";
        }
    }
}