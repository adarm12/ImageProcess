
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
        System.out.println("before" + width);
        System.out.println("before HEIGHT" + height);

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
                int currentRgb = this.bufferedImageOrigin.getRGB(x, y);
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
                int currentRgb = this.bufferedImageOrigin.getRGB(x, y);
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

//    public BufferedImage sepia() {
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                Color currentColor = new Color(this.bufferedImageOrigin.getRGB(j, i));
//                int red = (int) (currentColor.getRed() * 0.2126);
//                int green = (int) (currentColor.getGreen() * 0.7152);
//                int blue = (int) (currentColor.getBlue() * 0.0722);
//                Color newColor = new Color(red + green + blue,
//                        red + green + blue, red + green + blue);
//                this.bufferedImageOrigin.setRGB(j, i, newColor.getRGB());
//            }
//        }
//        return this.bufferedImageOrigin;
//    }

    public BufferedImage mirror() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixel = this.bufferedImageOrigin.getRGB(x, y);
                Color currentColor = new Color(pixel);
                this.bufferedImageOrigin.setRGB(width - x - 1, y, currentColor.getRGB());
            }
        }
        System.out.println(width);
        System.out.println(height);
        return this.bufferedImageOrigin;
    }

    public BufferedImage showBorders() {
        Color previousPixel = null;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int currentRgb = this.bufferedImageOrigin.getRGB(x, y);
                Color currentColor = new Color(currentRgb);
                if (previousPixel != null && !isSimilarColor(previousPixel, currentColor)) {
                    this.bufferedImageOrigin.setRGB(x, y, Color.BLACK.getRGB());
                }
                previousPixel = currentColor;
            }
        }
        return this.bufferedImageOrigin;
    }

    public boolean isSimilarColor(Color color1, Color color2) {
        boolean similar = false;
        int redDiff = Math.abs(color1.getRed() - color2.getRed());
        int greenDiff = Math.abs(color1.getGreen() - color2.getGreen());
        int blueDiff = Math.abs(color1.getBlue() - color2.getBlue());
        if (redDiff + greenDiff + blueDiff < 20) {
            similar = true;
        }
        return similar;
    }
}