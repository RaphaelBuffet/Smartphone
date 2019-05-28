package Memory;

import frame.FrameBases;

import javax.swing.*;
import java.awt.*;

public class MemoryApp extends JPanel {

    private BorderLayout borderLayout;

    public MemoryApp(FrameBases frameBases) {
        BorderLayout borderLayout = new BorderLayout();

        add(new MemoryCards());
        setLayout(borderLayout);

    }

}
