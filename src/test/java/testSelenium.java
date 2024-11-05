import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

class testSelenium {

    public static WebDriver driver;
    public static void main (String[] args) throws InterruptedException {
        System.out.println("Hello world");

        ChromeOptions options = new ChromeOptions();
        //option addArguments("---headless---);
        options.addArguments("--no sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://pintu.co.id");
        Thread.sleep(500);
        driver.quit();


    }
}
