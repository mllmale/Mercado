import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Consulta extends JPanel implements ActionListener{

    private JButton buttonR;
    private JPanel tabelaItens;
    private JScrollPane scrollPane;
    private JLabel tituloL;
    private JPanel tabela;
    private JLabel descricao;
    private JLabel codigo;
    private JLabel valor;
    private JLabel qtd;

    Consulta() throws IOException{

        this.buttonR = new JButton("R");
        this.buttonR.setBounds(520, 40, 40, 40);
        this.buttonR.setFont(new Font("Arial", Font.BOLD, 19));
        this.buttonR.setFocusable(false);
        this.buttonR.addActionListener(this);
        setLayout(null);
        this.add(buttonR);

        tituloL  = new JLabel("CONSULTA"); 
        this.tituloL.setBounds(180, 30, 250, 60);
        this.tituloL.setFont(new Font("Arial", Font.BOLD, 40));
        setLayout(null);
        this.add(tituloL);

        //------------- Tabela Layout -------------\\
        this.tabela = new JPanel(new FlowLayout(FlowLayout.CENTER, 70, 12));
        this.tabela.setBounds(20, 90, 540, 40);
        this.tabela.setBackground(new Color(128,128,128));
        this.add(tabela);

        descricao  = new JLabel("PRODUTO"); 
        //descricao.setAlignmentX(20);
        this.descricao.setFont(new Font("Arial", Font.BOLD, 15));
        this.tabela.add(descricao);

        codigo  = new JLabel("CÓDIGO"); 
        //codigo.setBounds(20, 90, 360, 50);
        this.codigo.setFont(new Font("Arial", Font.BOLD, 15));
        this.tabela.add(codigo);

        valor  = new JLabel("VALOR"); 
        //valor.setBounds(20, 90, 360, 50);
        this.valor.setFont(new Font("Arial", Font.BOLD, 15));
        this.tabela.add(valor);

        qtd  = new JLabel("QTD."); 
        //qtd.setBounds(20, 90, 360, 50);
        this.qtd.setFont(new Font("Arial", Font.BOLD, 15));
        this.tabela.add(qtd);

        //setLocation(null);
        setVisible(true);

        //------------- Tabela Itens -------------\\
        tabelaItens = new JPanel();
        tabelaItens.setLayout(new BoxLayout(tabelaItens, BoxLayout.Y_AXIS));

        ArrayList<ArrayList<String>> dadosGrupo = new ArrayList<>();
        Arquivo arquivo = new Arquivo();

        try {
            arquivo.ler(dadosGrupo);
            for (ArrayList<String> grupo : dadosGrupo) {
                JPanel grupoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 75,15));

                for (String elemento : grupo) {
                    JLabel label = new JLabel(elemento);
                    //label.setBounds(20, 10, 60, 10);
                    label.setPreferredSize(new Dimension(55, 15));
                    label.setFont(new Font("Arial", Font.BOLD, 18));
                    grupoPanel.add(label);
                }

                tabelaItens.add(grupoPanel);

                tabelaItens.add(Box.createRigidArea(new Dimension(0, 5)));
            }

            scrollPane = new JScrollPane(tabelaItens);
            JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
            verticalScrollBar.setUnitIncrement(10);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setBounds(20, 130, 541, 200);
            this.add(scrollPane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonR) {
            tabelaItens.removeAll();

            ArrayList<ArrayList<String>> dadosGrupo = new ArrayList<>();
            Arquivo arquivo = new Arquivo();

            try {
                arquivo.ler(dadosGrupo);

                for (ArrayList<String> grupo : dadosGrupo) {
                    JPanel grupoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 75, 15));

                    for (String elemento : grupo) {
                        JLabel label = new JLabel(elemento);
                        label.setPreferredSize(new Dimension(55, 15));
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        grupoPanel.add(label);
                    }
                    tabelaItens.add(grupoPanel);
                    tabelaItens.add(Box.createHorizontalStrut(30));
                }
                revalidate();
                repaint();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
