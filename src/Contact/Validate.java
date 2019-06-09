package Contact;

import javax.swing.*;
import java.awt.*;

public class Validate {

    //controle les champs requis
    public boolean isNotEmpty(JTextField textField)
    {
        if (textField.getText().isEmpty())
        {
            textField.setBackground(new Color(222, 44, 60));
            textField.setText("Champ obligatoire");
            textField.setForeground(Color.WHITE);
            return false;
        }
        if(textField.getBackground().equals(new Color(222, 44, 60)))
            return false;
        return true;
    }
    //controle les pattern des numero de telephone
    public boolean phoneValide(JTextField textField)
    {
        String phonePattern = "(\\+41)?(\\s)?(0)?\\d{2}(\\s)?\\d{3}(\\s)?\\d{2}(\\s)?\\d{2}";
        String phonePattern2 = "(0041)?(\\s)?(0)?\\d{2}(\\s)?\\d{3}(\\s)?\\d{2}(\\s)?\\d{2}";
        String phonePatternLocal="(0)?(\\s)?\\d{2}(\\s)?\\d{3}(\\s)?\\d{2}(\\s)?\\d{2}";
        String phonePatternHotline = "(0800)(\\s)?\\d{3}(\\s)?\\d{3}";
        String phonePatternUrgence = "\\d{3}";

        if (textField.getText().matches(phonePattern) == false && textField.getText().matches(phonePattern2) == false
                && textField.getText().matches(phonePatternHotline) == false
                && textField.getText().matches(phonePatternUrgence) == false
                && textField.getText().matches(phonePatternLocal)== false)
        {
            textField.setBackground(new Color(222, 44, 60));
            textField.setText("Numero invalide");
            textField.setForeground(Color.WHITE);
            return false;
        }
        if(textField.getBackground().equals(new Color(222, 44, 60)))
            return false;
        return true;
    }
}
