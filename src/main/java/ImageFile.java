import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ImageFile {

    public static final File ORIGINAL_FILE = new File("C:\\Users\\shani\\Desktop\\לימודים שנה א\\מדמח\\קבצים תוכנית\\dora\\Dora.jpg");
//    public static final File ORIGINAL_FILE =  new File("C:\\Users\\adarm\\Pictures\\Saved Pictures\\Dora.jpg");

    public static final File OUTPUT_IMAGE = new File("C:\\Users\\shani\\Desktop\\לימודים שנה א\\מדמח\\קבצים תוכנית\\dora\\output.jpg");
//    public static final File OUTPUT_IMAGE = new File("C:\\Users\\adarm\\Pictures\\Saved Pictures\\output.jpg");

    private BufferedImage bufferedImageBefore;

    public void saveNewImage(BufferedImage imageLabelAfter) {
        try {
            ImageIO.write(imageLabelAfter, "jpg", OUTPUT_IMAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getOriginImage() {
        try {
            this.bufferedImageBefore = ImageIO.read(ORIGINAL_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImageBefore;
    }
}