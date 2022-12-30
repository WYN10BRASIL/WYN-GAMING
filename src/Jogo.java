import org.json.JSONObject;

/**
 * Jogo
 */
public class Jogo {
    private String nome;
    private String caminho;
    private String icone;
    private String fundo;

    public Jogo(String nome, String caminho, String icone, String fundo){
        this.nome = nome;
        this.caminho = caminho;
        this.icone = icone;
        this.fundo = fundo;

    }
    public Jogo(JSONObject jogoJObject){

        
        this.nome = jogoJObject.getString("nome");
        this.caminho = jogoJObject.getString("caminho");
        this.icone = jogoJObject.getString("icone");
        this.fundo = jogoJObject.getString("fundo");
        
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCaminho() {
        return caminho;
    }
    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    public String getIcone() {
        return icone;
    }
    public void setIcone(String icone) {
        this.icone = icone;
    }
    public String getFundo() {
        return fundo;
    }
    public void setFundo(String fundo) {
        this.fundo = fundo;
    }
}