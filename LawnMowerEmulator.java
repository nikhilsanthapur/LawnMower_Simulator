import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LawnMowerEmulator {

    public static void main(String[] args) {
        int n = 15; // Number of rows in the lawn
        int m = 15; // Number of columns in the lawn
        int cellSize = 50; // Size of each cell in the lawn

        LawnMower mower = new LawnMower(0, -1, n, m);
        Lawn lawn = new Lawn(n, m, mower, cellSize);

        JFrame frame = new JFrame("Lawn Mower");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        frame.add(buttonPanel, BorderLayout.NORTH);

        JButton startButton = new JButton("Start");
        buttonPanel.add(startButton);

        JButton stopButton = new JButton("Stop");
        buttonPanel.add(stopButton);

        frame.add(lawn, BorderLayout.CENTER);

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mower.move();

                if (mower.getI() == mower.getN() - 1 && mower.getJ() == 0) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}

