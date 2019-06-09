package Ressources;

import Gallery.GalleryImages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Contacts.*;
import Gallery.*;


public class ContactFlatForm extends JPanel {
	
	private JLabel nom = new JLabel("Nom");
	private JLabel prenom = new JLabel("Prenom");
	private JLabel phone = new JLabel("T�l�phone");
	private JLabel adresse = new JLabel("Adresse");
	private JLabel mail = new JLabel("Mail");

	private FlatTextField tnom;
	private FlatTextField tprenom;
	private FlatTextField tphone;
	private FlatTextField tadresse;
	private FlatTextField tmail;

	private Button delete = new Button(new ImageIcon("image/icons/bin.png"), 480, 40, new Color(222, 44, 60));

	private FlowLayout flowLayout = new FlowLayout();
	private JPanel gridPanel = new JPanel(flowLayout);
	private JPanel topPanel = new JPanel(new BorderLayout());
	private JPanel formulairePanel = new JPanel(new GridLayout(5, 2, 10, 10));
	private JPanel bottomPanel = new JPanel(new GridLayout(1, 1, 10, 10));

	private Dimension dimension = new Dimension(400, 200); // dimension des panels et textfield
	private Font font22 = new Font("Montserrat", Font.BOLD, 22); // Changement police en Montserrat, Gras,22px
	private Font font18 = new Font("Montserrat", Font.BOLD, 18);

	private JButton profilePhoto;
	private GalleryImages photo;
	private Contact contact;
	private boolean editable;

	/**
	 * Constructeur du formulaire editable
	 * @param editable
	 */
	public ContactFlatForm(boolean editable) 
	{
		this.editable = editable;
		this.profilePhoto = new Button(new ImageIcon("image/icons/photoprofile.png"), 480, 300);
		paintPanel();
	}
	/**
	 * Constructeur du formulaire de modification non editable
	 * @param contact
	 * @param editable
	 */

	public ContactFlatForm(Contact contact, boolean editable) 
	{
		this.contact = contact;
		this.editable = editable;
		this.profilePhoto = new Button(contact.getProfilePhoto(), 480, 300);
		paintPanel();
		setFieldsText();
		gridPanel.add(bottomPanel);
		bottomPanel.setPreferredSize(new Dimension(400, 60));
		bottomPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
		bottomPanel.setOpaque(false);
	}
	/**
	 * Methode de dessin du panel
	 */

	private void paintPanel() 
	{
		setLayout(new BorderLayout());
		setOpaque(false);

		tnom = new FlatTextField(editable, Color.WHITE, Color.BLACK);
		tprenom = new FlatTextField(editable, Color.WHITE, Color.BLACK);
		tphone = new FlatTextField(editable, Color.WHITE, Color.BLACK);
		tadresse = new FlatTextField(editable, Color.WHITE, Color.BLACK);
		tmail = new FlatTextField(editable, Color.WHITE, Color.BLACK);

		add(gridPanel);
		gridPanel.add(topPanel);

		flowLayout.setVgap(0);
		topPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
		topPanel.setPreferredSize(new Dimension(480, 300));
		topPanel.add(profilePhoto);

		gridPanel.add(formulairePanel);
		formulairePanel.setPreferredSize(dimension);

		gridPanel.setOpaque(true);
		topPanel.setOpaque(false);
		formulairePanel.setOpaque(false);
		gridPanel.setBackground(new Color(162,222,208)); // cr�er sa propre couleur

		formulairePanel.add(prenom);
		prenom.setFont(font22);
		prenom.setForeground(Color.WHITE);
		formulairePanel.add(tprenom);

		formulairePanel.add(nom);
		nom.setFont(font22);
		nom.setForeground(Color.WHITE);
		formulairePanel.add(tnom);

		formulairePanel.add(phone);
		phone.setFont(font22);
		phone.setForeground(Color.WHITE);
		formulairePanel.add(tphone);

		formulairePanel.add(adresse);
		adresse.setFont(font22);
		adresse.setForeground(Color.WHITE);
		formulairePanel.add(tadresse);

		formulairePanel.add(mail);
		mail.setFont(font22);
		mail.setForeground(Color.WHITE);
		formulairePanel.add(tmail);
	}
	/**
	 * M�thode d'�criture dans les textfields
	 */

	private void setFieldsText() 
	{
		tprenom.setText(contact.getPrenom());
		tnom.setText(contact.getNom());
		tphone.setText(contact.getTelephone());
		tadresse.setText(contact.getAdresse());
		tmail.setText(contact.getMail());
	}
	/**
	 * M�thode du reset des textfields
	 */

	public void resetTextField()
	{
		tnom.setText(null);
		tprenom.setText(null);
		tphone.setText(null);
		tadresse.setText(null);
		tmail.setText(null);
	}
	/**
	 * M�thode de modificatio du mode editable des textfields
	 */

	public void changeEditable() 
	{
		editable = !editable;
		tnom.changeEditable();
		tprenom.changeEditable();
		tphone.changeEditable();
		tadresse.changeEditable();
		tmail.changeEditable();

		if (editable) 
		{
			bottomPanel.add(delete);
			updateUI();
		}

		if (editable == false) 
		{
			bottomPanel.removeAll();
			updateUI();
		}
	}
	/**
	 * M�thode de validation
	 * @return valide/nonvalide
	 */

	public boolean validation() 
	{
		boolean validated;
		Validate validate = new Validate();
		validated = validate.isNotEmpty(tprenom);
		if(!validated)
			return validated;
		validated = validate.isNotEmpty(tphone);
		if(!validated)
			return validated;
		validated = validate.phoneValide(tphone);
		if(!validated)
			return validated;
		return validated;
	}
	/**
	 * M�thode qui retourn le contact modifi�
	 * @return contact modifi�
	 */

	public Contact getModifiedContact() 
	{
		contact.setPrenom(tprenom.getText());
		contact.setNom(tnom.getText());
		contact.setTelephone(tphone.getText());
		contact.setAdresse(tadresse.getText());
		contact.setMail(tmail.getText());
		
		if (photo != null)
			contact.setPhoto(photo);

		return contact;
	}
	/**
	 * M�thode qui retourne le nouveau contact
	 * @param id
	 * @return nouveau contact
	 */

	public Contact getNewContact(int id) 
	{
		if (photo != null)
			return new Contact(id, tprenom.getText(), tnom.getText(), tphone.getText(), tadresse.getText(),
					tmail.getText(), photo);
		
		return new Contact(id, tprenom.getText(), tnom.getText(), tphone.getText(), tadresse.getText(),
				tmail.getText());
	}
	/**
	 * Met � jour la photo
	 * @param photo
	 */

	public void updatePhoto(GalleryImages photo)
	{
		this.photo = photo;
		topPanel.remove(profilePhoto);
		profilePhoto = new Button(photo.getThumbnail480300(), 480, 300);
		topPanel.add(profilePhoto);
		updateUI();
	}
	/**
	 * Listener sur le clique d'ajout d'une photo
	 * @param actionListener
	 */

	public void AddPhotoClick(ActionListener actionListener) 
	{
		profilePhoto.addActionListener(actionListener);
	}
	/**
	 * Listener sur le cliquer de suppression d'un contact
	 * @param actionListener
	 */

	public void AddDeleteClick(ActionListener actionListener) 
	{
		delete.addActionListener(actionListener);
	}
}
