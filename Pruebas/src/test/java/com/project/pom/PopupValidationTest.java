package com.project.pom;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.PopupValidation;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PopupValidationTest {

    private WebDriver driver;
    PopupValidation popupValidation;

    public void setUp() throws Exception{
        popupValidation = new PopupValidation(driver);
        driver = popupValidation.chromeDriverConnection();
        popupValidation.visit("https://colorlib.com/polygon/metis/form-validation.html");
    }

    public void tearDown() throws Exception{
        driver.quit();
    }

    @Test
    public void test() throws Exception{
        setUp();
        String confirmation = popupValidation.popUpValidation();
        assertEquals( "EL FORMULARIO  POP UP SE VALIDÓ CORRECTAMENTE!" , confirmation);
        tearDown();
    }

}