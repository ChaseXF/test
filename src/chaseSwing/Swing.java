package chaseSwing;
import chase.*;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;

public class Swing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World");
        JLabel label = new JLabel("A Label");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setVisible(true);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e){
            throw new AssertionError(e);
        }
        label.setText("label text");
    
        chase h=new chase();
        h.print();
    
    }
}

