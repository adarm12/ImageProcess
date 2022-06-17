import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;

import java.io.File;
import java.io.IOException;

public class FilterBoard extends JPanel {

    public static final int IMAGE_X = 50;
    public static final int IMAGE_Y = 100;
    public static final int IMAGE_WIDTH = 550;
    public static final int IMAGE_HEIGHT = 650;
    public static final int BUTTON_Y = 150;
    public static final int SEARCH_WIDTH = 150;
    public static final int SEARCH_HEIGHT = 50;
    public static final int BUTTON_WIDTH = 300;
    public static final int BUTTON_HEIGHT = 50;

    public static final String WEB = "https://www.facebook.com/oshrikarmni";
    private JLabel imageLabelBefore;
    private JLabel imageLabelAfter;
    private JTextField searchTextField;
    private JButton searchButton;
    private JButton colorShiftRight;
    private JButton colorShiftLeft;
    private JButton showBorders;
    private JButton eliminateRed;
    private JButton sepia;


    public FilterBoard(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        File file1 = new File("C:\\Users\\shani\\Desktop\\לימודים שנה א\\מדמח\\קבצים תוכנית\\dora\\Dora.jpg");
        File file2 = new File("\"C:\\Users\\adarm\\Pictures\\Saved Pictures\\Dora.jpg\"");

//        ImageIcon image = new ImageIcon(file2.getPath());
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
        this.eliminateRed = CreateNew.newButton("Eliminate Red", Main.WINDOW_WIDTH / 2 - BUTTON_WIDTH / 2, this.showBorders.getY() + BUTTON_HEIGHT * 2, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(this.eliminateRed);
        this.sepia = CreateNew.newButton("Sepia", Main.WINDOW_WIDTH / 2 - BUTTON_WIDTH / 2, this.eliminateRed.getY() + BUTTON_HEIGHT * 2, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(this.sepia);

        ImageIcon image = new ImageIcon("Dora.jpg");
        imageLabelBefore = new JLabel(image);
        imageLabelBefore.setBounds(IMAGE_X, IMAGE_Y, IMAGE_WIDTH, IMAGE_HEIGHT);
        this.add(imageLabelBefore);
        imageLabelAfter = new JLabel(image);
        imageLabelAfter.setBounds(Main.WINDOW_WIDTH - this.imageLabelBefore.getWidth() - IMAGE_X , IMAGE_Y, IMAGE_WIDTH, IMAGE_HEIGHT);
        this.add(imageLabelAfter);


        this.setVisible(true);
    }


    public void web() {
        try {
            Document web = Jsoup.connect(WEB).get();
            //   Element profileId = web.(contains("jsc_c")).getElementById();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
