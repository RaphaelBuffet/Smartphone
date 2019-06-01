package Gallery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class displayFullImage implements ActionListener {
    private GalleryImages galleryImages = new GalleryImages();

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < galleryImages.getFilesImage().size(); i++) {
            if (e.getSource() == galleryImages.getListButton().get(i)) {
                galleryImages.displayImages();
            }
        }
    }
}