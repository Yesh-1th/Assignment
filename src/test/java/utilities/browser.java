package utilities;

import Report.ReportConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class browser {
   ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    String browser;

    public browser(String broswer) {
        this.browser = broswer;
    }

    public WebDriver createDriver() {

        switch (browser){
            case"chrome":
                    System.setProperty("webdriver.chrome.driver","C:\\Work\\software for Selenium\\chromedriver_win32\\chromedriver.exe");
                     driver.set(new ChromeDriver());
                    break;
            case "firefox":
                    System.setProperty("webdriver.gecko.driver", "C:\\Work\\software for Selenium\\geckodriver-v0.29.0-win64\\geckodriver.exe");
                     driver.set(new FirefoxDriver());

                    break;
            case "edge":
                    System.setProperty("webdriver.edge.driver","C:\\Work\\software for Selenium\\edgedriver_win64 (1)\\msedgedriver.exe");
                    driver.set(new EdgeDriver());
                    break;


        }
        return driver.get();

    }
}
