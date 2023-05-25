package com.project.pom;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.InlineValidation;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InlineValidationTest{
    private WebDriver driver;
    InlineValidation inlineValidation;

    public void setUp() throws Exception{
        inlineValidation = new InlineValidation(driver);
        driver = inlineValidation.chromeDriverConnection();
        inlineValidation.visit("https://colorlib.com/polygon/metis/form-validation.html");
    }

    public void tearDown() throws Exception{
        driver.quit();
    }

    @Test
    public void test() throws Exception{
        setUp();
        String confirmation = inlineValidation.inlineValidation();
        assertEquals( "EL FORMULARIO INLINE SE VALIDÓ CORRECTAMENTE!", confirmation);
        tearDown();
    }
}