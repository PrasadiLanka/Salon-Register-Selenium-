import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class loginUtility {

        WebDriver driver;

    @BeforeMethod
    public void loginPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://salonreserve.com/customer/login");
    }

    @Test
    public void login() {
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("lanka+68@thesanmark.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Lanka123#");
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();

        WebElement actualText = driver.findElement(By.xpath("(//p[normalize-space()='Login is successful'])[1]"));
        String expectedText = "Login is successful";
        if (actualText.getText().equals(expectedText)) {
            System.out.println("Login Pass");
        } else {
            System.out.println("Login fail");
        }
        driver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();

        //salon add
        WebElement addSalonLink = driver.findElement(By.xpath("(//a[normalize-space()='Add Salon'])[1]"));
        addSalonLink.click();

        WebElement salonName = driver.findElement(By.xpath("(//input[@name='listing_name'])[1]"));
        salonName.sendKeys("Zeeba");
        WebElement salonSlug = driver.findElement(By.xpath("(//input[@name='listing_slug'])[1]"));
        salonSlug.sendKeys("salon-zeeba");
        WebElement salonDesc = driver.findElement(By.xpath("(//div[@role='textbox'])[1]"));
        salonDesc.sendKeys("sri lanka's NO 1 salon expirience");
        WebElement dropdown = driver.findElement(By.xpath("(//select[@name='listing_category_id'])[1]"));
        Select select = new Select(dropdown);
        select.selectByValue("15");
        WebElement dropdown2 = driver.findElement(By.xpath("(//select[@name='listing_location_id'])[1]"));
        Select select2 = new Select(dropdown2);
        select2.selectByValue("15");
        WebElement uploadFile = driver.findElement(By.xpath("(//input[@name='listing_featured_photo'])[1]"));
        uploadFile.sendKeys("/home/lanka/Downloads/1705470309.266x330px Image-03.jpg");
        }
    }
