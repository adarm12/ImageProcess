import ij.IJ;
import ij.ImagePlus;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.File;
import java.io.IOException;

public class FilterBoard extends JPanel {

    public static final String WEB = "https://www.facebook.com/oshrikarmni";
    private JLabel label;


    public FilterBoard(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        File file = new File("C:\\Users\\shani\\Desktop\\לימודים שנה א\\מדמח\\קבצים תוכנית\\dora\\Dora.jpg");

        ImageIcon image = new ImageIcon(file.getPath());
        label= new JLabel(image);
        label.setBounds(50,100,500,650);
        this.add(label);



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
