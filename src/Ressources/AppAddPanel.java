package Ressources;

import java.awt.Color;
import Ressources.Button;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AppAddPanel extends AppInterface {

	private ImageIcon imgSave = new ImageIcon("image/icons/save.png");
	private JButton save = new Ressources.Button(imgSave);

	private ImageIcon imgcancel = new ImageIcon("image/icons/Back.png");
	private JButton cancel = new Button(imgcancel);


	 // Constructeur des entetes d'ajout


	public AppAddPanel(String PANELNAME, Color COLORPANEL)
	{
		super(PANELNAME, COLORPANEL); 
		panelButton1.add(save);
		panelButton2.add(cancel);

	}

	// Getters et setters
	public JButton getSave() 
	{
		return save;
	}

	public JButton getCancel() 
	{
		return cancel;
	}

	public void setCancel(JButton cancel) 
	{
		this.cancel = cancel;
	}
}