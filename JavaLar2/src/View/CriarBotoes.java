package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CriarBotoes extends JButton implements ActionListener {

	public CriarBotoes(String texto, Color cor) {
		setText(texto);
		setForeground(Color.white);
		setBackground(cor);
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
			
	}

}
