import org.openqa.selenium.WebDriver;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {

    protected static WebDriver driver;
    protected static String browser = System.getProperty("browser").toUpperCase();

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //возможен запуск с опциями:
        //driver = WebDriverFactory.createNewDriver(DriverName.valueOf(browser), options);
        driver = WebDriverFactory.create(DriverNames.valueOf(browser));
    }
    @Test
    public void openPage() {
        driver.manage().window().maximize();
        driver.get("https://otus.ru/");
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}