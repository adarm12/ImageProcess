import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FilterBoard extends JPanel {

    public static final int IMAGE_X = 50, IMAGE_Y = 150, IMAGE_WIDTH = 550, IMAGE_HEIGHT = 650;
    public static final int BUTTON_Y = 150, BUTTON_WIDTH = 300, BUTTON_HEIGHT = 50;
    public static final int SEARCH_WIDTH = 150, SEARCH_HEIGHT = 50;

    private ImageIcon background;
    private BufferedImage imageLabelBefore, imageLabelAfter;
    private JTextField searchTextField;
    private JButton searchButton;
    private JButton grayscale, colorShiftRight, colorShiftLeft, showBorders, sepia, negative;

    public FilterBoard(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        buttons();
        action();
        this.imageLabelBefore = new ImageFile().getOriginImage();
        this.imageLabelAfter = new ImageFile().getOriginImage();
        this.background = new ImageIcon("background.png");
        this.setVisible(true);
    }

    public void action() {
        Thread thread = new Thread(() -> {
            this.colorShiftRight.addActionListener((event) -> {
                this.imageLabelAfter = new ImageFile().getOriginImage();
                this.imageLabelAfter = new FiltersOptions(this.imageLabelAfter).colorShiftRightFilter();
                repaint();
                new ImageFile().saveNewImage(this.imageLabelAfter);
            });
            this.colorShiftLeft.addActionListener((event) -> {
                this.imageLabelAfter = new ImageFile().getOriginImage();
                this.imageLabelAfter = new FiltersOptions(this.imageLabelAfter).colorShiftLeftFilter();
                repaint();
                new ImageFile().saveNewImage(this.imageLabelAfter);
            });
            this.showBorders.addActionListener((event) -> {
                this.imageLabelAfter = new ImageFile().getOriginImage();
                this.imageLabelAfter = new FiltersOptions(this.imageLabelAfter).showBorders();
                repaint();
                new ImageFile().saveNewImage(this.imageLabelAfter);
            });
            this.grayscale.addActionListener((event) -> {
                this.imageLabelAfter = new ImageFile().getOriginImage();
                this.imageLabelAfter = new FiltersOptions(this.imageLabelAfter).GrayscaleFilter();
                repaint();
                new ImageFile().saveNewImage(this.imageLabelAfter);
            });
            this.sepia.addActionListener((event) -> {
                this.imageLabelAfter = new ImageFile().getOriginImage();
                this.imageLabelAfter = new FiltersOptions(this.imageLabelAfter).sepiaFilter();
                repaint();
                new ImageFile().saveNewImage(this.imageLabelAfter);
            });
            this.negative.addActionListener((event) -> {
                this.imageLabelAfter = new ImageFile().getOriginImage();
                this.imageLabelAfter = new FiltersOptions(this.imageLabelAfter).negativeFilter();
                repaint();
                new ImageFile().saveNewImage(this.imageLabelAfter);
            });
        });
        thread.start();
    }

    public void buttons() {
        this.searchTextField = CreateNew.newTextField(Main.WINDOW_WIDTH / 2 - BUTTON_WIDTH / 2, BUTTON_Y, SEARCH_WIDTH, SEARCH_HEIGHT);
        this.add(this.searchTextField);
        this.searchButton = CreateNew.newButton("Search", this.searchTextField.getX() + SEARCH_WIDTH, BUTTON_Y, SEARCH_WIDTH, SEARCH_HEIGHT);
        this.add(this.searchButton);
        this.colorShiftRight = CreateNew.newButton("Color Shift Right", Main.WINDOW_WIDTH / 2 - BUTTON_WIDTH / 2, this.searchTextField.getY() + SEARCH_HEIGHT * 2, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(this.colorShiftRight);
        this.colorShiftLeft = CreateNew.newButton("Color Shift Left", Main.WINDOW_WIDTH / 2 - BUTTON_WIDTH / 2, this.colorShiftRight.getY() + BUTTON_HEIGHT * 2, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(this.colorShiftLeft);
        this.showBorders = CreateNew.newButton("Show Borders", Main.WINDOW_WIDTH / 2 - BUTTON_WIDTH / 2, this.colorShiftLeft.getY() + BUTTON_HEIGHT * 2, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(this.showBorders);
        this.grayscale = CreateNew.newButton("grayscale", Main.WINDOW_WIDTH / 2 - BUTTON_WIDTH / 2, this.showBorders.getY() + BUTTON_HEIGHT * 2, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(this.grayscale);
        this.sepia = CreateNew.newButton("sepia", Main.WINDOW_WIDTH / 2 - BUTTON_WIDTH / 2, this.grayscale.getY() + BUTTON_HEIGHT * 2, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(this.sepia);
        this.negative = CreateNew.newButton("negative", Main.WINDOW_WIDTH / 2 - BUTTON_WIDTH / 2, this.sepia.getY() + BUTTON_HEIGHT * 2, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(this.negative);
    }

    public void paintComponent(Graphics graphics) {
        graphics.drawImage(this.background.getImage(), 0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT, null);
        graphics.drawImage(this.imageLabelBefore, IMAGE_X, IMAGE_Y, IMAGE_WIDTH, IMAGE_HEIGHT, null);
        graphics.drawImage(this.imageLabelAfter, Main.WINDOW_WIDTH - IMAGE_WIDTH - IMAGE_X, IMAGE_Y, IMAGE_WIDTH, IMAGE_HEIGHT, null);
    }

}