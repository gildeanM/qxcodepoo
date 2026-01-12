import java.util.Map;
import java.util.TreeMap;

public class Sistema {

    private UFC ufc;
    private Map<String, Autenticavel> usuarios;

    public Sistema(){
        this.ufc = new UFC();
        this.usuarios = new TreeMap<String, Autenticavel>();
    }

    public UFC getUFC(){
        return this.ufc;
    }

    public Autenticavel getUsuario(String nome){

        Autenticavel usuario;

        try{
            usuario = (Autenticavel) this.ufc.getFuncionario(nome);
            if(usuario != null)
                return usuario;
        }catch (Exception e){
            throw new MsgException("fail: terc nao pode ser cadastrado no sistema");
        }

        usuario = this.ufc.getAluno(nome);
        return usuario;

    }

    public void addUsuario(String nome, String senha) {
        var newUsuario = this.getUsuario(nome);

        if(newUsuario == null)
            throw new MsgException(String.format("fail: %s nao encontrado", nome));

        newUsuario.setSenha(senha);

        this.usuarios.put(nome, newUsuario);
    }

    public void rmUsuario(String nome) {

        if(!this.usuarios.containsKey(nome))
            throw new MsgException(String.format("fail: usuario %s nao encontrado", nome));

        this.usuarios.remove(nome);
    }

    public void logar(String nome, String senha) {

        if(!this.usuarios.containsKey(nome))
            throw new MsgException(String.format("fail: usuario %s nao encontrado", nome));

        this.usuarios.get(nome).logar(senha);
    }

    public void deslogar(String nome) {

        if(!this.usuarios.containsKey(nome))
            throw new MsgException(String.format("fail: usuario %s nao encontrado", nome));

        this.usuarios.get(nome).deslogar();

    }
    public void deslogarTodos() {
        for(Autenticavel autenticavel : this.usuarios.values()){
            autenticavel.deslogar();
        }
    }

    public String showUser( String nome ) {

        if(!this.usuarios.containsKey(nome))
            throw new MsgException(String.format("fail: usuario %s nao encontrado", nome));

        var user = this.usuarios.get(nome);
        
        return String.format(
                "%s:%s:%s",
                user.toString(),
                user.getSenha(),
                user.getLogado()
        );
    }

    @Override
    public String toString() {
        String s = "";
        for ( Autenticavel u : this.usuarios.values() ) {
            s += u + ":" + u.getSenha() + ":" + u.getLogado() + "\n";
        }
        return s;
    }



}
