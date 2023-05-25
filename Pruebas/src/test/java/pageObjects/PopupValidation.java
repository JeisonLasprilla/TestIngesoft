package pageObjects;

import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.util.Random;

import static org.apache.commons.lang.math.RandomUtils.nextInt;

//Page Object 1
public class PopupValidation extends Base {

    private Random random;

    public PopupValidation(WebDriver driver) {
        super(driver);
        random = new Random();
    }

    By campoRequired = By.cssSelector("#req");

    By campoSelect = By.cssSelector("#sport");
    By campoMultipleSelect = By.cssSelector("#sport2");
    By campoUrl = By.cssSelector("#url1");
    By campoEmail = By.cssSelector("#email1");
    By campoPassword = By.cssSelector("#pass1");
    By campoConfirmPassword = By.cssSelector("#pass2");
    By campoMinimumFieldSize = By.cssSelector("#minsize1");
    By campoMaximumFieldSize = By.cssSelector("#maxsize1");
    By campoNumber = By.cssSelector("#number2");
    By campoIP = By.cssSelector("#ip");
    By campoDate = By.cssSelector("#date3");
    By campoDateEarlier = By.cssSelector("#past");


    public String popUpValidation(){

        // Obtener la URL antes del envío del formulario
        String urlBeforeSubmit = getCurrentUrl();

        // Generar los datos aleatoriamente
        String [] arrRequired ={ "Hello", "World", "Java", "Programming", "Random", "Phrases", "Example"};
        String required = arrRequired[nextInt(arrRequired.length)];
        String [] arrSelect ={ "Tennis", "Football", "Golf"};
        String select = arrSelect[random.nextInt(arrSelect.length)];
        String [] arrMultipleSelect ={ "Tennis", "Football", "Golf"};
        String multipleSelect = arrMultipleSelect[random.nextInt(arrMultipleSelect.length)];
        StringBuilder url = new StringBuilder();
        StringBuilder email = new StringBuilder();
        for (String word: arrRequired){
            url.append(word);
            email.append(word);
        }
        url.append(".com");
        email.append("@gmail.com");
        String password = required+"12345";
        String minimumFieldSize = String.valueOf(random.nextInt(999999));
        String MaximumFieldSize = String.valueOf(random.nextInt(999999));
        String number = String.valueOf(random.nextFloat(999999+999999+1)-999999); //3,402823466 E + 38
        String IP = random.nextInt(200)+"."+random.nextInt(200)+"."+random.nextInt(200)+"."+random.nextInt(200);
        String date = String.valueOf(LocalDate.now());
        String dateEarlier = random.nextInt(2012-1900+1)+1900 +"-"+String.format("%02d", random.nextInt(12-1)+1)+"-"+random.nextInt(30);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Rellenar el formulario
        diligenciarFormularioPopupValidation(required, select, multipleSelect, String.valueOf(url), String.valueOf(email), password, minimumFieldSize, MaximumFieldSize, number, IP, date, dateEarlier);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        click(By.xpath("//*[@id=\"popup-validation\"]/div[14]/input"));

        // Obtener la URL después del envío del formulario
        String urlAfterSubmit = getCurrentUrl();

        // Comparar las URLs
        if (!urlBeforeSubmit.equals(urlAfterSubmit)) {
            return "EL FORMULARIO  POP UP SE VALIDÓ CORRECTAMENTE!";
        } else {
            return "HUBO UN ERROR CON LA VALIDACIÓN DEL FORMULARIO!";
        }

    }

    public void diligenciarFormularioPopupValidation(String required, String select, String multipleSelect, String url, String email, String password, String minimumFieldSize, String maximumFieldSize, String number, String IP, String date, String dateEarlier){

        clear(campoRequired);
        type(required, campoRequired);
        type(select, campoSelect);
        type(multipleSelect, campoMultipleSelect);
        type(email, campoEmail);
        type(url, campoUrl);
        type(password, campoPassword);
        type(password, campoConfirmPassword);
        type(minimumFieldSize, campoMinimumFieldSize);
        clear(campoMaximumFieldSize);
        type(maximumFieldSize, campoMaximumFieldSize);
        clear(campoNumber);
        type(number, campoNumber);
        clear(campoIP);
        type(IP, campoIP);
        clear(campoDate);
        type(date, campoDate);
        clear(campoDateEarlier);
        type(dateEarlier, campoDateEarlier);
    }
}
