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
import java.io.IOException;
import java.sql.SQLException;
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

	Controlador Controlador;

	private int LinhasArquivoInstantes;
	private int ArquivoDeInstanteSelecionado;

	public PainelBotoes(JLabel[][] labels) throws SQLException {
		Controlador = new Controlador();
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

		LerDadosDeOutrosParticipantes = new CriarBotoes("ler dados de outros participantes", Color.DARK_GRAY);
		ProceessarProximoInstante = new CriarBotoes("proceessar proximo instante", Color.DARK_GRAY);
		LerNovoArquivoDeEntrada = new CriarBotoes("ler novo arquivo de entrada", Color.DARK_GRAY);
		GravarArquivoDeSaida = new CriarBotoes("gravar arquivo de saida", Color.DARK_GRAY);
		GravarRelatorio = new CriarBotoes("gravar relatorio", Color.DARK_GRAY);

		ImageIcon ImagemPhyton = new ImageIcon(getClass().getResource("Imagens/phyton.png"));
		ImageIcon ImagemJavaScript = new ImageIcon(getClass().getResource("Imagens/JavaScript.png"));
		ImageIcon ImagemRuby = new ImageIcon(getClass().getResource("Imagens/Ruby.png"));
		ImageIcon ImagemPhp = new ImageIcon(getClass().getResource("Imagens/Php.jpg"));
		ImageIcon ImagemCSharp = new ImageIcon(getClass().getResource("Imagens/C#.jpg"));
		ImageIcon ImagemCPlus = new ImageIcon(getClass().getResource("Imagens/Cplus.png"));
		ImageIcon ImagemC = new ImageIcon(getClass().getResource("Imagens/C.jpg"));
		ImageIcon ImagemBugs = new ImageIcon(getClass().getResource("Imagens/BugImage.png"));
		ImageIcon ImagemDevs = new ImageIcon(getClass().getResource("Imagens/DevsImage.png"));

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
					JOptionPane.showMessageDialog(null, "selecione o arquivo de instantes primeiro",
							"selecione um arquivo", JOptionPane.INFORMATION_MESSAGE);
				} else {

					if (LinhasArquivoInstantes < ArquivoDeInstanteSelecionado) {

						LimparCelulasPlanetas(labels, Controlador.getSistema().getPlanetas());

						Controlador.ContabilizarDados(Controlador.getLer().getBugs().get(LinhasArquivoInstantes),
								Controlador.getLer().getDevs().get(LinhasArquivoInstantes), LinhasArquivoInstantes,
								ImagensPlanetas);

						PosicoesPlanetas = Controlador.PassarPosicoesPlanetas();
						PosicoesBugs  = Controlador.PassarPosicoesBugs();
						PosicoesDevs  = Controlador.PassarPosicoesDevs();

						MoverPlanetas(Controlador.getSistema().getPlanetas(), PosicoesPlanetas, ImagensPlanetas,labels);
						AdcionarBusgAndDevs(PosicoesBugs, PosicoesDevs, ImagemBugs, ImagemDevs, labels);

						AvisarMortePlanetas();

						LinhasArquivoInstantes++;

					} else {
						JOptionPane.showMessageDialog(null, "todos instantes ja lidos", "o cruzeiro vai cair",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}

			}
		});

		LerNovoArquivoDeEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LinhasArquivoInstantes = 0;
				PainelEscolhaDeArquivos = new PainelArquivos(PainelBotoes.this);
			}
		});

		GravarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Controlador.getPlanetaDAO().inserir(Controlador.getSistema().getPlanetas(),
						Controlador.getSistema().getBugsQd(), Controlador.getSistema().getDevsQd(),
						ArquivoDeInstanteSelecionado);

				JOptionPane.showMessageDialog(null, "Dados enviados para o banco com sucesso!", "Gravação de relatorio",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		LerDadosDeOutrosParticipantes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					Controlador.AnalisarDados();
					JOptionPane.showMessageDialog(null, "Dados coletados com sucesso", "Coleta de dados",JOptionPane.INFORMATION_MESSAGE);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block  
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	
		GravarArquivoDeSaida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				try {
					Controlador.GerarArquivoSaida();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	public void LimparCelulasPlanetas(JLabel[][] labels, ArrayList<Planetas> planetas) {

		for (int k = 0; k < planetas.size(); k++) {
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 15; j++)
					if (i == planetas.get(k).posicaoX && j == planetas.get(k).posicaoY) {
						labels[i][j].setIcon(null);
					}
			}
		}
	}

	public void MoverPlanetas(ArrayList<Planetas> planetas, ArrayList<Integer> posicoes, ArrayList<ImageIcon> imagens,
			JLabel[][] labels) {
		int contadorImagem = 0;
		for (int i = 0; i < posicoes.size(); i += 2) {
			if (planetas.get(contadorImagem).isStatus()) {
				setImagem(labels, posicoes.get(i), posicoes.get(i + 1), imagens.get(contadorImagem));
			}
			contadorImagem++;
		}
	}

	public void AdcionarBusgAndDevs(ArrayList<Integer> posicoesBugs, ArrayList<Integer> posicoesDevs,
			ImageIcon imagemBugs, ImageIcon imagemDevs, JLabel[][] labels) {
		for (int i = 0; i < posicoesBugs.size(); i += 2) {
			setImagemBugsAndDevs(labels, posicoesBugs.get(i), posicoesBugs.get(i + 1), imagemBugs);
		}
		for (int i = 0; i < posicoesDevs.size(); i += 2) {
			setImagemBugsAndDevs(labels, posicoesDevs.get(i), posicoesDevs.get(i + 1), imagemDevs);
		}
	}

	public void setImagem(JLabel[][] labels, int linha, int coluna, ImageIcon imagem) {
		if (linha >= 0 && linha < 15 && coluna >= 0 && coluna < 15) {
			labels[linha][coluna].setIcon(imagem);
			redimensionarImagem(labels[linha][coluna], imagem);
		}
	}

	public void setImagemBugsAndDevs(JLabel[][] labels, int linha, int coluna, ImageIcon imagem) {
		if (labels[linha][coluna].getIcon() == null) {
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

	public void setArquivoDeInstanteSelecionado(int arquivoDeInstanteSelecionado) {
		ArquivoDeInstanteSelecionado = arquivoDeInstanteSelecionado;
	}

	public int getArquivoDeInstanteSelecionado() {
		return ArquivoDeInstanteSelecionado;
	}

	public void AvisarMortePlanetas() {
		boolean TodosMortos = true;

		for (int i = 0; i < Controlador.getSistema().getPlanetas().size(); i++) {
			if (Controlador.getSistema().getPlanetas().get(i).isStatus() == true) {
				TodosMortos = false;
			}
		}
		if (TodosMortos && Controlador.getSistema().getBugsList().size()
				+ Controlador.getSistema().getDevsList().size() <= 224) {

			JOptionPane.showMessageDialog(null,
					"parabens, voce MATOU todos os planetas, nao há mais o que se fazer aqui");
			Controlador.getSistema().ImprimirDados();
		}
	}

}
