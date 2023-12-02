package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelPrincipal extends JFrame {

    JFrame painelPrincipal;
    PainelUniverse painelDoUniverso;
    PainelBotoes painelDosBotoes;

    public PainelPrincipal() throws SQLException {
        painelPrincipal = new JFrame();

        setSize(1200, 800);
        setBackground(Color.black);
        getContentPane().setLayout(new BorderLayout());
      

        painelDoUniverso = new PainelUniverse();
        painelDosBotoes = new PainelBotoes(painelDoUniverso.labels);

        getContentPane().add(painelDoUniverso, BorderLayout.CENTER);
        getContentPane().add(painelDosBotoes, BorderLayout.EAST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        revalidate(); // Revalida o layout
        repaint();    // Repinta os componentes
    }
}
