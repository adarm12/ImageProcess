import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ImageFile {

    public static final File ORIGINAL_FILE = new File("C:\\Users\\shani\\Desktop\\לימודים שנה א\\מדמח\\קבצים תוכנית\\dora\\Dora.jpg");
    private BufferedImage bufferedImage;

//    File file = new File("C:\\Users\\adarm\\Pictures\\Saved Pictures\\Dora.jpg");
//    BufferedImage bufferedImage = ImageIO.read(file);

    public ImageFile() {

    }
//
//    public BufferedImage outputImage() {
//        File output = new File("C:\\Users\\shani\\Desktop\\לימודים שנה א\\מדמח\\קבצים תוכנית\\dora\\output.jpg");
//        try {
//            ImageIO.write(bufferedImage, "jpg", output);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//
//    }

    public BufferedImage getOriginImage() {
        try {
            this.bufferedImage = ImageIO.read(ORIGINAL_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }
}