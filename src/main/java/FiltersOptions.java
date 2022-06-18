
import java.awt.*;
import java.awt.image.BufferedImage;

public class FiltersOptions {

    public static final int MAX_RGB = 255;
    public static final int BORDERS = 20;
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

    public BufferedImage sepiaFilter() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixel = this.bufferedImageOrigin.getRGB(x, y);
                Color color = new Color(pixel, true);

                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int avg = (red + green + blue) / 3;
                int depth = 20;
                int intensity = 30;
                red = avg + (depth * 2);
                green = avg + depth;
                blue = avg - intensity;

                if (red > MAX_RGB) red = MAX_RGB;
                if (green > MAX_RGB) green = MAX_RGB;
                if (blue > MAX_RGB) blue = MAX_RGB;
                if (blue < 0) blue = 0;

                color = new Color(red, green, blue);
                this.bufferedImageOrigin.setRGB(x, y, color.getRGB());
            }
        }
        return this.bufferedImageOrigin;
    }


//    public BufferedImage mirror() {
//        for (int x = 0; x < width; x++) {
//            for (int y = 0; y < height; y++) {
//                int pixel = this.bufferedImageOrigin.getRGB(x, y);
//                Color currentColor = new Color(pixel);
//                this.bufferedImageOrigin.setRGB(width - x - 1, y, currentColor.getRGB());
//            }
//        }
//        return this.bufferedImageOrigin;
//    }

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
        if (redDiff + greenDiff + blueDiff < BORDERS) {
            similar = true;
        }
        return similar;
    }

    public BufferedImage negativeFilter() {
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                int currentRgb = this.bufferedImageOrigin.getRGB(x, y);
                Color color = new Color(currentRgb, true);
                color = new Color(MAX_RGB - color.getRed(), MAX_RGB - color.getGreen(), MAX_RGB - color.getBlue());
                this.bufferedImageOrigin.setRGB(x, y, color.getRGB());
            }
        }
        return this.bufferedImageOrigin;
    }

}