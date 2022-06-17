import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFile {

    public static final File FILE = new File("C:\\Users\\shani\\Desktop\\לימודים שנה א\\מדמח\\קבצים תוכנית\\dora\\Dora.jpg");
    private BufferedImage bufferedImage;

    public ImageFile() {
        try {
            this.bufferedImage = ImageIO.read(FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public ImageIcon getImage() {
        ImageIcon image = new ImageIcon(FILE.getPath());
        return image;
    }
}