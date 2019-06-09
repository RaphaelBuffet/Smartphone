package Gallery;


import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class GalleryImages extends JPanel {

    //gestion des files
    private File folderGallery = new File("C:\\Users\\srhmr\\OneDrive\\Bureau\\cours\\PROGOBJET\\PROJET\\Smartphone\\src\\res\\Gallery");
    private ArrayList<File> filesImage = new ArrayList<>(Arrays.asList(folderGallery.listFiles()));
    private ArrayList<JButton> listButton = new ArrayList<>();
    private transient BufferedImage image;



    //divers
    private int index = 0;
    private int a;
    private Date pressedTime;
    private long timeClicked;


    //panel
    private JPanel panelImages = new JPanel();
    private JLayeredPane fullImage = new JLayeredPane();
    private JScrollPane scrollImages = new JScrollPane(panelImages);

    //jFram
    private JFrame frameConfirmation = new JFrame();

    //dimension
    private Dimension dimensionImagesButton = new Dimension(90,90);
    private Dimension dimensionImages = new Dimension(480,700);

    //class
    private ImageFullScreen imageFullScreen = new ImageFullScreen();
    private Border emptyBorder = BorderFactory.createEmptyBorder();
    private GalleryApp galleryApp;

    public GalleryImages(GalleryApp galleryApp){
        this.galleryApp = galleryApp;

        //this.thumbnail143143 = cropedImage(143, 143);
        //this.thumbnail480300 = cropedImage(480, 300);

        setBackground(Color.BLACK);
        setPreferredSize(dimensionImages);

        fullImage.setSize(dimensionImages);
        fullImage.setBackground(Color.BLACK);

        scrollImages.setPreferredSize(new Dimension(480, 700));
        scrollImages.setVerticalScrollBarPolicy(scrollImages.VERTICAL_SCROLLBAR_ALWAYS);
        scrollImages.setBorder(emptyBorder);

        panelImages.setBackground(Color.BLACK);
        panelImages.setLayout(new MigLayout("wrap 4"));
        add(imageFullScreen, BorderLayout.CENTER);

        displayImages();

        add(scrollImages,BorderLayout.CENTER);

        imageFullScreen.setVisible(false);


    }

    /*** METHODES ***/

    //boucle pour créer la miniature de chaque image dans la gallerie
    public void displayImages () {
        for (index = 0; index< filesImage.size(); index++){
            listButton.add(index, new JButton(new ImageIcon(new ImageIcon(String.valueOf(filesImage.get(index))).getImage().getScaledInstance(115,100, Image.SCALE_SMOOTH))));
            listButton.get(index).setBorder(emptyBorder);
            listButton.get(index).addMouseListener(new ActionImage());
            /*listButton.get(index).setOpaque(true);
            listButton.get(index).setBackground(Color.BLACK);
            listButton.get(index).setBorder(new RoundedBorder(10));*/
            panelImages.add(listButton.get(index)).setPreferredSize(dimensionImagesButton);
        }
    }

    //afficher en plain écran l'image sélectionner
    public void displayImage(){
        scrollImages.setVisible(false);
        imageFullScreen.setVisible(true);
        imageFullScreen.add(new JLabel(new ImageIcon(new ImageIcon(String.valueOf(filesImage.get(index))).getImage().getScaledInstance(480,700, Image.SCALE_SMOOTH))));
        galleryApp.getGalleryHeader().getButtonAddImage().setVisible(false);
        galleryApp.getGalleryHeader().getButtonBackGallery().setVisible(true);
    }

    //supprimer une image
    public void deleteImages(){
        filesImage.get(index).delete();
        refraishGallery();
    }

    public void refraishGallery(){
        removeAll();
        add(new GalleryImages(galleryApp));
        revalidate();
        System.out.println("refraishGALLERY");
    }

    /*** GETTER SETTER***/
    public File getFolderGallery(File file) {
        return folderGallery;
    }

    public int getIndex() {
        return index;
    }

    public ArrayList<File> getFilesImage() {
        return filesImage;
    }

    public ArrayList<JButton> getListButton() {
        return listButton;
    }

    /*** CLASS ***/
    //Arrondire les bouttons
    class RoundedBorder implements Border{
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

        /*** LISTENER ***/

    //afficher la gallerie
    class ActionImage implements MouseListener {

            @Override
            public void mouseClicked(MouseEvent e) {
                for (index = 0; index < filesImage.size(); index++) {
                    if (e.getSource() == listButton.get(index)) {
                        displayImage();
                        System.out.println("mousClicked is working");
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                pressedTime = new Date();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                timeClicked = new Date().getTime() - pressedTime.getTime();
                if (timeClicked >= 300) {
                    a = JOptionPane.showConfirmDialog(frameConfirmation, "Supprimer l'image?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    frameConfirmation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frameConfirmation.setPreferredSize(new Dimension(50,50));

                    for (index = 0; index < filesImage.size(); index++) {
                        if (e.getSource() == listButton.get(index)) {
                            if(a == JOptionPane.YES_OPTION){
                                deleteImages();
                            }
                        }
                        if (a == JOptionPane.NO_OPTION){
                            frameConfirmation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        }
                    }
                    System.out.println("moussPressed is working");

                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
   }
}
