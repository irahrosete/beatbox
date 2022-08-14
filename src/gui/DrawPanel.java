package gui;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawPanel extends JPanel implements ControllerEventListener {
    private boolean msg = false;

    @Override
    public void controlChange(ShortMessage event) {
        msg = true;
        repaint();
    }

    public void paintComponent (Graphics graphics) {
        Random random = new Random();
        if (msg) {
            int r = random.nextInt(250);
            int g = random.nextInt(250);
            int b = random.nextInt(250);

            graphics.setColor(new Color(r, g, b));

            int height = random.nextInt(120) + 10;
            int width = random.nextInt(120) + 10;
            int xPos = random.nextInt(40) + 10;
            int yPos = random.nextInt(40) + 10;

            graphics.fillRect(xPos, yPos, width, height);
            msg = false;
        }
    }
}
