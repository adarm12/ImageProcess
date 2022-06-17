
import javax.swing.*;

public class Main extends JFrame {

    public static final int WINDOW_WIDTH = 1400, WINDOW_HEIGHT = 955;

    public Main() {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Image Process By Adar & Shanit");

        this.add(new FilterBoard(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT));

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}