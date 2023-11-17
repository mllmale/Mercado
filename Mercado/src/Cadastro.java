import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class Cadastro extends JPanel implements ActionListener{
    
    private JButton buttonS;
    private JTextField descricaoF;
    private JTextField codigoF;
    private JTextField valorF;
    private JTextField qtdF;
    private JLabel tituloL;
    private JLabel descricaoL;
    private JLabel codigoL;
    private JLabel valorL;
    private JLabel qtdL;

    Cadastro(){
        
        //-------------Labels--------------\\

        tituloL  = new JLabel("CADASTRO"); 
        this.tituloL.setBounds(170, 30, 250, 60);
        this.tituloL.setFont(new Font("Arial", Font.BOLD, 40));

        descricaoL  = new JLabel("Produto"); 
        this.descricaoL.setBounds(140, 120, 100, 40);
        this.descricaoL.setFont(new Font("Arial", Font.BOLD, 18));

        codigoL  = new JLabel("Código"); 
        this.codigoL.setBounds(140, 160, 100, 40);
        this.codigoL.setFont(new Font("Arial", Font.BOLD, 18));

        valorL  = new JLabel("Valor"); 
        this.valorL.setBounds(140, 200, 100, 40);
        this.valorL.setFont(new Font("Arial", Font.BOLD, 18));

        qtdL  = new JLabel("Quantidade"); 
        this.qtdL.setBounds(140, 240, 120, 40);
        this.qtdL.setFont(new Font("Arial", Font.BOLD, 18));

        //------------ Buttons -------------\\

        buttonS = new JButton("Enviar");
        buttonS.setBounds(280, 285, 150, 40);
        buttonS.setFont(new Font("Arial", Font.BOLD, 18));
        buttonS.setFocusable(false);
        buttonS.addActionListener(this);

        //---------- Text Fields ------------//

        qtdF = new JTextField();
        qtdF.setPreferredSize(new Dimension(250, 40));
        qtdF.setBounds(280, 245, 150, 35);
        qtdF.setFont(new Font("Arial", Font.PLAIN, 17));

        valorF = new JTextField();
        valorF.setPreferredSize(new Dimension(250, 40));
        valorF.setBounds(280, 205, 150, 35);
        valorF.setFont(new Font("Arial", Font.PLAIN, 17));

        codigoF = new JTextField();
        codigoF.setPreferredSize(new Dimension(250, 40));
        codigoF.setBounds(280, 165, 150, 35);
        codigoF.setFont(new Font("Arial", Font.PLAIN, 17));

        descricaoF = new JTextField();
        descricaoF.setPreferredSize(new Dimension(250, 40));
        descricaoF.setBounds(280, 125, 150, 35);
        descricaoF.setFont(new Font("Arial", Font.PLAIN, 17));

        //------------ Window -------------\\

        setLayout(null);
        this.add(buttonS);
        this.add(descricaoL);
        this.add(tituloL);
        this.add(codigoL);
        this.add(valorL);
        this.add(qtdL);
        this.add(descricaoF);
        this.add(codigoF);
        this.add(valorF);
        this.add(qtdF);
        
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonS){
            
            ArrayList<String> dados = new ArrayList<String>();
            ArrayList<ArrayList<String>> dadosGrupo = new ArrayList<ArrayList<String>>();
            String descricaoJ = descricaoF.getText(); 
            String descricaoT = descricaoJ.replace(" ", "_");
            String codigoT = codigoF.getText();
            String valorT = valorF.getText();
            String qtdT = qtdF.getText();
            if (descricaoT.isEmpty() || codigoT.isEmpty() || valorT.isEmpty() || qtdT.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else{
                Arquivo arquivo = new Arquivo();
                dados.add(descricaoT);
                dados.add(codigoT);
                dados.add(valorT);
                dados.add(qtdT);
                dadosGrupo.add(dados);
                arquivo.gravar(dadosGrupo);
                JOptionPane.showMessageDialog(null,"Enviado com Sucesso", "Sucesso", JOptionPane.PLAIN_MESSAGE);
                descricaoF.setText("");
                codigoF.setText("");
                valorF.setText("");
                qtdF.setText("");
            }
            
        }
    }

}
