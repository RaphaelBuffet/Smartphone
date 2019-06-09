package Gallery;


import frame.FrameBases;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GalleryApp extends JPanel {

    private GalleryImages galleryImages = new GalleryImages(this);
    private GalleryHeader galleryHeader = new GalleryHeader(this);
    private ArrayList<GalleryImages> photos = new ArrayList<GalleryImages>();

    //constructeur
    public GalleryApp(FrameBases frameBases){

        //header de la gallerie
        setBackground(Color.BLACK);
        add(galleryHeader, BorderLayout.NORTH);
        add(galleryImages, BorderLayout.SOUTH);
    }

    public GalleryHeader getGalleryHeader(){
        return galleryHeader;
    }

    public GalleryImages getGalleryImages() {
        return galleryImages;
    }

    public ArrayList<GalleryImages> getPhotos()
    {
        return photos;
    }
}
