import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class read_blogs {

    WebDriver driver;

    @Test
    public void blogPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://salonreserve.com/blog");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //01.scroll to 1000pixel
        //js.executeScript("window.scrollBy(0,1000)","");

        //scroll till the need elemnt
        WebElement salon = driver.findElement(By.xpath("//div[@class='row']//div[1]//div[1]//div[1]//a[1]//img[1]"));
        js.executeScript("arguments[0].scrollIntoView();",salon );

        //03.scroll to bottom
        //js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }
}
