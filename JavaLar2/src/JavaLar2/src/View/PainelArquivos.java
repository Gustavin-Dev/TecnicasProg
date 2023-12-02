package View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PainelArquivos extends JFrame{

	JFrame painel;
	
	public PainelArquivos(PainelBotoes painelBotoes) {
		painel = new JFrame();
		painel.setSize(700,300);
		painel.setLocationRelativeTo(null);
		painel.setVisible(true);
		
		
		JPanel paineldentro = new JPanel(new GridBagLayout());
	
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = GridBagConstraints.RELATIVE;;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		
		JButton AE_10   = new JButton("AE_10");
		JButton AE_50   = new JButton("AE_50");
		JButton AE_100  = new JButton("AE_100");
		JButton AE_500  = new JButton("AE_500");
		JButton AE_1000 = new JButton("AE_1000");
		JButton AE_1500 = new JButton("AE_1500");
		JButton AE_2000 = new JButton("AE_2000");
		
		paineldentro.add(AE_10,gbc);
		paineldentro.add(AE_50,gbc);
		paineldentro.add(AE_100,gbc);
		paineldentro.add(AE_500,gbc);
		paineldentro.add(AE_1000,gbc);
		paineldentro.add(AE_1500,gbc);
		paineldentro.add(AE_2000,gbc);
		
		AE_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	painelBotoes.setArquivoDeInstanteSelecionado(10);
            	painelBotoes.Controlador.InstanciarLeituraArquivo(painelBotoes.getArquivoDeInstanteSelecionado());
            	JOptionPane.showMessageDialog(null, "arquivo selecionado!","selecao sucedida", JOptionPane.INFORMATION_MESSAGE);
            }
         });
		
		AE_50.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	painelBotoes.setArquivoDeInstanteSelecionado(50);
            	painelBotoes.Controlador.InstanciarLeituraArquivo(painelBotoes.getArquivoDeInstanteSelecionado());
            	JOptionPane.showMessageDialog(null, "arquivo selecionado!","selecao sucedida", JOptionPane.INFORMATION_MESSAGE);
            }
         });
		
		AE_100.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	painelBotoes.setArquivoDeInstanteSelecionado(100);
            	painelBotoes.Controlador.InstanciarLeituraArquivo(painelBotoes.getArquivoDeInstanteSelecionado());
            	JOptionPane.showMessageDialog(null, "arquivo selecionado!","selecao sucedida", JOptionPane.INFORMATION_MESSAGE);
            }
         });
		
		AE_500.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	painelBotoes.setArquivoDeInstanteSelecionado(500);
            	painelBotoes.Controlador.InstanciarLeituraArquivo(painelBotoes.getArquivoDeInstanteSelecionado());
            	JOptionPane.showMessageDialog(null, "arquivo selecionado!","selecao sucedida", JOptionPane.INFORMATION_MESSAGE);
            }
         });
		
		AE_1000.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	painelBotoes.setArquivoDeInstanteSelecionado(1000);
            	painelBotoes.Controlador.InstanciarLeituraArquivo(painelBotoes.getArquivoDeInstanteSelecionado());
            	JOptionPane.showMessageDialog(null, "arquivo selecionado!","selecao sucedida", JOptionPane.INFORMATION_MESSAGE);
            }
         });
		
		AE_1500.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	painelBotoes.setArquivoDeInstanteSelecionado(1500);
            	painelBotoes.Controlador.InstanciarLeituraArquivo(painelBotoes.getArquivoDeInstanteSelecionado());
            	JOptionPane.showMessageDialog(null, "arquivo selecionado!","selecao sucedida", JOptionPane.INFORMATION_MESSAGE);
            }
         });
		
		AE_2000.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	painelBotoes.setArquivoDeInstanteSelecionado(2000);
            	painelBotoes.Controlador.InstanciarLeituraArquivo(painelBotoes.getArquivoDeInstanteSelecionado());
            	JOptionPane.showMessageDialog(null, "arquivo selecionado!","selecao sucedida", JOptionPane.INFORMATION_MESSAGE);
            }
         });
		
		
		
		paineldentro.setBackground(Color.BLACK);
		paineldentro.setVisible(true);
		
		painel.add(paineldentro);
		
	}
}
