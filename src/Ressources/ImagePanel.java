package Ressources;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Classe : ImagePanel <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Auteur : Rafael Peixoto <br/>
 * Nom de la classe : ImagePanel <br/>
 * Extension : JPanel<br/>
 * Description de la classe : Cette classe g�re l'image en arri�re-plan dans un panel<br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Entr�e(s) : - <br/>
 * Sortie : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 * Remarque : - <br/>
 * ------------------------------------------------------------------------------------------------------ <br/>
 */
public class ImagePanel extends JPanel {
	
	ImageIcon image;

	/**
	 * Constructeur du panel
	 * @param image
	 */
	public ImagePanel(ImageIcon image) 
	{
		this.image = image;
	}

	@Override
	protected void paintComponent(Graphics g) 
	{
		g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
	}
}
