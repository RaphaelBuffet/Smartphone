package Gallery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class displayFullImage implements ActionListener {

    private GalleryApp galleryApp;

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < galleryApp.getGalleryImages().getFilesImage().size(); i++) {
            if (e.getSource() == galleryApp.getGalleryImages().getListButton().get(i)) {
                galleryApp.getGalleryImages().displayImages();
            }
        }
    }
}