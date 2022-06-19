import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FaceBookImage {

    public static final String LINK = "https://www.facebook.com/";

    private ChromeDriver faceBookDriver;

    public FaceBookImage() {
        connectToFaceBook();
    }

    public void connectToFaceBook() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\adarm\\Downloads\\chromedriver_win32 (8)\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-air=C:\\Users\\adarm\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1\n");
        this.faceBookDriver = new ChromeDriver(options);
        this.faceBookDriver.get(FaceBookImage.LINK);
        this.faceBookDriver.manage().window().maximize();
        WebElement userName = this.faceBookDriver.findElement(By.id("email"));
        userName.sendKeys("");
        WebElement password = this.faceBookDriver.findElement(By.id("pass"));
        password.sendKeys("");
        WebElement connect = this.faceBookDriver.findElement(By.name("login"));
        connect.click();
        this.faceBookDriver.get(LINK+"");
        this.faceBookDriver.manage();

    }

}
