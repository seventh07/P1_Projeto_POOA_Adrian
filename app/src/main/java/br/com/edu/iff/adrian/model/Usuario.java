package br.com.edu.iff.adrian.model;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import io.realm.annotations.Required;

@RealmClass
public class Usuario extends RealmObject {

    @PrimaryKey
    private int id;
    @Required
    private String nome, login, senha;
    private int funcao_id;


    public Usuario(){

    }

    public Usuario(int id, String nome, String login, String senha, int funcao_id){
        this.setId(id);
        this.setNome(nome);
        this.setLogin(login);
        this.setSenha(senha);
        this.setFuncao_id(funcao_id);
    }

    public Usuario(String login, String senha){
        this.setLogin(login);
        this.setSenha(senha);
    }

    public Usuario findByLogin(String login){
        Realm realm = Realm.getDefaultInstance();
        Usuario usuario = new Usuario();
        try {
            usuario = realm.where(Usuario.class).contains("login", login).findFirst();
        }finally{
            realm.close();
        }
        return usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getFuncao_id() {
        return funcao_id;
    }

    public void setFuncao_id(int funcao_id) {
        this.funcao_id = funcao_id;
    }

}

