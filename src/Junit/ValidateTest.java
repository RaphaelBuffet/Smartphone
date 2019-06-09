package Junit;

import static org.junit.Assert.*;
import java.awt.Color;

import Contact.Validate;
import org.junit.Test;

import javax.swing.*;


public class ValidateTest {

	Validate validate = new Validate();
	JTextField textField = new JTextField();
	Color red = new Color(222, 44, 60);
	
	@org.junit.Test
	public void test() {
		textField.setText("Audrey");
		assertTrue(validate.isNotEmpty(textField));

		textField.setText("0786841723");
		assertTrue(validate.phoneValide(textField));

		textField.setText("078 684 17 23");
		assertTrue(validate.phoneValide(textField));

		textField.setText("+410786841723");
		assertTrue(validate.phoneValide(textField));

		textField.setText("+41 078 684 17 23");
		assertTrue(validate.phoneValide(textField));

		textField.setText("0041 078 684 17 23");
		assertTrue(validate.phoneValide(textField));

		textField.setText("00410786841723");
		assertTrue(validate.phoneValide(textField));

		textField.setText("0800333333");
		assertTrue(validate.phoneValide(textField));

		textField.setText("0800 333 333");
		assertTrue(validate.phoneValide(textField));

		textField.setText("786841723");
		assertTrue(validate.phoneValide(textField));

		textField.setText("78 684 17 23");
		assertTrue(validate.phoneValide(textField));

		textField.setText("+41786841723");
		assertTrue(validate.phoneValide(textField));

		textField.setText("+41 78 684 17 23");
		assertTrue(validate.phoneValide(textField));

		textField.setText("0041 78 684 17 23");
		assertTrue(validate.phoneValide(textField));

		textField.setText("0041786841723");
		assertTrue(validate.phoneValide(textField));

		textField.setText("117");
		assertTrue(validate.phoneValide(textField));

		textField.setText("07868417");
		assertFalse(validate.phoneValide(textField));

		textField.setText("078 684 17 2");
		assertFalse(validate.phoneValide(textField));

		textField.setText("+410786841");
		assertFalse(validate.phoneValide(textField));

		textField.setText("+41 078 684 1");
		assertFalse(validate.phoneValide(textField));

		textField.setText("0041 078 684 1");
		assertFalse(validate.phoneValide(textField));

		textField.setText("004107868417");
		assertFalse(validate.phoneValide(textField));

		textField.setText("08003333");
		assertFalse(validate.phoneValide(textField));

		textField.setText("0800 333 3");
		assertFalse(validate.phoneValide(textField));

		textField.setBackground(red);
		assertFalse(validate.isNotEmpty(textField));

		textField.setText(null);
		assertFalse(validate.isNotEmpty(textField));

	}

}
