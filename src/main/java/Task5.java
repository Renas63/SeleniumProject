import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task5 {
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

    }
    @Test
    public void test5(){
        driver.get("https://icehrm-open.gamonoid.com/login.php?");
        WebElement loginUsername=driver.findElement(By.id("username"));
        loginUsername.sendKeys("admin");
        WebElement loginPassword=driver.findElement(By.id("password"));
        loginPassword.sendKeys("admin");
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(), 'Log in')]"));
        loginButton.click();

    }
}
