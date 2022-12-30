import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TelaPanel  extends JPanel implements ActionListener{
	private JPanel telas;
    private CardLayout controleTela;
    
    public TelaPanel(JPanel telas, JFrame janela) {
        
        this.telas = telas; 
        this.controleTela = (CardLayout) telas.getLayout(); 
        this.setLayout(null);
         
    }
   


    @Override
    public void actionPerformed(ActionEvent e) {
        executarBotao(e);
        
    }
    protected void executarBotao(ActionEvent e){
        
    }
    protected void trocarTela(String identificador){
        controleTela.show(telas, identificador);
    }
}