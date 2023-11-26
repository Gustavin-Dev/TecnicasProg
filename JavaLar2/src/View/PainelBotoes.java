package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controll.*;

public class PainelBotoes extends JPanel {

	JPanel PainelBotoes;
	PainelArquivos PainelEscolhaDeArquivos;

	JButton ProceessarProximoInstante;
	JButton LerNovoArquivoDeEntrada;
	JButton GravarRelatorio;
	JButton LerDadosDeOutrosParticipantes;
	JButton GravarArquivoDeSaida;

	ArrayList<ImageIcon> ImagensPlanetas;
	ArrayList<Integer> PosicoesPlanetas;
	ArrayList<Integer> PosicoesBugs;
	ArrayList<Integer> PosicoesDevs;

	MenuJavaLar menu;

	private int LinhasArquivoInstantes;
	private int ArquivoDeInstanteSelecionado;
 

	public PainelBotoes(JLabel[][] labels) {
		menu = new MenuJavaLar();
		PainelBotoes = new JPanel();

		LinhasArquivoInstantes = 0;
		ArquivoDeInstanteSelecionado = 0;

		setPreferredSize(new Dimension(450, 800));
		setLayout(new GridBagLayout());
		setBackground(Color.black);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);

		LerDadosDeOutrosParticipantes      = new CriarBotoes("ler dados de outros participantes", Color.DARK_GRAY);
		ProceessarProximoInstante         = new CriarBotoes("proceessar proximo instante", Color.DARK_GRAY);
		LerNovoArquivoDeEntrada          = new CriarBotoes("ler novo arquivo de entrada", Color.DARK_GRAY);
		GravarArquivoDeSaida            = new CriarBotoes("gravar arquivo de saida", Color.DARK_GRAY);
		GravarRelatorio                = new CriarBotoes("gravar relatorio", Color.DARK_GRAY);

		ImageIcon ImagemPhyton       = new ImageIcon(getClass().getResource("imagemPHYTON.png"));
		ImageIcon ImagemJavaScript  = new ImageIcon(getClass().getResource("imagemJAVASCRIPT.png"));
		ImageIcon ImagemRuby       = new ImageIcon(getClass().getResource("imagemRUBY.png"));
		ImageIcon ImagemPhp       = new ImageIcon(getClass().getResource("imagemPHP.jpg"));
		ImageIcon ImagemCSharp   = new ImageIcon(getClass().getResource("imagemC#.jpg"));
		ImageIcon ImagemCPlus   = new ImageIcon(getClass().getResource("CPLUSPLUS.png"));
		ImageIcon ImagemC      = new ImageIcon(getClass().getResource("imagemC.jpg"));
		ImageIcon ImagemBugs  = new ImageIcon(getClass().getResource("BugImage.png"));
		ImageIcon ImagemDevs = new ImageIcon(getClass().getResource("DevsImage.png"));

		ImagensPlanetas = new ArrayList<ImageIcon>();
		ImagensPlanetas.add(ImagemPhyton);
		ImagensPlanetas.add(ImagemJavaScript);
		ImagensPlanetas.add(ImagemRuby);
		ImagensPlanetas.add(ImagemPhp);
		ImagensPlanetas.add(ImagemCSharp);
		ImagensPlanetas.add(ImagemCPlus);
		ImagensPlanetas.add(ImagemC);

		add(ProceessarProximoInstante, gbc);
		add(LerNovoArquivoDeEntrada, gbc);
		add(GravarRelatorio, gbc);
		add(LerDadosDeOutrosParticipantes, gbc);
		add(GravarArquivoDeSaida, gbc);

		ProceessarProximoInstante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (PainelEscolhaDeArquivos == null) {
					JOptionPane.showMessageDialog(null, "selecione o arquivo de instantes primeiro");
				} else {

					ArquivoDeInstanteSelecionado = PainelEscolhaDeArquivos.getAE();
					menu.InstanciarLeituraArquivo(ArquivoDeInstanteSelecionado);
					
					if (LinhasArquivoInstantes < ArquivoDeInstanteSelecionado) {
						
						LimparCelulas(labels);
						
						menu.ContabilizarDados(menu.getSistema(), menu.getFuncoesPlanetarias(),menu.getLer(),
								menu.getLer().getBugs().get(LinhasArquivoInstantes),
								menu.getLer().getDevs().get(LinhasArquivoInstantes),LinhasArquivoInstantes,ImagensPlanetas);

						PosicoesPlanetas = menu.PassarPosicoesPlanetas();
						PosicoesBugs     = menu.PassarPosicoesBugs();
						PosicoesDevs     = menu.PassarPosicoesDevs();
						
						MoverPlanetas(PosicoesPlanetas, ImagensPlanetas, labels);
						AdcionarBusgAndDevs(PosicoesBugs, PosicoesDevs, ImagemBugs, ImagemDevs, labels);
						menu.getSistema().ImprimirQuadrantes();

						if (menu.getSistema().getPlanetas().size() == 0 && menu.getSistema().getBugsList().size()
										+ menu.getSistema().getDevsList().size() <= 224) {
							
							JOptionPane.showMessageDialog(null, "parabens, voce MATOU todos os planetas, nao há mais o que se fazer aqui");
						}

						LinhasArquivoInstantes++;

					} else {
						JOptionPane.showMessageDialog(null, "todos instantes ja lidos");
					}
				}
				
			}
		});

		LerNovoArquivoDeEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinhasArquivoInstantes = 0;
				PainelEscolhaDeArquivos = new PainelArquivos();
			}
		});
	}

	public void LimparCelulas(JLabel[][] labels) {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (i == 7 & j == 7)
					continue;
				labels[i][j].setIcon(null);
			}
		}
	}

	public void MoverPlanetas(ArrayList<Integer> posicoes, ArrayList<ImageIcon> imagens, JLabel[][] labels) {
		int contadorImagem = 0;
		for (int i = 0; i < posicoes.size(); i += 2) {
			setImagem(labels, posicoes.get(i), posicoes.get(i + 1), imagens.get(contadorImagem));
			contadorImagem++;
		}
	}

	public void AdcionarBusgAndDevs(ArrayList<Integer> posicoesBugs, ArrayList<Integer> posicoesDevs,
			ImageIcon imagemBugs, ImageIcon imagemDevs, JLabel[][] labels) {
		for (int i = 0; i < posicoesBugs.size(); i += 2) {
			setImagem(labels, posicoesBugs.get(i), posicoesBugs.get(i + 1), imagemBugs);
		}
		for (int i = 0; i < posicoesDevs.size(); i += 2) {
			setImagem(labels, posicoesDevs.get(i), posicoesDevs.get(i + 1), imagemDevs);
		}
	}

	public void setImagem(JLabel[][] labels, int linha, int coluna, ImageIcon imagem) {
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
}
