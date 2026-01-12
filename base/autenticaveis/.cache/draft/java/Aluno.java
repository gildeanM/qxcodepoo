public class Aluno implements Autenticavel{

    private String nome;
    private String curso;
    private int bolsa;

    private String senha;
    private boolean logado;

    public Aluno(String nome, String curso, int bolsa) {
        this.nome = nome;
        this.curso = curso;
        this.bolsa = bolsa;

        this.senha = "indefinida";
        this.logado = false;
    }

    @Override
    public void logar(String senha) {
        if(!this.senha.equalsIgnoreCase(senha))
            throw new MsgException("fail: senha invalida");

        this.setLogado(true);
    }

    @Override
    public void deslogar() {
        this.setLogado(false);
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String getSenha() {
        return this.senha;
    }

    @Override
    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    @Override
    public String getLogado() {
        return (this.logado ? "online" : "offline");
    }
    
    @Override
    public String toString(){
        return String.format(
                "alu:%s:%s:%d",
                this.nome,
                this.curso,
                this.bolsa
        );
    }
    
}
