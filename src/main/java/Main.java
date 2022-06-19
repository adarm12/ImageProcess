import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.IOException;

public class Main extends JFrame {

    public static final int WINDOW_WIDTH = 1700, WINDOW_HEIGHT = 955;

    public Main() throws IOException {

        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Image Process By Adar & Shanit");
        this.add(new FilterBoard(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT));

        this.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }
}