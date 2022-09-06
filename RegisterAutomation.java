package automation.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterAutomation {
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
        driver.findElement(By.xpath("//a[@href=\"/auth/realms/asians/login-actions/registration?client_id=public&tab_id=u340omMXmUo\"]")).click();
        Thread.sleep(2000);

        //Registration scenario

        driver.findElement(By.id("email")).sendKeys("qwerty@gmail.com");
        driver.findElement(By.id("password")).sendKeys("abcd@123");
        driver.findElement(By.id("password-confirm")).sendKeys("abcd@123");
        driver.findElement(By.xpath("//input[@value=\"Register\"]")).click();

        Thread.sleep(3000);

        //checking the page navigation after successful login
        String url_after_log_in = driver.getCurrentUrl();
        String expected_url = "https://console.uat.asians.group/#/domain/list";
        if(url_after_log_in.equals(expected_url)){
            System.out.println("The expected page is navigated");
        } else{
            System.out.println("The page is not navigated");
        }
        //logging out
        driver.findElement(By.xpath("//div[@class='vue-avatar--wrapper']")).click();
        driver.findElement(By.xpath("//button[@class=\"btn\" and contains(text(),\"Logout\")]")).click();

        //Logging Scenario
        //sleep time is used for waiting untill the page loads
        Thread.sleep(3000);
        driver.findElement(By.id("username")).sendKeys("qwerty@gmail.com");
        driver.findElement(By.id("password")).sendKeys("abcd@123");
        driver.findElement(By.name("login")).click();
        Thread.sleep(3000);

        //checking the page navigation after successful login
        String a_log_in = driver.getCurrentUrl();
        String e_login = "https://console.uat.asians.group/#/domain/list";
        if(a_log_in.equals(e_login)){
            System.out.println("The expected page is navigated");
        } else{
            System.out.println("The page is not navigated");
        }


        //closes the current browser
        driver.close();

    }
}

