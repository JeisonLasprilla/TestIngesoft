package pageObjects;
import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.LocalDate;
import java.util.Random;

public class BlockValidation extends Base {
    private Random random;

    public BlockValidation(WebDriver driver) {
        super(driver);
        random = new Random();
    }

    By campoRequired = By.cssSelector("#required2");
    By campoEmail = By.cssSelector("#email2");
    By campoPassword = By.cssSelector("#password2");
    By campoConfirmPassword = By.cssSelector("#confirm_password2");
    By campoDate = By.cssSelector("#date2");
    By campoUrl = By.cssSelector("#url2");
    By campoDigitsOnly = By.cssSelector("#digits");
    By campoRange = By.cssSelector("#range");
    By campoAgreePolicy = By.cssSelector("#agree2");


    public String blockValidation(){
        // Obtener la URL actual antes de enviar el formulario
        String urlBeforeSubmit = getCurrentUrl();

        //Generar los datos aleatoriamente
        String [] arrRequired ={ "Hello", "World", "Java", "Programming", "Random", "Phrases", "Example"};
        String required = arrRequired[random.nextInt(arrRequired.length)];
        StringBuilder url = new StringBuilder("http://");
        StringBuilder email = new StringBuilder();
        for (String word: arrRequired){
            url.append(word);
            email.append(word);
        }
        url.append(".com");
        email.append("@gmail.com");
        String password = required+"12345";
        String date = String.valueOf(LocalDate.now());
        String digitsOnly = String.valueOf(random.nextInt(999999));
        String range = String.valueOf(random.nextInt(16-6)+6);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Rellenar el formulario
        diligenciarFormularioBlockValidation(required, String.valueOf(email), password, date, String.valueOf(url), digitsOnly, range);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(By.xpath("//*[@id=\"block-validate\"]/div[10]/input"));

        // Obtener la URL después del envío del formulario
        String urlAfterSubmit = getCurrentUrl();

        // Comparar las URLs
        if (!urlBeforeSubmit.equals(urlAfterSubmit)) {
            return "EL FORMULARIO BLOCK SE VALIDÓ CORRECTAMENTE!";
        } else {
            return "HUBO UN ERROR CON LA VALIDACIÓN DEL FORMULARIO BLOCK!";
        }
    }

    public void diligenciarFormularioBlockValidation(String required, String email, String password, String date, String URL, String digitsOnly, String range){
        clear(campoRequired);
        type(required, campoRequired);
        type(email, campoEmail);
        type(URL, campoUrl);
        type(password, campoPassword);
        type(password, campoConfirmPassword);
        type(date, campoDate);
        type(digitsOnly, campoDigitsOnly);
        type(range, campoRange);
        click(campoAgreePolicy);
    }
}
