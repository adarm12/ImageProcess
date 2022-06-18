import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ImageFile {

    public static final File ORIGINAL_FILE = new File("C:\\Users\\shani\\Desktop\\לימודים שנה א\\מדמח\\קבצים תוכנית\\dora\\Dora.jpg");
//    public static final File ORIGINAL_FILE =  new File("C:\\Users\\adarm\\Pictures\\Saved Pictures\\Dora.jpg");

    public static final File OUTPUT_IMAGE = new File("C:\\Users\\shani\\Desktop\\לימודים שנה א\\מדמח\\קבצים תוכנית\\dora\\output.jpg");

    private BufferedImage bufferedImageBefore;
    private BufferedImage bufferedImageAfter;
//    File file = new File("C:\\Users\\adarm\\Pictures\\Saved Pictures\\Dora.jpg");
//    BufferedImage bufferedImage = ImageIO.read(file);

    public ImageFile() {
    }

    public void outputImage() {
        try {
            ImageIO.write(bufferedImageAfter, "jpg", OUTPUT_IMAGE);
//            this.bufferedImageAfter = ImageIO.read(outputImage);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       }

    public BufferedImage getImageAfter() {
        try {
            this.bufferedImageAfter = ImageIO.read(OUTPUT_IMAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImageBefore;
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