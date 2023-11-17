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
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Pesquisa extends JPanel implements ActionListener {
    private JButton buttonS;
    private JTextField descricaoF;
    private JPanel tabelaItens;
    private JLabel tituloL;
    private JPanel tabela;
    private JLabel descricao;
    private JLabel codigo;
    private JLabel valor;
    private JLabel qtd;

    Pesquisa(){
        tituloL  = new JLabel("PESQUISA"); 
        this.tituloL.setBounds(180, 30, 250, 60);
        this.tituloL.setFont(new Font("Arial", Font.BOLD, 40));
        setLayout(null);
        this.add(tituloL);

        this.buttonS = new JButton("R");
        this.buttonS.setBounds(520, 300, 40, 40);
        this.buttonS.setFont(new Font("Arial", Font.BOLD, 19));
        this.buttonS.setFocusable(false);
        this.buttonS.addActionListener((this));
        setLayout(null);
        this.add(buttonS);

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

       
        JScrollPane scrollPane = new JScrollPane(tabelaItens);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(20, 130, 541, 150); // Ajuste para 150 de altura
        this.add(scrollPane);
        
        descricaoF = new JTextField();
        descricaoF.setPreferredSize(new Dimension(300, 40));
        descricaoF.setBounds(20, 300, 490, 40);
        descricaoF.setFont(new Font("Arial", Font.PLAIN, 17));
        this.add(descricaoF);
    }
    
    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == buttonS) {
        ArrayList<ArrayList<String>> dadosGrupo = new ArrayList<>();
        String descricaoJ = descricaoF.getText(); 
        String descricaoT = descricaoJ.replace(" ", "_");
        

        try {
            Arquivo arquivo = new Arquivo();
            arquivo.ler(dadosGrupo);

            // Remover componentes antigos
            tabelaItens.removeAll();

            for (ArrayList<String> grupo : dadosGrupo) {
                String descricaoProduto = grupo.get(0);

                if (descricaoProduto.equalsIgnoreCase(descricaoT)) {
                    JPanel grupoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 62, 2));

                    for (String elemento : grupo) {
                        JLabel label = new JLabel(elemento);
                        label.setPreferredSize(new Dimension(55, 15));
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        grupoPanel.add(label);
                    }

                    tabelaItens.add(grupoPanel);
                    tabelaItens.add(Box.createRigidArea(new Dimension(0, 5)));
                }
            }
            revalidate();
            repaint();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        descricaoF.setText("");
    }
}

}
