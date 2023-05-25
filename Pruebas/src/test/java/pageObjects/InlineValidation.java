package pageObjects;
import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.LocalDate;
import java.util.Random;

public class InlineValidation extends Base {
    private Random random;

    public InlineValidation(WebDriver driver) {
        super(driver);
        random = new Random();
    }

    By campoRequired = By.cssSelector("#required");
    By campoEmail = By.cssSelector("#email");
    By campoPassword= By.cssSelector("#password");
    By campoConfirmPassword = By.cssSelector("#confirm_password");
    By campoDate = By.cssSelector("#date");
    By campoURL = By.cssSelector("#url");
    By campoCharsMin3 = By.cssSelector("#minsize");
    By campoCharsMax6 = By.cssSelector("#maxsize");
    By campoMin3 = By.cssSelector("#minNum");
    By campoMax16 = By.cssSelector("#maxNum");
    By campoAgreePolicy = By.cssSelector("#agree");

    public String inlineValidation(){

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
        String charsMin3 = "aaaa";
        String charsMax6 = "aaaa";
        String min3 = String.valueOf(random.nextInt(999-100+1)+100);
        String max16 = String.valueOf(random.nextDouble(0.999999999999999));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Rellenar el formulario
        diligenciarFormularioInlineValidation(required, String.valueOf(email), password, date, String.valueOf(url), charsMin3, charsMax6, min3, max16);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(By.xpath("//*[@id=\"inline-validate\"]/div[12]/input"));

        // Obtener la URL después del envío del formulario
        String urlAfterSubmit = getCurrentUrl();

        // Comparar las URLs
        if (!urlBeforeSubmit.equals(urlAfterSubmit)) {
            return "EL FORMULARIO INLINE SE VALIDÓ CORRECTAMENTE!";
        } else {
            return "HUBO UN ERROR CON LA VALIDACIÓN DEL FORMULARIO INLINE!";
        }
    }

    public void diligenciarFormularioInlineValidation(String required, String email, String password, String date, String url, String charsMin3, String charsMax6, String min3, String max16){
        type(required, campoRequired);
        type(email, campoEmail);
        type(password, campoPassword);
        type(password, campoConfirmPassword);
        type(date, campoDate);
        type(url, campoURL);
        type(charsMin3, campoCharsMin3);
        type(charsMax6, campoCharsMax6);
        type(min3, campoMin3);
        type(max16, campoMax16);
        click(campoAgreePolicy);
    }
}

