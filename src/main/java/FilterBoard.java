import com.sun.org.apache.bcel.internal.generic.IXOR;

import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FilterBoard extends JPanel {

    public static final int LABEL_Y = 150, LABEL_WIDTH = 300, LABEL_HEIGHT = 50;
    public static final int TITLE_Y = 20, TITLE_WIDTH = 800, TITLE_HEIGHT = 100;
    public static final int IMAGE_X = 50, IMAGE_Y = 200, IMAGE_WIDTH = 550, IMAGE_HEIGHT = 650;
    public static final int BUTTON_Y = 200, BUTTON_WIDTH = 300, BUTTON_HEIGHT = 50;
    public static final int SEARCH_WIDTH = 150, SEARCH_HEIGHT = 50;

    private JLabel title;
    private JLabel before, after;
    private ImageIcon background;
    private BufferedImage imageBefore, imageAfter;
    private JTextField searchTextField;
    private JButton searchButton;
    private JButton grayscale, colorShiftRight, colorShiftLeft, showBorders, sepia, negative;

    public FilterBoard(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        buttons();
        action();
        this.title = CreateNew.newTitleLibel("Playing With Filters", Main.WINDOW_WIDTH / 2 - TITLE_WIDTH / 2, TITLE_Y, TITLE_WIDTH, TITLE_HEIGHT);
        this.add(this.title);
        this.before = CreateNew.newLabel("Before:", IMAGE_X, LABEL_Y, LABEL_WIDTH, LABEL_HEIGHT);
        this.add(this.before);
        this.after = CreateNew.newLabel("After:", Main.WINDOW_WIDTH - IMAGE_WIDTH - IMAGE_X, LABEL_Y, LABEL_WIDTH, LABEL_HEIGHT);
        this.add(this.after);
        this.imageBefore = new ImageFile().getOriginImage();
        this.imageAfter = new ImageFile().getOriginImage();
        this.background = new ImageIcon("background.png");
        this.setVisible(true);
    }

    public void action() {
        Thread thread = new Thread(() -> {
            this.colorShiftRight.addActionListener((event) -> {
                this.imageAfter = new ImageFile().getOriginImage();
                this.imageAfter = new FiltersOptions(this.imageAfter).colorShiftRightFilter();
                repaint();
                new ImageFile().saveNewImage(this.imageAfter);
            });
            this.colorShiftLeft.addActionListener((event) -> {
                this.imageAfter = new ImageFile().getOriginImage();
                this.imageAfter = new FiltersOptions(this.imageAfter).colorShiftLeftFilter();
                repaint();
                new ImageFile().saveNewImage(this.imageAfter);
            });
            this.showBorders.addActionListener((event) -> {
                this.imageAfter = new ImageFile().getOriginImage();
                this.imageAfter = new FiltersOptions(this.imageAfter).showBorders();
                repaint();
                new ImageFile().saveNewImage(this.imageAfter);
            });
            this.grayscale.addActionListener((event) -> {
                this.imageAfter = new ImageFile().getOriginImage();
                this.imageAfter = new FiltersOptions(this.imageAfter).GrayscaleFilter();
                repaint();
                new ImageFile().saveNewImage(this.imageAfter);
            });
            this.sepia.addActionListener((event) -> {
                this.imageAfter = new ImageFile().getOriginImage();
                this.imageAfter = new FiltersOptions(this.imageAfter).sepiaFilter();
                repaint();
                new ImageFile().saveNewImage(this.imageAfter);
            });
            this.negative.addActionListener((event) -> {
                this.imageAfter = new ImageFile().getOriginImage();
                this.imageAfter = new FiltersOptions(this.imageAfter).negativeFilter();
                repaint();
                new ImageFile().saveNewImage(this.imageAfter);
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
        graphics.drawImage(this.imageBefore, IMAGE_X, IMAGE_Y, IMAGE_WIDTH, IMAGE_HEIGHT, null);
        graphics.drawImage(this.imageAfter, Main.WINDOW_WIDTH - IMAGE_WIDTH - IMAGE_X, IMAGE_Y, IMAGE_WIDTH, IMAGE_HEIGHT, null);
    }

}