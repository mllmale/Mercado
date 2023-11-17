import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class myFrame extends JFrame {
    private ImageIcon image;
    private JPanel cadastroPanel;
    private JPanel consultaPanel;
    private JPanel pesquisaPanel;
    public myFrame() throws IOException {
        setTitle("Mercado");
        image= new ImageIcon("logo_mercado.png");
        this.setIconImage(image.getImage());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600, 420);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        this.setLocation(x, y);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFocusable(false);

        cadastroPanel = new Cadastro();
        tabbedPane.addTab("Cadastro", cadastroPanel);

        consultaPanel = new Consulta(); 
        tabbedPane.addTab("Consulta", consultaPanel);

        pesquisaPanel = new Pesquisa(); 
        tabbedPane.addTab("Pesquisa", pesquisaPanel);

        getContentPane().add(tabbedPane);

        setLocationRelativeTo(null);

        setVisible(true);
    }

}
