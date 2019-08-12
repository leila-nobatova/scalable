import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Author: Leyla Nobatova

public class ScalableTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();

    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testScalableTest() throws InterruptedException {

        driver.get("https://teechip.com/defaulttest");

        driver.findElement(By.xpath("(//img[@src = 'https://cdn.32pt.com/public/sl-prod-od-0/images/retail-products/75E659AC37E1A2/75E659AC37E1A2-143F763AF1AB-GS4-TC0-WHT/front/thumb.jpg'])[2]")).click();
        driver.findElement(By.xpath("(//div[@style = 'background-color:#054ae8;'])[2]")).click();
        WebElement element = driver.findElement(By.xpath("//div[text() ='M']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        driver.findElement(By.xpath("//div[text() ='M']")).click();
        driver.findElement(By.xpath("//span[text() ='Buy it now']")).isEnabled();
        driver.findElement(By.xpath("//span[text() ='Buy it now']")).click();
        WebElement wait = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text() ='Your Cart'])[1]")));
        driver.findElement(By.xpath("(//span[text() ='Proceed to Checkout'])[1]")).click();
        driver.findElement(By.xpath("//input[@type = 'email']")).sendKeys("newemail123123123@gmail.com");
        driver.findElement(By.xpath("(//input[@type = 'text'])[1]")).sendKeys("Jessica");
        driver.findElement(By.xpath("//input[@autocomplete='address-line1']")).sendKeys("222 Main street");
        driver.findElement(By.xpath("//input[@autocomplete='address-line2']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@autocomplete='address-level2']")).sendKeys("San Francisco");
        driver.findElement(By.xpath("//input[@autocomplete='postal-code']")).sendKeys("94120");
        driver.switchTo().frame("braintree-hosted-field-number");
        driver.findElement(By.xpath("//input[@id='credit-card-number']")).sendKeys("5122527096061001");
        driver.switchTo().parentFrame();
        driver.switchTo().frame("braintree-hosted-field-expirationDate");
        driver.findElement(By.xpath("//input[@id='expiration']")).sendKeys("1220");
        driver.switchTo().parentFrame();
        driver.switchTo().frame("braintree-hosted-field-cvv");
        driver.findElement(By.xpath("//input[@id='cvv']")).sendKeys("123");
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//span[text()='Place Your Order']")).click();
        wait = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span/i[text()='Error CH034']")));

    }

}
