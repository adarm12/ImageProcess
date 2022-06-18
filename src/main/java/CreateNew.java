import javax.swing.*;
import java.awt.*;

public class CreateNew {

    public static final Font FONT = new Font("Gisha", Font.BOLD, 30);
    public static final Font TITLE_FONT = new Font("Gisha", Font.BOLD, 80);

    public static JLabel newLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setForeground(Color.black);
        label.setFont(FONT);
        return label;
    }

    public static JLabel newTitleLibel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setForeground(new Color(255,0,127));
        label.setFont(TITLE_FONT);
        return label;
    }

    public static JTextField newTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setFont(FONT);
        return textField;
    }

    public static JButton newButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(FONT);
        button.setFocusable(false);
        return button;
    }

}
