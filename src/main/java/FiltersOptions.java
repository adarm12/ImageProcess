
import java.awt.*;
import java.awt.image.BufferedImage;

public class FiltersOptions {

    private BufferedImage bufferedImageOrigin;
    private int width;
    private int height;


    public FiltersOptions(BufferedImage bufferedImage) {
        this.bufferedImageOrigin = bufferedImage;
        this.width = this.bufferedImageOrigin.getWidth();
        this.height = this.bufferedImageOrigin.getHeight();
    }

    public BufferedImage GrayscaleFilter() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color c = new Color(this.bufferedImageOrigin.getRGB(j, i));
                int red = (int) (c.getRed() * 0.299);
                int green = (int) (c.getGreen() * 0.587);
                int blue = (int) (c.getBlue() * 0.114);
                Color newColor = new Color(red + green + blue, red + green + blue, red + green + blue);
                this.bufferedImageOrigin.setRGB(j, i, newColor.getRGB());
            }
        }
        return this.bufferedImageOrigin;
    }


    public BufferedImage colorShiftLeftFilter() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int currentRgb = bufferedImageOrigin.getRGB(x, y);
                Color currentColor = new Color(currentRgb);
                int currentRed = currentColor.getRed();
                int currentGreen = currentColor.getGreen();
                int currentBlue = currentColor.getBlue();
                Color newColor = new Color(currentGreen, currentBlue, currentRed);
                bufferedImageOrigin.setRGB(x, y, newColor.getRGB());
            }
        }
        return this.bufferedImageOrigin;
    }

    public BufferedImage colorShiftRightFilter() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int currentRgb = bufferedImageOrigin.getRGB(x, y);
                Color currentColor = new Color(currentRgb);
                int currentRed = currentColor.getRed();
                int currentGreen = currentColor.getGreen();
                int currentBlue = currentColor.getBlue();
                Color newColor = new Color(currentBlue, currentRed, currentGreen);
                bufferedImageOrigin.setRGB(x, y, newColor.getRGB());
            }
        }
        return this.bufferedImageOrigin;
    }

}