package automation.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAutomation {
    public static void main(String[] args) throws InterruptedException {

        //For opening the chrome driver
        System.setProperty("webdriver.chrome.driver", "D:\\3rdparty\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //maximizing the size of the window
        driver.manage().window().maximize();

        // opening the mentioned URL
        driver.get("https://console.uat.asians.group/#/domain/list");

        //sleep time is used for waiting untill the page loads
        Thread.sleep(3000);
        driver.findElement(By.id("username")).sendKeys("ash1994@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Advaitha@2021");
        driver.findElement(By.name("login")).click();
        Thread.sleep(3000);

        //checking the page navigation after successful login 
        String url_after_log_in = driver.getCurrentUrl();
        String expected_url = "https://console.uat.asians.group/#/domain/list";
        if(url_after_log_in.equals(expected_url)){
            System.out.println("The expected page is navigated");
        } else{
            System.out.println("The page is not navigated");
        }

        //closes the current browser
        driver.close();
    }
}

