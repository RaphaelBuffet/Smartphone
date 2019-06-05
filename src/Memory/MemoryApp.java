package Memory;

import frame.FrameBases;

import javax.swing.*;
import java.awt.*;

public class MemoryApp extends JPanel {

    private MemoryHeader memoryHeader = new MemoryHeader(this);
    private MemoryCards memoryCards = new MemoryCards(this);


    public MemoryApp(FrameBases frameBases) {
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);

        add(memoryHeader,BorderLayout.NORTH);
        add(memoryCards,BorderLayout.CENTER);

    }

    public void resetGame(){
        remove(memoryCards);
        memoryCards=new MemoryCards(this);
        add(memoryCards);
        revalidate();
        System.out.println("reset game");
    }

    public MemoryHeader getMemoryHeader() {
        return memoryHeader;
    }

    public MemoryCards getMemoryCards() {
        return memoryCards;
    }
}
