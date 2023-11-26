 package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PainelUniverse extends JPanel {

	JPanel painel1;
	JLabel[][] labels;
	ImageIcon ImagemJava;
	ImageIcon ImagemPhyton;
	ImageIcon ImagemJavaScript;
	ImageIcon ImagemRuby;
	ImageIcon ImagemPhp;
	ImageIcon ImagemCSharp;
	ImageIcon ImagemCPlus;
	ImageIcon ImagemC;


	public PainelUniverse() {
		painel1 = new JPanel();
		setPreferredSize(new Dimension(750, 800));
		setLayout(new GridLayout(15, 15));
		
	

		labels = new JLabel[15][15];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				labels[i][j] = new JLabel();
				labels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				labels[i][j].setOpaque(true);
				labels[i][j].setText(i+"x"+j);
				labels[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				add(labels[i][j]);
				if(i == 7|| j == 7) {
					labels[i][j].setBackground(Color.black);
				}
			}
		}
		labels[7][7].setBackground(Color.BLACK);
//		AdcionarImagens();

	}

	public void setImagem(int linha, int coluna, ImageIcon imagem) {
		if (linha >= 0 && linha < 15 && coluna >= 0 && coluna < 15) {
			labels[linha][coluna].setIcon(imagem);
			redimensionarImagem(labels[linha][coluna], imagem);
		}
	}

	private void redimensionarImagem(JLabel label, ImageIcon imagem) {
		if (label.getWidth() > 0 && label.getHeight() > 0) {
			Image img = imagem.getImage();
			Image novaImagem = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon imagemRedimensionada = new ImageIcon(novaImagem);
			label.setIcon(imagemRedimensionada);
		} else {
			label.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					redimensionarImagem(label, imagem);
					label.removeComponentListener(this);
		  		}
			});
		}
	}

	public void AdcionarImagens() {
		ImagemJava       = new ImageIcon(getClass().getResource("imagemJAVA.png"));
		ImagemPhyton     = new ImageIcon(getClass().getResource("imagemPHYTON.png"));
		ImagemJavaScript = new ImageIcon(getClass().getResource("imagemJAVASCRIPT.png"));
		ImagemRuby       = new ImageIcon(getClass().getResource("imagemRUBY.png"));
		ImagemPhp        = new ImageIcon(getClass().getResource("imagemPHP.jpg"));
		ImagemCSharp     = new ImageIcon(getClass().getResource("imagemC#.jpg"));
		ImagemCPlus      = new ImageIcon(getClass().getResource("CPLUSPLUS.png"));
		ImagemC          = new ImageIcon(getClass().getResource("imagemC.jpg"));

		setImagem(7, 7, ImagemJava);
		setImagem(6, 7, ImagemPhyton);
		setImagem(5, 7, ImagemJavaScript);
		setImagem(4, 7, ImagemRuby);
		setImagem(3, 7, ImagemPhp);
		setImagem(2, 7, ImagemCSharp);
		setImagem(1, 7, ImagemCPlus);
		setImagem(0, 7, ImagemC);
	}

}

