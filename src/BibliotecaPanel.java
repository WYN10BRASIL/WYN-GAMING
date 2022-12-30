import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.json.JSONArray;
import org.json.JSONObject;

public class BibliotecaPanel extends TelaPanel{
    public ArrayList<Jogo> jogos;
    private JPanel grid;


	public BibliotecaPanel(JPanel telas, JFrame janela){

        super(telas, janela);
        this.jogos = new ArrayList<Jogo>();

        grid = new JPanel(new FlowLayout(FlowLayout.LEFT, 22, 22));
        grid.setBackground(Color.decode("202028"));

        this.setLayout(null);
        this.setBackground(Color.decode("#202028"));

        carregarJogos();
        exibirJogos();

       JScrollPane panel = new JScrollPane(grid);
       panel.setBounds(50, 50, 1820, 1020);
       this.add(panel);

    }

    public void carregarJogos(){
        String jsonString = lerJsonJogos();
        JSONArray jsonArray = new JSONArray(jsonString);

        for(int i = 0; i < jsonArray.length(); i++) {
        JSONObject jogoJObject = (JSONObject) jsonArray.get(i);
        jogos.add(new Jogo(jogoJObject));
    }
        for (Jogo jogo : jogos){
        System.out.println(jogo.getFundo());
        } 
    }


    public void exibirJogos(){
            int altura = (jogos.size()/7 )*322 + 20;
            grid.setPreferredSize(new Dimension(500 , altura));

            int posicaoX = 50;
            int posicaoY = 50;
            final int POSICAO_MAX_X = 1430;

        for (Jogo jogo : jogos) {
            String fundo = jogo.getFundo();
            Imagem imagem = new Imagem(fundo);
            imagem.setBounds(posicaoX, posicaoY,  231, 300);
            imagem.setOpaque(true);
            imagem.setVisible(true);
            this.add(imagem);

            posicaoX += 30 + 231;
            if (posicaoX > POSICAO_MAX_X) {
                posicaoX = 50;
                posicaoY += 20 + 300;                
            }
            System.out.println(fundo);  
            
            imagem.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e){
                    String caminho = jogo.getCaminho();
                    executarJogo(caminho);

                }
            });

           this.add(imagem);
        }
    }
    private void executarJogo(String caminho)   {
        File arquivo = new File(caminho);
        String pasta = arquivo.getAbsoluteFile().getParent();
        try {
            Runtime.getRuntime().exec(caminho, null, new File(pasta));    
        } catch (IOException e) {
    e.printStackTrace();
        }
    }

    public String lerJsonJogos(){
        File arquivoJson = new File("src/JSON/Jogos.json");
        StringBuilder conteudoArquivo = new StringBuilder();
        try {
          BufferedReader leitor = new BufferedReader(new FileReader(arquivoJson));
            String linha = leitor.readLine();
            while (linha != null) {
                conteudoArquivo.append(linha);
                linha = leitor.readLine();
            }
            leitor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conteudoArquivo.toString();
        
    }
}