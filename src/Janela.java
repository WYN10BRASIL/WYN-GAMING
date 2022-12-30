import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;


public class Janela extends JFrame{

    public Janela(){ 
        setSize(1280, 720);
 
        CardLayout controleTela = new CardLayout();
        JPanel telas = new JPanel(controleTela);

        BibliotecaPanel bibliotecaPanel = new BibliotecaPanel(telas, this);
        telas.add(bibliotecaPanel, "Tela Biblioteca");



        this.add(telas);
        this.setVisible(true);
    }
}

