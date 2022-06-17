
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FiltersOptions {

    private BufferedImage bufferedImage;
    private int width;
    private int height;


    public FiltersOptions(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        this.width = this.bufferedImage.getWidth();
        this.height = this.bufferedImage.getHeight();
    }

    public void GrayscaleFilter() {
        this.width = this.bufferedImage.getWidth();
        this.height = this.bufferedImage.getHeight();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color c = new Color(this.bufferedImage.getRGB(j, i));
                int red = (int) (c.getRed() * 0.299);
                int green = (int) (c.getGreen() * 0.587);
                int blue = (int) (c.getBlue() * 0.114);
                Color newColor = new Color(red + green + blue, red + green + blue, red + green + blue);
                this.bufferedImage.setRGB(j, i, newColor.getRGB());
            }
        }
    }

    public void colorShiftRightFilter() {
        for (int x = 0; x < width; x++) { // יצירת צבע חדש מהצבעים שנמצאים בפיקסל
            for (int y = 0; y < height; y++) {
                int currentRgb = bufferedImage.getRGB(x, y);
                Color currentColor = new Color(currentRgb);
                int currentRed = currentColor.getRed();
                int currentGreen = currentColor.getGreen();
                int currentBlue = currentColor.getBlue();
                Color newColor = new Color(currentGreen, currentBlue, currentRed);
                bufferedImage.setRGB(x, y, newColor.getRGB());
            }
        }
    }
}