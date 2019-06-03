package Memory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemoryHeader extends JPanel {

    private JButton restart = new JButton("RESTART");
    private JLabel labelScor = new JLabel();

    private ActionHeader actionHeader = new ActionHeader();

    private MemoryApp memoryApp;

    public MemoryHeader(MemoryApp memoryApp) {
        this.memoryApp = memoryApp;

        restart.addActionListener(actionHeader);
        restart.setBackground(Color.BLACK);
        restart.setBorder(new RoundedBorder(10));
        restart.setForeground(Color.PINK);
        labelScor.setForeground(Color.BLACK);


        setPreferredSize(new Dimension(480, 60));
        setBackground(Color.PINK);

        setLayout(new BorderLayout());
        add(restart, BorderLayout.WEST);
        add(labelScor, BorderLayout.EAST);
    }

    class ActionHeader implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == restart) {
                memoryApp.resetGame();
            }
        }
    }

    //Arrondire les bouttons
    class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }

    /*** GETTERS ***/

    public JLabel getLabelScor() {
        return labelScor;
    }
}
