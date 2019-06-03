package Gallery;

import Ressources.Button;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GalleryHeader extends JPanel {

    private JFrame delConf = new JFrame();

    private File dir = new File("src/res/Gallery");

    private JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    //class
    private GalleryApp galleryApp;
    private GalleryImages galleryImages;


    //listener
    private ActionHeader actionHeader = new ActionHeader();

    //button
    private Button buttonAddImage = new Button(new ImageIcon(getClass().getClassLoader().getResource("res/Icons/add.png")), new Color(255, 255, 255), new Color(181, 164, 154));
    private Button buttonDeleteImage = new Button(new ImageIcon(getClass().getClassLoader().getResource("res/Icons/delete.png")), new Color(255, 255, 255), new Color(181, 164, 154));
    private Button buttonBackGallery = new Button(new ImageIcon(getClass().getClassLoader().getResource("res/Icons/retour.png")), new Color(0, 0, 0), new Color(181, 164, 154));
    private Button buttonEdit = new Button(new ImageIcon(getClass().getClassLoader().getResource("res/Icons/edit.png")), new Color(255, 255, 255), new Color(181, 164, 154));

    public GalleryHeader(GalleryApp galleryApp) {
        this.galleryApp = galleryApp;
        galleryImages = new GalleryImages(galleryApp);

        buttonAddImage.addActionListener(actionHeader);
        buttonBackGallery.addActionListener(actionHeader);

        buttonAddImage.setVisible(true);
        buttonBackGallery.setVisible(false);

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(480, 60));

        setLayout(new BorderLayout());
        add(buttonAddImage, BorderLayout.WEST);
        add(buttonBackGallery, BorderLayout.CENTER);
    }

    public Button getButtonAddImage() {
        return buttonAddImage;
    }

    public Button getButtonDeleteImage() {
        return buttonDeleteImage;
    }

    public Button getButtonBackGallery() {
        return buttonBackGallery;
    }

    public Button getButtonEdit() {
        return buttonEdit;
    }

    public void moveFiles(String f1, String f2) throws IOException {
        Path result = null;
        try {
            result = Files.copy(Paths.get(f1), Paths.get(f2));
        } catch (IOException e) {
            System.out.println("Exception while moving file: " + e.getMessage());
        }
        if (result != null) {
            System.out.println("File moved successfully.");
            galleryApp.getGalleryImages().refraishGallery();
        } else {
            new JOptionPane().showMessageDialog(delConf,
                    "Cette image existe deja dans la gallerie! Veuillez la renomer!",
                    "Warning!",
                    JOptionPane.WARNING_MESSAGE);
            System.out.println("File movement failed. You need to rename the file");
        }
    }

    //ajouter ou supprimer une image
    public class ActionHeader implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            //ajouter une image à la gallerie
            if (e.getSource() == buttonAddImage) {
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif, png");
                    jfc.setFileFilter(filter);
                    int returnVal = jfc.showOpenDialog(getParent());
                    if(returnVal == JFileChooser.APPROVE_OPTION) {
                        System.out.println("You chose to open this file: " +
                                jfc.getSelectedFile().getName());
                    }

                    File f1 = jfc.getSelectedFile();
                    String pathName = f1.getAbsolutePath().substring(f1.getAbsolutePath().lastIndexOf("\\") + 1);
                    try {
                        moveFiles(String.valueOf(jfc.getSelectedFile()), (galleryImages.getFolderGallery(dir)) + "\\" + pathName);
                        // FLAG POUR ECRASER UNE IMAGE
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                if (e.getSource() == buttonDeleteImage) {

                }

                if (e.getSource() == buttonBackGallery) {
                    galleryApp.getGalleryImages().refraishGallery();
                    buttonAddImage.setVisible(true);
                    buttonBackGallery.setVisible(false);
                }

                if (e.getSource() == buttonEdit) {

                }
            }
        }
    }
