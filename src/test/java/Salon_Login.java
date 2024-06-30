import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Salon_Login {

    WebDriver driver;

    @BeforeMethod
    public void loginPage(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://salonreserve.com/customer/login");
    }
    @Test
    public void login(){

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("lanka@thesanmark.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Lanka1234#");
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();
        WebElement successText = driver.findElement(By.xpath("//*[@id='swal2-content']/p"));

        WebElement buttonOK = driver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]"));
        buttonOK.click();
    }
}
