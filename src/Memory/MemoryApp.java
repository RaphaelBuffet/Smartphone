package Memory;

import frame.FrameBases;

import javax.swing.*;
import java.awt.*;

public class MemoryApp extends JPanel {

    public MemoryApp(FrameBases frameBases) {
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);

        add(new MemoryHeader(),BorderLayout.NORTH);
        add(new MemoryCards(),BorderLayout.CENTER);

    }

}
