package Gallery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//ajouter ou supprimer une image
public class ActionHeader implements ActionListener {

    private GalleryApp galleryApp;

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == galleryApp.getGalleryHeader().getButtonAddImage()) {


        }
        if (e.getSource() == galleryHeader.getButtonDeleteImage()) {


        }

        if (e.getSource() == galleryHeader.getButtonBackGallery()) {

        }

        if (e.getSource() == galleryHeader.getButtonEdit()) {

        }
    }
}
