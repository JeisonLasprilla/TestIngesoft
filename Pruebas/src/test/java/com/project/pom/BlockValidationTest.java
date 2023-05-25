package com.project.pom;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.BlockValidation;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlockValidationTest {
    private WebDriver driver;
    BlockValidation blockValidation;

    public void setUp() throws Exception{
        blockValidation = new BlockValidation(driver);
        driver = blockValidation.chromeDriverConnection();
        blockValidation.visit("https://colorlib.com/polygon/metis/form-validation.html");
    }

    public void tearDown() throws Exception{
        driver.quit();
    }

    @Test
    public void test() throws Exception{
        setUp();
        String confirmation = blockValidation.blockValidation();
        assertEquals( "EL FORMULARIO BLOCK SE VALIDÓ CORRECTAMENTE!", confirmation);
        tearDown();
    }
}