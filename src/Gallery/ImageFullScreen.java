package Gallery;

import javax.swing.*;
import java.awt.*;

public class ImageFullScreen extends JPanel {

    //dimension
    private Dimension dimensionImages = new Dimension(480,700);


    public ImageFullScreen(){
        setVisible(true);
        setPreferredSize(dimensionImages);
        setLayout(new BorderLayout());
    }
}
