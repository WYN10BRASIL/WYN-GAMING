import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Imagem extends JLabel{

	public Imagem(String name){
        ImageIcon icon = new ImageIcon(Imagem.class.getResource("/Imagens/" + name));
        
        setIcon(icon);
        repaint();
        setOpaque(false);

    }
}