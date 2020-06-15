import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginPage extends BeforeAndAfterTest {

    @Test
    public void loginTest() {
        driver.navigate().to("https://poczta.interia.pl/");

        WebElement rodoPopupClose = driver.findElement(By.className("rodo-popup-close"));
        rodoPopupClose.click();

        WebElement email = driver.findElement(By.id("formEmail"));
        email.clear();
        email.sendKeys("testcase@interia.pl");

        WebElement password = driver.findElement(By.id("formPassword"));
        password.clear();
        password.sendKeys("testcasepassword1");

        WebElement login = driver.findElement(By.id("formSubmit"));
        login.click();

        Assertions.assertEquals("Poczta w Interii", driver.getTitle(), "Title" + driver.getTitle() + "was not found");
        Assertions.assertTrue(driver.getPageSource().contains("Odebrane"), "Text \"Odebrane\" was not found");
        Assertions.assertEquals(1, driver.findElements(By.cssSelector(".icon-new.navigation-button.navigation-button--big.navigation-button--new")).size(), "No '\"New\" button found");

    }
}
