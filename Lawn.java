import javax.swing.*;
import java.awt.*;
class Lawn extends JPanel implements MowerObserver {
    private int[][] lawn;
    private LawnMower mower;
    private int cellSize;

    public Lawn(int n, int m, LawnMower mower, int cellSize) {
        this.lawn = new int[n][m];
        this.mower = mower;
        this.cellSize = cellSize;
        this.mower.attach(this);
        setPreferredSize(new Dimension(m * cellSize, n * cellSize));
    }

    @Override
    public void update(int i, int j) {
        lawn[i][j] = 1;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < lawn.length; i++) {
            for (int j = 0; j < lawn[i].length; j++) {
                if (lawn[i][j] == 1) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.BLUE);
                }
                g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                g.setColor(Color.BLACK);
                g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
        // Draw the mower as a smaller dot with a different color (e.g., dark green)
        int dotSize = cellSize / 2;
        g.setColor(new Color(0, 100, 0)); // Dark green
        g.fillOval(mower.getJ() * cellSize + dotSize / 2, mower.getI() * cellSize + dotSize / 2, dotSize, dotSize);
    }
}