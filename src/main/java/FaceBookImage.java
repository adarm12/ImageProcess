import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FaceBookImage {

    public static final String LINK = "https://www.facebook.com/";
    public static final File OUTPUT_IMAGE = new File("C:\\Users\\adarm\\Pictures\\Saved Pictures\\output.jpg");


    private ChromeDriver faceBookDriver;
    private BufferedImage image;

    public FaceBookImage() {
        connectToFaceBook();
    }

    public void connectToFaceBook() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\adarm\\Downloads\\chromedriver_win32 (8)\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-air=C:\\Users\\adarm\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1\n");

//        this.faceBookDriver = new ChromeDriver(options);
//        this.faceBookDriver.get(LINK + "");
//        this.faceBookDriver.manage().window().maximize();
//        List<WebElement> connectButton = this.faceBookDriver.findElements(By.tagName("svg"));
//        System.out.println(connectButton.size());
//        List<WebElement> pictureId = connectButton.get(3).findElements(By.tagName("g"));
//        System.out.println(pictureId.size());
//        WebElement picture = pictureId.get(0);
//        this.image = (BufferedImage) picture;
//        saveNewImage(this.image);


//        connectButton.click();
//        WebElement userName = this.faceBookDriver.findElement(By.id("email"));
//        userName.sendKeys("");
//        WebElement password = this.faceBookDriver.findElement(By.id("pass"));
//        password.sendKeys("");
//        WebElement connect = this.faceBookDriver.findElement(By.name("login"));
//        connect.click();
//        this.faceBookDriver.get(LINK + "");
//        this.faceBookDriver.manage().window().maximize();

    }

    public void saveNewImage(BufferedImage imageLabelAfter) {
        try {
            ImageIO.write(imageLabelAfter, "jpg", OUTPUT_IMAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
