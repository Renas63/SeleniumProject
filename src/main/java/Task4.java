import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task4 {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @Test
    public void test4() throws InterruptedException {
        driver.get("https://icehrm-open.gamonoid.com/login.php?");
        WebElement loginUsername=driver.findElement(By.id("username"));
        loginUsername.sendKeys("admin");
        WebElement loginPassword=driver.findElement(By.id("password"));
        loginPassword.sendKeys("admin");
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(), 'Log in')]"));
        loginButton.click();

        Thread.sleep(1000);
        WebElement payrolButton=driver.findElement(By.xpath("//span[text()='Payroll']"));
        payrolButton.click();

        WebElement salaryButton=driver.findElement(By.xpath("//a[@href='https://icehrm-open.gamonoid.com/?g=admin&n=salary&m=admin_Payroll']"));
        salaryButton.click();

        WebElement salaryOption=driver.findElement(By.xpath("//a[@id='tabEmployeeSalary']"));
        salaryOption.click();

        Thread.sleep(3000);
        WebElement filterButton=driver.findElement(By.xpath("//button[@onclick='modJs.showFilters();return false;']"));
        filterButton.click();

        Thread.sleep(1000);
        WebElement nameFilterDropdown=driver.findElement(By.cssSelector("#s2id_employee"));
        nameFilterDropdown.click();
        Thread.sleep(1000);
        WebElement namesFilterDrop2=driver.findElement(By.cssSelector("#s2id_autogen2_search"));
        namesFilterDrop2.sendKeys("Lala Lamees"+ Keys.ENTER);

        Thread.sleep(1000);
        WebElement filter2=driver.findElement(By.cssSelector(".filterBtn"));
        filter2.click();

        Thread.sleep(2000);
        WebElement employeeName=driver.findElement(By.cssSelector("#EmployeeSalary_resetFilters"));
        employeeName.isDisplayed();
        Assert.assertEquals(employeeName.getText(),"Employee = Lala Lamees");

    }

}







