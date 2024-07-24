import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Salon_Login {

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
        if (actualText.getText().equals(expectedText)) { //this also can write as actualTitle.equals(expexctedTitle)
            System.out.println("Login Pass");
        } else {
            System.out.println("Login fail");
        }
        driver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();

        //add review
        driver.findElement(By.linkText("Home")).click();
        WebElement searchInput = driver.findElement(By.xpath("(//input[@placeholder='Salon Name ...'])[1]"));
        searchInput.sendKeys("nowdy");
        searchInput.submit();

        driver.findElement(By.xpath("(//a)[18]")).click();

        /*if(driver.findElement(By.xpath("//div[@class='text-danger']")).isDisplayed()) {
            System.out.println("aleady reviewed");
        }
        else{
            System.out.println("Nooo");
        }

        else {
            WebElement review = driver.findElement(By.xpath("//textarea[@name='review'])[1]"));
            if (review.isDisplayed()) {
                review.sendKeys("sooo good");
                driver.findElement(By.xpath("(//button[normalize-space()='Submit'])[1]")).click();

                WebElement actualText2 = driver.findElement(By.xpath("(//p[normalize-space()='Rating is placed successfully'])[1]"));
                String expectedText2 = "Rating is placed successfully";
                if (actualText2.getText().equals(expectedText2)) { //this also can write as actualTitle.equals(expexctedTitle)
                    System.out.println("Pass");
                } else {
                    System.out.println("fail");
                }
                driver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();
            }
        }*/
    }
}






